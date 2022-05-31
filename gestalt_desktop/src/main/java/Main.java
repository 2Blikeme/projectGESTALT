import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;
import java.net.Socket;

import java.io.File;


public class Main {

    private static Socket clientSocket; //сокет для общения

    //private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет



    public static void main(String[] args) {
        try {
            clientSocket = new Socket("localhost", 4004);
            InputStream in = clientSocket.getInputStream();
            DataInputStream clientData = new DataInputStream(in);


            File tmpFile = new File("tmp.mp3");
            FileOutputStream fileOutputStream = new FileOutputStream(tmpFile);

            long size = clientData.readLong();

            int bytesRead;



            byte[] buffer = new byte[4 * 2048];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }



            FileInputStream stream = new FileInputStream(tmpFile);
            Player player = new Player(stream);
            player.play();


            stream.close();

            in.close();
            clientData.close();

        } catch (IOException e) {
            System.err.println(e);
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }

    }



//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//                MainConfig.class
//        );
//    }
//
}
