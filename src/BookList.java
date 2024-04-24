import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pcwk.ehr.cmn.PLog;

public class BookList implements PLog {

	private String bookName;
	private String bookAuthor;
	
	private final String BOOK_URL = "https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&q=%EB%8F%84%EC%84%9C";

	public BookList() {}

	public BookList(int count) {

		try {
			Document doc = Jsoup.connect(BOOK_URL).get();
			Elements titles = doc.select("strong.tit_item");
			Elements authors = doc.select("span.txt_sub");
			

			if (!titles.isEmpty()) {
				for (int i = 0; i < count; i++) {
					Element eBookName = titles.get(i);
					Element eBookAuthor = authors.get(i);
					
					bookName = eBookName.text();
					bookAuthor = eBookAuthor.text();
					
					if (!bookAuthor.equals("교보문고")) {
						System.out.println("bookName:" + bookName);
						System.out.println("bookAuthor:" + bookAuthor);
					}
				}//for
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public static void main(String[] args) {

//		final String BOOK_URL = "https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&q=%EB%8F%84%EC%84%9C";
//		String bookName;
//		String bookAuthor;
//		try {
//			Document doc = Jsoup.connect(BOOK_URL).get();
//			Elements titles = doc.select("strong.tit_item");
//			Elements authors = doc.select("span.txt_sub");
//
//			if (!titles.isEmpty()) {
//				for (int i = 0; i < 100; i++) {
//					Element eBookName = titles.get(i);
//					Element eBookAuthor = authors.get(i);
//					bookName = eBookName.text();
//					bookAuthor = eBookAuthor.text();
//					if (!bookAuthor.equals("교보문고")) {
//						System.out.println("bookName:" + bookName);
//						System.out.println("bookAuthor:" + bookAuthor);
//					}
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		int i = 50;
		BookList bookList = new BookList(100);
		
	}
}
