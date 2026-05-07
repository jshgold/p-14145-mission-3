package csh.controller;

import csh.service.WiseSayingService;

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
}
