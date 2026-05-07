package csh.service;

import csh.entity.WiseSaying;
import csh.repository.WiseSayingRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class WiseSayingService {
    private final WiseSayingRepository repo = new WiseSayingRepository();
    private int id = 1;

    public int create(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(id++,content,author);
        repo.save(wiseSaying);
        return wiseSaying.getId();
    }

    public List<WiseSaying> getWiseSayingList() {
        List<WiseSaying> a = repo.findAll();
        return repo.findAll();
    }

    public Map<Integer,WiseSaying> findById(int targetId) {
        Map<Integer,WiseSaying> map = new HashMap<>();
        List<WiseSaying> list = repo.findAll();
        if(list.isEmpty()) return null;

        int idx = IntStream
                .range(0, list.size())
                .filter(i -> list.get(i).getId() == targetId)
                .findFirst().orElse(-1);

        if(idx == -1) return null;
        WiseSaying ws = list.get(idx);
        map.put(idx,ws);
        return map;
    }

    public void updateByIdx(int idx, String content, String author) {
        List<WiseSaying> list = repo.findAll();
        WiseSaying ws = list.get(idx);
        ws.setContent(content);
        ws.setAuthor(author);
        repo.update(idx, ws);
    }
}
