package Network;

import Managers.RunManager;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private DatagramSocket socket= new DatagramSocket(8237);
    private InetAddress address= InetAddress.getByName("localhost");
    private byte[] buffer = new byte[4096];
    private static final Logger logger = Logger.getLogger("logger");


    public String path;
    private DatagramPacket packet= new DatagramPacket(buffer, buffer.length);
    public RunManager runtimeManager;
    public Server() throws SocketException, UnknownHostException {
    }

    public Server(RunManager runtimeManager) throws SocketException, UnknownHostException {
        this.runtimeManager = runtimeManager;
    }

    public void runServer() throws IOException, ClassNotFoundException {
        logger.log(Level.INFO, "Сервер начал работу");
        while (true){
            socket.receive(packet);
            byte[] data= packet.getData();
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
            Request request= (Request) objectInputStream.readObject();
            logger.log(Level.INFO,"Принял запрос");
            processTask(request, packet.getAddress(), packet.getPort());
        }
    }

    public void processTask(Request request, InetAddress address, Integer port) throws IOException {
        logger.log(Level.INFO,"Обработка");
        sendAnswer(runtimeManager.run(request), address, port);

    }

    public void sendAnswer(Response response, InetAddress address, Integer port) throws IOException {
        logger.log(Level.INFO,"Отправка ответа");
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(response);
        byte[] buffer= byteArrayOutputStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
    }

}
