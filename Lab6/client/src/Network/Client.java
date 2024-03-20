package Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    ObjectInputStream input;
    ObjectOutputStream output;
    Socket socket;
    private int reconnectionTimeout;
    private int reconnectionAttempts;
    private int maxReconnectionAttempts;

    private int port;

    private String host;

    public Client(String host, int port)//, int reconnectionAttempts, int reconnectionTimeout, int maxReconnectionAttempts) {
    {
        this.port = port;
        this.host = host;
//        this.reconnectionAttempts= reconnectionAttempts;
//        this.reconnectionTimeout = reconnectionTimeout;
//        this.maxReconnectionAttempts = maxReconnectionAttempts;
    }


    public Responce sendRequest(Request request) {
        while (true) {
            try {
                connectToServer();
                output.writeObject(request);
                output.flush();
                disconnect();
                try {
                    Responce responce = (Responce) input.readObject();
                    return responce;





                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }


    public void connectToServer() {
        try {
            socket = new Socket(host, port);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect(){
        try {
            socket.close();
            input.close();
            output.close();

        } catch (IOException e) {
            System.err.println("Не подключен к серверу");
        }


    }

}
