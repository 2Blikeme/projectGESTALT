package app.network;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MusicRepository {

    private static Socket clientSocket;
    private static DataInputStream dis;

    MusicRepository() throws IOException {
        try {
            clientSocket = new Socket("localhost", 4004);


        } catch (IOException exception){
            exception.printStackTrace();
        }

    }

}
