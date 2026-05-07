package csh;

import csh.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final WiseSayingController controller = new WiseSayingController(sc);
    public void run() {
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String input = sc.nextLine().trim();
            String[] split = input.split("\\?");
            String command = split[0];

            switch (command) {
                case "exit" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                case "create" -> controller.requestCreate();
                case "list" -> controller.requestShowList();
                case "edit" -> {
                    String s = split[1];
                    controller.requestUpdate(s);
                }
                case "delete" -> {
                    String s = split[1];
                    controller.requestDelete(s);
                }
            }
        }
    }
}
