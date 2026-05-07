package csh.repository;

import csh.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private List<WiseSaying> list = new ArrayList<>();
    public void save(WiseSaying wiseSaying) {
        list.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return list;
    }

//    public WiseSaying deleteById(int id) {
//
//    }
}
