package app.service;


import app.database.entity.Music;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicService {
    private List<Music> musicList;
    public MusicService() {

        musicList = new ArrayList<>();
        musicList.add(new Music("/home/gestalt/Github/projectGESTALT/gestalt_desktop/src/main/resources/music/Midix feat. Chuyko- Lirin-Убей меня.wav",
                "Midix feat. Chuyko- Lirin-Убей меня"));
        musicList.add(new Music("/home/gestalt/Github/projectGESTALT/gestalt_desktop/src/main/resources/music/Vspak-Хочу.wav",
                "Vspak-Хочу"));
        musicList.add(new Music("/home/gestalt/Github/projectGESTALT/gestalt_desktop/src/main/resources/music/Серега Пират-А ты.wav",
                "Серега Пират-А ты"));
    }


    public List<Music> getMusicList() {
        return musicList;
    }
}
