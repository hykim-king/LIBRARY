import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BookMain {
    private static final String BOOK_FILE = "books.txt";
    private static List<Book> books = new ArrayList<>();
    public static void main(String[] args) {
    	BookList bookList = new BookList(100);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 대출/반납");
            System.out.println("3. 도서 목록 조회");
            System.out.println("4. 도서 대여 목록");
            System.out.println("5. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    manageBookStatus(scanner);
                    break;
                case 3:
                    viewBookList();
                    break;
                case 4:
                	RentalBookList();
                	break;
                case 5:
                    saveBookData();
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }
    }
    private static void loadBookData() {
        try {
            File file = new File(BOOK_FILE);
            if (file.exists() && file.length() > 0) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    boolean isAvailable = parts[2].trim().equalsIgnoreCase("Available");
                    books.add(new Book(title, author, isAvailable));
                }
                reader.close();
            } else {
                System.out.println("도서 데이터 파일이 존재하지 않거나 비어있습니다.");
            }
        } catch (IOException e) {
            System.out.println("도서 데이터 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    private static void addBook(Scanner scanner) {
        System.out.print("도서 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author, true));
        System.out.println("도서가 추가되었습니다.");
    }
    private static void manageBookStatus(Scanner scanner) {
        System.out.print("도서 제목: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("도서가 대출되었습니다.");
            } else {
                book.setAvailable(true);
                System.out.println("도서가 반납되었습니다.");
            }
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }
    private static void viewBookList() {
        System.out.println("도서 목록:");
        if (books.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    private static Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.toString().startsWith(title + " |")) {
                return book;
            }
        }
        return null;
    }
    private static void saveBookData() {
        try {
            File file = new File(BOOK_FILE);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("도서 데이터 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    private static void RentalBookList() {
    	System.out.println("-------대여중인 책 목록-------");
    	
    	for (Book book : books) {
    		
    		if(!book.isAvailable())
    			System.out.println(book.getTitle().toString());
    	}
    }


}//class end
