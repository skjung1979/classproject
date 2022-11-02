package JinSS_coding_YT.source.s001;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Student st1 = new Student("손흥민", "7");
        Student st2 = new Student("케인", "10");
        Student st3 = new Student("황희찬", "11");

        ArrayList<Student> list = new ArrayList<>();

        list.add(st1);
        list.add(st2);
        list.add(st3);

        for (Student stu : list) {
            System.out.println(stu.getName());
            System.out.println(stu.getNo());
        }

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("계속 검색을 하려면 y, 종료하려면 n");
            String input = sc.nextLine();

            if (input.equals("y")) {
                System.out.println("검색을 시작합니다. 이름을 입력하세요. >> ");
                String name = sc.nextLine();

                boolean flag = false;

                for (Student stu : list) {
                    if (stu.getName().equals(name)) {
                        System.out.println("해당하는 학생의 학번은: " + stu.getNo());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("해당하는 학생이름이 없습니다.");
                }
            }
            else if (input.equals("n")) {
                break;
            }

        }
        System.out.println("프로그램이 종료되었습니다.");

    }
    
}
