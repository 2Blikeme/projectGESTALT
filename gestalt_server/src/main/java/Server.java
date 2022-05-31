import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static DataOutputStream out; // поток записи в сокет

    private static List<Music> songs;

    {
        songs = new ArrayList<>();

        String path = "src/main/resources/music/";
        songs.add(new Music("Promise", "Akira Yamaoka", path + "Akira Yamaoka-Promise-kissvk.com.mp3"));
        songs.add(new Music("fade", "ooes", path + "ooes-fade-kissvk.com.mp3"));
        songs.add(new Music("Хочу", "Vspak", path + "Vspak-Хочу-kissvk.com.mp3"));
        songs.add(new Music("Алые цветы", "билборды", path + "билборды-Алые цветы-kissvk.mp3"));
        songs.add(new Music("Вместо последней строчки", "билборды", path + "билборды-Вместо последней строчки-kissvk.mp3"));
        songs.add(new Music("Я не нужна тебе живой", "билборды", path + "билборды-Я не нужна тебе живой-kissvk.mp3"));
        songs.add(new Music("А ты", "Серега Пират", path + "Серега Пират-А ты--kissvk.mp3"));
        songs.add(new Music("Извини сегодня праздник", "Серега Пират", path + "Серега Пират-Извини- сегодня праздник-kissvk.mp3"));
        songs.add(new Music("Я это я", "Серега Пират", path + "Серега Пират-Я это я.mp3"));

    }


    public static void main(String[] args) {


        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен!");
                try {
                    while (true) {
                        int bytes = 0;
                        clientSocket = server.accept();
                        out = new DataOutputStream(clientSocket.getOutputStream());

                        File myFile = new File("src/main/resources/music/ooes-fade-kissvk.com.mp3");
                        FileInputStream fileInputStream = new FileInputStream(myFile);

                        out.writeLong(myFile.length());

                        byte[] buffer = new byte[4 * 2048];

                        while ((bytes = fileInputStream.read(buffer))!=-1) {
                            out.write(buffer, 0, bytes);
                            out.flush();
                        }

                        fileInputStream.close();

                        out.close();
                        clientSocket.close();
                    }
                } finally {
                    System.out.println("Сервер закрыт!");
                    server.close();
                }
            }
            catch (IOException e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
