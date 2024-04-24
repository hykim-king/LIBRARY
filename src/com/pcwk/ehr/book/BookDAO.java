package com.pcwk.ehr.book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BookDAO implements WorkDiv<BookDTO> {

	private final String BOOK_URL = "https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&q=%EB%8F%84%EC%84%9C";
	private final String FILE_NAME = "booklist.json";

	private List<BookDTO> list=new ArrayList<BookDTO>();

	@Override
	public List<BookDTO> doRetrieve(DTO list) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookDTO> getList() {
		return list;
	}

	public void setList(List<BookDTO> list) {
		this.list = list;
	}

	@Override
	public int doSave(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookDTO doSelectOne(BookDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doRental(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doReturn(BookDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void doRetrieve(String div){
		LOG.debug(list.get(0));
//		if(div.equals("1")) {
//			System.out.printf("도서 이름: %s, 저자: %s",list.get(0),list.get(1));
//		}
		
	}
	
	public List<BookDTO> doRetrieve(String div, String search){
		List<BookDTO> list = new ArrayList<BookDTO>();
		
		
		
		return list;
	}

	@Override
	public int doSaveFile() {
		int count = 0;
		//PrettyPrinting된 Json생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter fw = new FileWriter(FILE_NAME)){
			
			gson.toJson(list, fw);
			
			count = list.size();
			
		}catch(IOException e) {
			LOG.debug("IOException: "+e.getMessage());
			count = 0;
		}
		
		LOG.debug("doSaveFile count"+count);
		return count;
	}

	@Override
	public int doReadFile() {
		try (FileReader fr = new FileReader(FILE_NAME)) {

			// Gson객체 생성
			Gson gson = new Gson();
			Type type = new TypeToken<List<BookDTO>>() {
			}.getType(); // Type : java.lang.reflect 임포트 TypeToken자동완성 안됨

			List<BookDTO> tmpBox = gson.fromJson(fr, type);

			if (null != tmpBox) {
				list = tmpBox;
			}

		} catch (IOException e) {
			LOG.debug("IOException: " + e.getMessage());
		}

		LOG.debug("listBox.size() :" + list.size());

		return list.size();
	}
	
	public List<BookDTO> readURL(BookDTO param) {
		try {
			Document doc = Jsoup.connect(BOOK_URL).get();
			Elements titles = doc.select("strong.tit_item");
			Elements authors = doc.select("span.txt_sub");
			

			if (!titles.isEmpty()) {
				for (int i = 0; i < 50; i++) {
					Element bookName = titles.get(i);
					Element bookAuthor = authors.get(i);
					
					if (!bookAuthor.equals("교보문고")) {
						list.add( new BookDTO(bookName.text(), bookAuthor.text()) );
					}
					
				}//for
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
