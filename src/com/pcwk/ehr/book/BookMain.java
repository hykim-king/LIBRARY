package com.pcwk.ehr.book;

import java.util.List;
import java.util.Scanner;

public class BookMain {
    private static BookDAO bookDAO = new BookDAO();
    private static Scanner scanner = new Scanner(System.in);
    private static LibMemDAO memberDAO = new LibMemDAO();

    public static void main(String[] args) {
    	boolean isLoggedIn = false;

        while (!isLoggedIn) {
            printLoginMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                	registerMember(memberDAO, scanner);             	
                    break;
                case 2:
                	isLoggedIn = login(); 
                    break;
                case 3:
                	adminMode(memberDAO, scanner);
                    break;
                case 4:
                    System.out.println("���α׷��� �����մϴ�.");
                    System.exit(0);
                default:
                    System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
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
                	System.out.println("���α׷��� ����Ǿ����ϴ�.");
                    exit = true;
                    break;
                default:
                    System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
            }
        }
    }
    
    private static void printLoginMenu() {
        System.out.println("\n=== ���� ���� ���α׷� ===");
        System.out.println("1. ȸ������");
        System.out.println("2. �α���");
        System.out.println("3. ������ ���");
        System.out.println("4. ���α׷� ����");
        System.out.print("����: ");
    }
    
    public static void registerMember(LibMemDAO memberDAO, Scanner scanner) {
        while (true) {
        	System.out.println("\n��ȸ�����Ԣ�");
            System.out.print("�̸��� �Է��ϼ���: ");
            String name = scanner.nextLine();

            System.out.print("���̵� �Է��ϼ���: ");
            String userID = scanner.nextLine();

            if (memberDAO.checkUserExistence(userID)) {
                System.out.println("�̹� �����ϴ� ���̵��Դϴ�. �ٸ� ���̵� �Է����ּ���.");
            } else {
                System.out.print("��й�ȣ�� �Է��ϼ���: ");
                String password1 = scanner.nextLine();

                System.out.print("��й�ȣ�� �ٽ� �ѹ� �Է��ϼ���: ");
                String password2 = scanner.nextLine();

                if (!password1.equals(password2)) {
                    System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �õ����ּ���.");
                } else {
                    LibMemDTO user = new LibMemDTO(name, userID, password1);
                    memberDAO.addMember(user);
                    
                    System.out.println("������������������������������������������������������������������������");
                    System.out.printf("    %s�� ������ ȸ�������� �Ϸ�Ǿ����ϴ�.    \n",name);
                    System.out.println("������������������������������������������������������������������������ \n");

                    break;
                }
            }
        }
    }

    
    private static boolean login() {
        System.out.println("\n�ݷα��΢�");

        System.out.print("���̵� �Է��ϼ���: ");
        String username = scanner.nextLine();

        System.out.print("��й�ȣ�� �Է��ϼ���: ");
        String password = scanner.nextLine();

        if (memberDAO.isMemberID(username) && memberDAO.isPasswordCorrect(username, password)) {
            System.out.println("�α��� �Ǿ����ϴ�.");
            return true;
        } else {
            System.out.println(" *���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.* ");
        }

        return false;
    }
    
  //�ڡڡڰ����ڸ��ڡڡ�
    public static void adminMode(LibMemDAO memberDAO, Scanner scanner) {
        System.out.print("\n������ ��й�ȣ�� �Է��ϼ���: ");
        String adminPassword = scanner.nextLine();

        // ������ ��й�ȣ�� ������
        if (adminPassword.equals("abc123")) {
            System.out.println("������ ���� �����Ͽ����ϴ�.");
            System.out.println("1. ȸ�� ��ü ��� ���");
            System.out.println("2. ȸ�� ����");
            System.out.print("��ȣ�� �����ϼ���!  ��  ");
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
                    System.out.println("�߸��� �����Դϴ�.");
            }
        } else {
            System.out.println("������ ��й�ȣ�� Ʋ�Ƚ��ϴ�. ������ ��� ���� ����!");
        }
    }
    
    public static void showMemberList(LibMemDAO memberDAO) {
        System.out.println("\n������ ȸ�� ��� ��");
        for (LibMemDTO member : memberDAO.getAllMembers()) {
            System.out.println("�̸�: " + member.getName() + "  |  ID: " + member.getMemberId());
        }

        askToContinue(new Scanner(System.in));
    }

    public static void deleteMember(LibMemDAO memberDAO, Scanner scanner) {
        System.out.print("\n������ ȸ���� ID�� �Է��ϼ���: ");
        String memberId = scanner.nextLine();
        if (memberDAO.deleteMember(memberId)) {
            System.out.println("---ȸ�� ���� �Ϸ�!---");
        } else {
            System.out.println("�ش� ID�� ȸ���� ã�� �� �����ϴ�.");
        }

        askToContinue(scanner);
    }

    public static void askToContinue(Scanner scanner) {
        System.out.print("\n����Ͻðڽ��ϱ�? (y/n): ");
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("y")) {
            System.out.println("\n---- ���α׷��� �����մϴ� ----");
            scanner.close();
            System.exit(0);
        }
    }

    private static void printMenu() {
        System.out.println("=== ���� ���� ���α׷� ===");
        System.out.println("1. ��ü ���� ��� ��ȸ");
        System.out.println("2. ���� �������� �˻�");
        System.out.println("3. ���� �̸����� �˻�");
        System.out.println("4. ���α׷� ����");
        System.out.print("�޴� ����: ");
    }

    private static void displayAllBooks() {
        System.out.println("=== ��ü ���� ��� ===");
        String books = bookDAO.doRetrieve("1");
        System.out.println(books);
    }

    private static void searchBooksByTitle() {
        System.out.print("�˻��� ���� ���� �Է�: ");
        String title = scanner.nextLine();
        System.out.println("=== �˻� ��� ===");
        String books = bookDAO.doRetrieve("2", title);
        System.out.println(books);
    }

    private static void searchBooksByAuthor() {
        System.out.print("�˻��� ���� �̸� �Է�: ");
        String author = scanner.nextLine();
        System.out.println("=== �˻� ��� ===");
        String books = bookDAO.doRetrieve("3", author);
        System.out.println(books);
    }
}