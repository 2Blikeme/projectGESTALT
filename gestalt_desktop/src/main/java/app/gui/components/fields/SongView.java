package app.gui.components.fields;



import app.database.entity.Music;
import app.gui.components.chunks.CustomButton;
import app.gui.cosmetic.MyFont;
import app.gui.interfaces.CustomField;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class SongView implements CustomField {

    private Box songBox;
    private Music song;

    private CustomButton playButton;

    private final MyFont font;

    private Clip music;

    public static boolean isPlaying = false;


    public SongView(MyFont font) {
        this.font = font;

        songBox = new Box(BoxLayout.X_AXIS);
        songBox.setBorder(new LineBorder(Color.BLACK, 1));
        songBox.setFont(font.getFont());
        songBox.setPreferredSize(new Dimension(300, 50));


        playButton = new CustomButton(font);
        playButton.setBackground(Color.decode("#444444"));

        playButton.setHolder("Play");
        songBox.add(playButton.getComponent());

        playSong();
    }


    public void playSong() {
        JButton t = (JButton) playButton.getComponent();
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(song.getPath()));
                    music = AudioSystem.getClip();
                    music.open(inputStream);
                    if (!isPlaying) {
                        music.setMicrosecondPosition(0);
                        music.start();
                        isPlaying = true;
                    } else {
                        music.stop();
                        isPlaying = false;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }



    public void initSong(Music song) {
        this.song = song;
        JLabel songLabel = new JLabel(song.toString());
        songLabel.setFont(font.getFont());
        songBox.add(songLabel);
    }


    public Music getSong() {
        return song;
    }


    @Override
    public JComponent getComponent() {
        return songBox;
    }


    @Override
    public void setSize(int width, int height) {
        songBox.setPreferredSize(new Dimension(width, height));
    }
}
