package Network;

import Exceptions.ServerException;
import Managers.FileManager;
import Managers.RunManager;

import java.io.*;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.logging.Logger;

public class Server {


    SocketChannel socketChannel;

    ServerSocketChannel ss;

    private int port;



    private static final Logger serverLogger = Logger.getLogger("logger");

    FileManager fileManager;
    public RunManager runtimeManager;

    BufferedInputStream bf = new BufferedInputStream(System.in);

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bf));


    public Server(RunManager runtimeManager, int port, FileManager fileManager)  {
        this.runtimeManager = runtimeManager;
        this.port = port;
        this.fileManager = fileManager;
    }


    public void run(String path){
    try{
        openServerSocket();
        serverLogger.info("Создано соединение с клиентом");
        while (true) {
            try {
                if (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    if (line.equals("save")) {
                        fileManager.saveObjects(path);
                        serverLogger.info("Коллекция сохранена успешно!");
                    }
                }
            } catch (IOException ignored) {

            }
            try (SocketChannel clientSocket = connectToClient()) {
                if(!processClientRequest(clientSocket)) break;
            } catch (SocketTimeoutException ignored) {
            } catch (IOException exception) {

                serverLogger.warning("Произошла ошибка при попытке завершить соединение с клиентом!");
            }
        }
        stop();
        serverLogger.info("Соединение закрыто");
    } catch (ServerException e) {
        System.out.println("Ошибка чтения файла");

    }

    }

private void openServerSocket() throws ServerException {
    try {
        SocketAddress socketAddress = new InetSocketAddress(port);
        serverLogger.info("Создан сокет");
        ss = ServerSocketChannel.open();
        serverLogger.info("Создан канал");
        ss.bind(socketAddress);
        serverLogger.info("Открыт канал сокет");
    } catch (IllegalArgumentException exception) {
        serverLogger.warning("Порт находится за пределами возможных значений");
    } catch (IOException exception) {
        serverLogger.warning("Произошла ошибка при попытке использовать порт");
        throw new ServerException();
    }
}

private SocketChannel connectToClient() throws  SocketTimeoutException {
    try {
//            console.println("Прослушивание порта '" + port + "'...");
//            serverLogger.info("Прослушивание порта '" + port + "'...");
        ss.socket().setSoTimeout(100);
        socketChannel = ss.socket().accept().getChannel();
        serverLogger.info("Соединение с клиентом успешно установлено.");
        return socketChannel;
    } catch (SocketTimeoutException exception) {
        throw new SocketTimeoutException();
    } catch (IOException exception) {
        serverLogger.warning("Произошла ошибка при соединении с клиентом!");
    }
    return null;
}

private boolean processClientRequest(SocketChannel clientSocket) {
    Request userRequest = null;
    Response responseToUser = null;
    try {
        ObjectInputStream clientReader = new ObjectInputStream(clientSocket.socket().getInputStream());
        ObjectOutputStream clientWriter = new ObjectOutputStream(clientSocket.socket().getOutputStream());
        serverLogger.info("Открыты потоки ввода вывода");

            userRequest = (Request) clientReader.readObject();
            serverLogger.info("Получен реквест с командой" + userRequest.getCommand().getName());
            responseToUser = runtimeManager.run(userRequest);
            clientWriter.writeObject(responseToUser);
            serverLogger.info("Отправлен ответ"+ responseToUser);
            clientWriter.flush();

    } catch (ClassNotFoundException exception) {

        serverLogger.warning("Произошла ошибка при чтении полученных данных!");
    } catch (InvalidClassException | NotSerializableException exception) {
        serverLogger.warning("Произошла ошибка при отправке данных на клиент!");
    } catch (IOException exception) {
        if (userRequest == null) {
            serverLogger.warning("Непредвиденный разрыв соединения с клиентом!");
        } else {

            serverLogger.info("Клиент успешно отключен от сервера!");
        }
    }
    return true;
}

private void stop() {
    class ClosingSocketException extends Exception{}
    try{
        if (socketChannel == null) throw new ClosingSocketException();
        socketChannel.close();
        ss.close();
        serverLogger.info("все соединения закрыты");
    } catch (ClosingSocketException exception) {

        serverLogger.warning("Невозможно завершить работу еще не запущенного сервера!");
    } catch (IOException exception) {

        serverLogger.warning("Произошла ошибка при завершении работы сервера!");
    }
}
}

