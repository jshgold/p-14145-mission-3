package csh.service;

import csh.entity.WiseSaying;
import csh.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository repo = new WiseSayingRepository();
    private int id = 1;

    public int create(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(id++,content,author);
        repo.save(wiseSaying);
        return wiseSaying.getId();
    }

    public List<WiseSaying> displayWiseSaying() {
        return repo.findAll();
    }
}
