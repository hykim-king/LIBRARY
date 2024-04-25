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
        LibMemDAO memberDAO = new LibMemDAO(); // DAO ��ü ����
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n====== �ȳ��ϼ��� LIB �������Դϴ� :-) ======");
                System.out.println(" 1. ȸ������");
                System.out.println(" 2. ������ �̿�");
                System.out.println(" 3. ���� ");
                System.out.println(" 4. �����ڸ��");
                System.out.print("��ȣ�� �����ϼ���!  ��  ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        registerMember(memberDAO, scanner); // DAO ��ü�� Scanner ��ü�� ����
                        break;
                    case 2:
                        login(memberDAO, scanner); // DAO ��ü�� Scanner ��ü�� ����
                        break;
                    case 3:
                        System.out.println("---- ���α׷��� �����մϴ� ----");
                        System.exit(0);; // main �޼��� ����
                    case 4:
                    	adminMode(memberDAO, scanner);
                        break;
                    default:
                        System.out.println("�߸��� �����Դϴ�. �ٽ� �������ּ���.");
                        break;
                }
            }
        } finally {
            scanner.close(); // ���α׷� ���� �� Scanner �ݱ�
        }
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

    public static void login(LibMemDAO memberDAO, Scanner scanner) {
        System.out.println("\n�ݷα��΢�");

        System.out.print("���̵� �Է��ϼ���: ");
        String username = scanner.nextLine();

        System.out.print("��й�ȣ�� �Է��ϼ���: ");
        String password = scanner.nextLine();

        if (memberDAO.isMemberID(username) && memberDAO.isPasswordCorrect(username, password)) {
            System.out.println("�α��� �Ǿ����ϴ�.");
        
        }else if(!memberDAO.isMemberID(username)){
        	 System.out.println(" *��ȸ���� �̿� �Ұ��մϴ�.* ");
        	
        	// ȸ���� �ƴ� ��� �޽��� ���
        }else {
                System.out.println(" *���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.* ");
            }
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
    
}