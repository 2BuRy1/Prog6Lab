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
    private SocketChannel socketChannel;



    private Socket sock;

    ServerSocket serv = new ServerSocket(155);

    private ServerSocketChannel ss;

    private InetAddress address= InetAddress.getByName("localhost");

    private static final Logger logger = Logger.getLogger("logger");


    public String path;
    public RunManager runtimeManager;
    public Server() throws IOException {
    }

    public Server(RunManager runtimeManager) throws IOException {
        this.runtimeManager = runtimeManager;
    }

    public void runServer() throws IOException, ClassNotFoundException {
        logger.log(Level.INFO, "Сервер начал работу");
        while (true){
            sock = serv.accept();
//            SocketAddress socketAddress = new InetSocketAddress(155);
//            ss= ServerSocketChannel.open();
//            ss.bind(socketAddress);
//            socketChannel = ss.socket().accept().getChannel();

            ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
            Request task= (Request) objectInputStream.readObject();
            logger.log(Level.INFO,"Принял запрос");
            processTask(task);
        }
    }

    public void processTask(Request request) throws IOException {
        logger.log(Level.INFO,"Обработка");
        sendAnswer(runtimeManager.run(request));

    }

    public void sendAnswer(Response response) throws IOException {
        logger.log(Level.INFO,"Отправка ответа");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
        objectOutputStream.writeObject(response);
        serv.close();
        serv.accept();
    }
}
