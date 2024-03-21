package Network;

import java.io.*;
import java.net.*;

public class Client {
    private DatagramSocket socket= new DatagramSocket();
    private InetAddress address= InetAddress.getByName("localhost");
    private byte[] buffer = new byte[4096];
    private DatagramPacket packet= new DatagramPacket(buffer, buffer.length);

    public Client() throws SocketException, UnknownHostException {
    }


    public void sendTask(Request request) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        byte[] buffer = byteArrayOutputStream.toByteArray();
        DatagramPacket packet= new DatagramPacket(buffer, buffer.length, address, 8237);
        socket.send(packet);
        getAnswer();
    }

    public void getAnswer() throws IOException, ClassNotFoundException {
        socket.receive(packet);
        byte[] data = packet.getData();
        ObjectInputStream objectInputStream= new ObjectInputStream(new ByteArrayInputStream(data));
        Response response= (Response) objectInputStream.readObject();
        System.out.println(response.getResult());
    }




}
