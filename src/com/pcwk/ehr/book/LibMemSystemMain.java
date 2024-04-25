package com.pcwk.ehr.book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibMemSystemMain {

   
    public static void main(String[] args) {
        LibMemDAO memberDAO = new LibMemDAO(); // DAO 객체 생성
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n====== 안녕하세요 LIB 도서관입니다 :-) ======");
                System.out.println(" 1. 회원가입");
                System.out.println(" 2. 도서관 이용");
                System.out.println(" 3. 종료 ");
                System.out.println(" 4. 관리자모드");
                System.out.print("번호를 선택하세요!  ☞  ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        registerMember(memberDAO, scanner); // DAO 객체와 Scanner 객체를 전달
                        break;
                    case 2:
                        login(memberDAO, scanner); // DAO 객체와 Scanner 객체를 전달
                        break;
                    case 3:
                        System.out.println("---- 프로그램을 종료합니다 ----");
                        System.exit(0);; // main 메서드 종료
                    case 4:
                    	adminMode(memberDAO, scanner);
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                        break;
                }
            }
        } finally {
            scanner.close(); // 프로그램 종료 시 Scanner 닫기
        }
    }
   

    public static void registerMember(LibMemDAO memberDAO, Scanner scanner) {
        while (true) {
        	System.out.println("\n♬회원가입♬");
            System.out.print("이름을 입력하세요: ");
            String name = scanner.nextLine();

            System.out.print("아이디를 입력하세요: ");
            String userID = scanner.nextLine();

            if (memberDAO.checkUserExistence(userID)) {
                System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
            } else {
                System.out.print("비밀번호를 입력하세요: ");
                String password1 = scanner.nextLine();

                System.out.print("비밀번호를 다시 한번 입력하세요: ");
                String password2 = scanner.nextLine();

                if (!password1.equals(password2)) {
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
                } else {
                    LibMemDTO user = new LibMemDTO(name, userID, password1);
                    memberDAO.addMember(user);
                    
                    System.out.println("────────────────────────────────────");
                    System.out.printf("    %s님 도서관 회원가입이 완료되었습니다.    \n",name);
                    System.out.println("──────────────────────────────────── \n");

                    break;
                }
            }
        }
    }

    public static void login(LibMemDAO memberDAO, Scanner scanner) {
        System.out.println("\n♬로그인♬");

        System.out.print("아이디를 입력하세요: ");
        String username = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        if (memberDAO.isMemberID(username) && memberDAO.isPasswordCorrect(username, password)) {
            System.out.println("로그인 되었습니다.");
        
        }else if(!memberDAO.isMemberID(username)){
        	 System.out.println(" *비회원은 이용 불가합니다.* ");
        	
        	// 회원이 아닌 경우 메시지 출력
        }else {
                System.out.println(" *아이디 또는 비밀번호가 일치하지 않습니다.* ");
            }
        }
    
   
    //★★★관리자모드★★★
    public static void adminMode(LibMemDAO memberDAO, Scanner scanner) {
        System.out.print("\n관리자 비밀번호를 입력하세요: ");
        String adminPassword = scanner.nextLine();

        // 관리자 비밀번호가 맞으면
        if (adminPassword.equals("abc123")) {
            System.out.println("관리자 모드로 접속하였습니다.");
            System.out.println("1. 회원 전체 목록 출력");
            System.out.println("2. 회원 삭제");
            System.out.print("번호를 선택하세요!  ☞  ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    showMemberList(memberDAO);
                    break;
                case 2:
                    deleteMember(memberDAO, scanner);
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        } else {
            System.out.println("관리자 비밀번호가 틀렸습니다. 관리자 모드 접근 실패!");
        }
    }
    public static void showMemberList(LibMemDAO memberDAO) {
        System.out.println("\n도서관 회원 목록 ☞");
        for (LibMemDTO member : memberDAO.getAllMembers()) {
            System.out.println("이름: " + member.getName() + "  |  ID: " + member.getMemberId());
        }

        askToContinue(new Scanner(System.in));
    }

    public static void deleteMember(LibMemDAO memberDAO, Scanner scanner) {
        System.out.print("\n삭제할 회원의 ID를 입력하세요: ");
        String memberId = scanner.nextLine();
        if (memberDAO.deleteMember(memberId)) {
            System.out.println("---회원 삭제 완료!---");
        } else {
            System.out.println("해당 ID의 회원을 찾을 수 없습니다.");
        }

        askToContinue(scanner);
    }

    public static void askToContinue(Scanner scanner) {
        System.out.print("\n계속하시겠습니까? (y/n): ");
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("y")) {
            System.out.println("\n---- 프로그램을 종료합니다 ----");
            scanner.close();
            System.exit(0);
        }
    }
    
}