package Network;

import Managers.FileManager;
import Managers.RunManager;

import java.io.*;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {


    SocketChannel socketChannel;

    ServerSocketChannel ss;

    private int port;



    private static final Logger logger = Logger.getLogger("logger");


    public String path;
    public RunManager runtimeManager;

    public Server() throws IOException {
    }

    public Server(RunManager runtimeManager, int port) throws IOException {
        this.runtimeManager = runtimeManager;
        this.port = port;
    }



    public void run(){
        try{
            openSocket();
            logger.info("Создано соеденение с клиентом");
            while(true){
                try(SocketChannel clientsocket = connectToClient()){
                    if(!processRequest(clientsocket)) break ;
                }
            }
            stop();
        } catch (IOException e) {
            logger.warning("Произошла ошибка при попытке завершить соединение с клиентом!");
        }


    }

    private void openSocket() {
        try {
            SocketAddress socketAddress = new InetSocketAddress(port);
            ss = ServerSocketChannel.open();
            ss.bind(socketAddress);

        } catch (IOException e) {
            logger.warning("Произошла ошибка при попытке использовать порт");
        }
    }


    private SocketChannel connectToClient() throws IOException {
        try {
            socketChannel = ss.socket().accept().getChannel();
            logger.info("Соеденение с клиентом установлено успешно!");
            return socketChannel;

        } catch (IOException e) {
            logger.warning("Произошла ошибка при подключении к клиенту");
            throw new IOException();
        }

    }


    private boolean processRequest(SocketChannel clientSocket) {
        Request request;
        Response response;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.socket().getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.socket().getOutputStream());
            while (true) {
                request = (Request) objectInputStream.readObject();
                logger.info("Получен запрос с командой %s".formatted(request.getCommand().getName()));
                response = runtimeManager.run(request);
                objectOutputStream.writeObject(response);
                logger.info("Отправлен ответ на клиент!");
                objectOutputStream.flush();
                break;
            }


        } catch (IOException e) {
            System.out.println("Говноу");;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    private void stop() {
        if (socketChannel == null) logger.log(Level.WARNING, "Нельзя закрыть не открывшийся сервер");
        try {
            socketChannel.close();
            ss.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Произошла ошибка при закрытии сервера");
        }

    }
}

