package Network;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class Client {
    private Socket socket= new Socket("localhost", 155);
    private InetAddress address= InetAddress.getByName("localhost");

    public Client() throws IOException {
    }


    public void sendTask(Request request) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(request);
        getAnswer();
    }

    public void getAnswer() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
        Response response= (Response) objectInputStream.readObject();
        System.out.println(response.getResult());
    }


}
