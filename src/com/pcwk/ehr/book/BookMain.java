package com.pcwk.ehr.book;
import java.util.Scanner;


import com.pcwk.ehr.book.BookDAO;
import com.pcwk.ehr.book.BookDTO;

public class BookMain {
	
    private static BookDAO bookDAO = new BookDAO();
    private static Scanner scanner = new Scanner(System.in);
    private static BookDAO memberDAO = new BookDAO();

    public static void main(String[] args) {
    	boolean isLoggedIn = false;

        while (!isLoggedIn) {    	
            printLoginMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                	registerMember(memberDAO, scanner);             	
                    break;
                case "2":
                	isLoggedIn = login(); 
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                case "4":
                	adminMode(bookDAO, scanner);
                default:
                	System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;           
            }
        }
        
        boolean exit = false;
        bookDAO.readURL(new BookDTO());
        
        while (!exit) {
            printMenu();
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    searchBooksByTitle();
                    break;
                case 3:
                    searchBooksByAuthor();
                    break;
                case 4:
                	bookDAO.doRental();
                	break;
                case 5:
                	bookDAO.doReturn();
                	break;             	
                case 6:
                	System.out.println("\n프로그램이 종료되었습니다.");
                    exit = true;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        bookDAO.doSaveFile(); 
    }

    
    
    
    


    //--------------------이후부터는 로그인 메서드 ---------------------------------
    //--------------------이후부터는 로그인 메서드 ---------------------------------
    //--------------------이후부터는 로그인 메서드 ---------------------------------
      
      
      
    
    public static boolean login() {
        System.out.println("\n♬로그인♬");

        System.out.print("아이디를 입력하세요: ");
        String username = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        if (memberDAO.isMemberID(username) && memberDAO.isPasswordCorrect(username, password)) {
            System.out.println("로그인 되었습니다.\n");
            return true;

        }else {
        	
            System.out.println(" *아이디 또는 비밀번호가 일치하지 않습니다. 다시 로그인 해주세요.*\n");
           
        }
		return false;
    }

	private static void printLoginMenu() {
		System.out.println("");
    	System.out.println("┌─────안녕하세요 LIB 도서관입니다.──────┐");
		System.out.println("  1. 회원가입 ");
		System.out.println("  2. 로그인 (도서관 이용하기)");
		System.out.println("  3. 종료하기");
		System.out.println("  4. 관리자 모드");
		System.out.println("└───────────────────────────────┘");
		System.out.print("번호를 선택하세요!  ☞  ");
		
    }
    
  

    
    public static void registerMember(BookDAO memberDAO, Scanner scanner) {
    	while (true) {
    		System.out.println("\n♬회원가입♬");
    	    System.out.print("이름을 입력하세요: ");
    	    String name = scanner.nextLine();
    	    System.out.print("아이디를 입력하세요: ");
    	    String userID = scanner.nextLine();
    	    // 아이디 중복 확인
    	    if (memberDAO.checkUserExistence(userID)) {
    	       System.out.println("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
    	       continue; // 중복된 아이디가 있으면 다시 반복문 시작
    	    }
    	    while (true) {
    	    	System.out.print("비밀번호를 입력하세요: ");
    	        String password1 = scanner.nextLine();
    	        System.out.print("비밀번호를 다시 한번 입력하세요: ");
    	        String password2 = scanner.nextLine();
    	        if (!password1.equals(password2)) {
    	        	System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.\n");
    	        } else {
    	        	BookDTO user = new BookDTO(name, userID, password1);
    	            memberDAO.addMember(user);
    	            memberDAO.saveMemberToFile();
    	            System.out.println("────────────────────────────────────");
    	            System.out.printf("    %s님 도서관 회원가입이 완료되었습니다.    \n", name);
    	            System.out.println("──────────────────────────────────── \n");
    	            return;
    	         }
    	     }
    	 }
     }
    
    
  //★★★관리자모드★★★
    public static void adminMode(BookDAO memberDAO, Scanner scanner) {
    	boolean exitAdminMode = false;
        System.out.print("\n관리자 비밀번호를 입력하세요: ");
        String adminPassword = scanner.nextLine();

        // 관리자 비밀번호가 맞으면
        if (adminPassword.equals("abc123")) {
            System.out.println("\n관리자 모드로 접속하였습니다.");
            System.out.println("1. 회원 전체 목록 출력");
            System.out.println("2. 회원 삭제");
            System.out.println("3. 로그아웃");
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
                case 3:
                    exitAdminMode = true;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.\n");
            }
            if (adminPassword.equals("abc123")) {
                System.out.println("관리자 모드로 접속하였습니다.");
                showAdminMenu(memberDAO, scanner);
            } else {
            	System.out.println("관리자 비밀번호가 틀렸습니다. 다시 접속해 주세요.\n");
        }
    }
}
    
    public static void showAdminMenu(BookDAO memberDAO, Scanner scanner) {
        boolean exitAdminMode = false;
        
        while (!exitAdminMode) {
            System.out.println("\n=== 관리자 모드 ===");
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

            System.out.print("\n계속하시겠습니까? (y/n): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                exitAdminMode = true;
            }
        }
    }
    
    public static void showMemberList(BookDAO memberDAO) {
        System.out.println("\n도서관 회원 목록 ☞");
        for (BookDTO member : memberDAO.getAllMembers()) {
            System.out.println("이름: " + member.getName() + "  |  ID: " + member.getMemberId());
        }

        askToContinue(new Scanner(System.in));
    }

    public static void deleteMember(BookDAO memberDAO, Scanner scanner) {
        System.out.print("\n삭제할 회원의 ID를 입력하세요: ");
        String memberId = scanner.nextLine();
        if (memberDAO.deleteMember(memberId)) {
            System.out.println("---회원 삭제 완료!---\n");
        } else {
            System.out.println("해당 ID의 회원을 찾을 수 없습니다.\n");
        }

        askToContinue(scanner);
    }

    public static void askToContinue(Scanner scanner) {
        System.out.print("\n계속하시겠습니까? (y/n): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("n")) {
            System.out.println("\n---- 프로그램을 종료합니다 ----");
            scanner.close();
            System.exit(0);
        }else if(input.equalsIgnoreCase("y")) {
        	
        }else {
        	System.out.println("다시입력해주세요.");
        	return;
        }
    }
    
        

    private static void printMenu() {
        System.out.println("┌─────LIB도서관 이용 메뉴──────┐");
        System.out.println("  1. 전체 도서 목록 조회");
        System.out.println("  2. 도서 제목 검색");
        System.out.println("  3. 저자 이름 검색");
        System.out.println("  4. 책 대여하기");
        System.out.println("  5. 책 반납하기");
        System.out.println("  6. 종료하기");
        System.out.println("└─────────────────────────┘");
        System.out.print("번호를 선택하세요!  ☞  ");
    }

    private static void displayAllBooks() {
        System.out.println("\n\n──── 전체 도서 목록 ───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        String books = bookDAO.doRetrieve("1");
        System.out.println(books);
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
    }

    private static void searchBooksByTitle() {
        System.out.print("\n검색할 도서 제목 입력: ");
        String title = scanner.nextLine();
        System.out.println("\n===== 검색 결과 =====");
        String books = bookDAO.doRetrieve("2", title);
        System.out.println(books);
    }

    private static void searchBooksByAuthor() {
        System.out.print("\n검색할 저자 이름 입력: ");
        String author = scanner.nextLine();
        System.out.println("\n===== 검색 결과 =====");
        String books = bookDAO.doRetrieve("3", author);
        System.out.println(books);
    }
}