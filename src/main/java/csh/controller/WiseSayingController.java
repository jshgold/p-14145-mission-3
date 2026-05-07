package csh.controller;

import csh.entity.WiseSaying;
import csh.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService service = new WiseSayingService();

    public WiseSayingController(Scanner scanner) {
        this.sc = scanner;
    }

    public void requestCreate() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("저자 : ");
        String author = sc.nextLine().trim();
        int id = service.create(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }

    public void requestShowList() {
        List<WiseSaying> list = service.getWiseSayingList();
        if(list.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
            return;
        }
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (WiseSaying wiseSaying : list) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }
}
