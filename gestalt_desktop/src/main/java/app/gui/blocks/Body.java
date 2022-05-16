package app.gui.blocks;

import app.database.entity.Music;
import app.gui.components.fields.SongView;
import app.gui.cosmetic.CustomScrollBarUI;
import app.gui.cosmetic.MyFont;
import app.gui.interfaces.Block;
import app.gui.interfaces.Customization;
import app.service.MusicService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Body implements Block, Customization {

    private JPanel body;

    private JScrollPane scrollPane;

    private List<SongView> songs;

    private final MusicService musicService;

    private final MyFont font;

    public Body(MusicService musicService, MyFont font) {
        body = new JPanel();


        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        setBorder(1, 1, 1, 1, Color.BLUE);


        this.musicService = musicService;
        this.font = font;

        songs = new ArrayList<>();

        List<Music> tmpList = musicService.getMusicList();
        for (Music song : tmpList) {
            SongView songView = new SongView(font);
            songView.initSong(song);
            songs.add(songView);
        }

        for (SongView song: songs) {
            body.add(song.getComponent());
            body.add(Box.createRigidArea(new Dimension(0, 10)));

        }

        scrollPane = new JScrollPane(body);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

    }


    @Override
    public JComponent getComponent() {
        return scrollPane;
    }


    @Override
    public void setSize(int width, int height) {
    }


    @Override
    public void setBorder(int top, int left, int bottom, int right, Color color) {
        body.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, color));
    }


    @Override
    public void setBackground(Color color) {
        body.setBackground(color);
    }


    @Override
    public void setForeground(Color color) {
    }
}
