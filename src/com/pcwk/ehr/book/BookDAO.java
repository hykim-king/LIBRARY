package com.pcwk.ehr.book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;

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
	
	// ��ü ���� ��� ��ȸ
	public String doRetrieve(String div){
		StringBuilder sb = new StringBuilder();
		
		if(div.equals("1")) {
			for(BookDTO book : this.list) {
				String output = String.format("���� �̸�: %-40s \t\t\t\t\t ����: %-20s\n", book.getBookName(), book.getAuthor());
				sb.append(output);
			}
		}
		
		return sb.toString();
	}
	
	public String doRetrieve(String div, String search){
		StringBuilder sb = new StringBuilder();		
		
		if(div.equals("2")) { //���� �̸� �˻�
			for(BookDTO book : this.list) {
				if(book.getBookName().startsWith(search)) {
					sb.append("���� �̸�: "+book.getBookName()+" / ���� : "+ book.getAuthor()+"\n");
				}
			}
		}
		
		if(div.equals("3")) { //���� �̸� �˻�
			for(BookDTO book : this.list) {
				if(book.getAuthor().startsWith(search)) {
					String output = String.format("���� �̸�: %-20s  /t //// ����: %-20s\n", book.getBookName(), book.getAuthor());
				}
			}
		}
		
		
		return sb.toString();
	}

	@Override
	public int doSaveFile() {
		int count = 0;
		//PrettyPrinting�� Json����
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

			// Gson��ü ����
			Gson gson = new Gson();
			Type type = new TypeToken<List<BookDTO>>() {}.getType(); 

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
					String name = bookName.text().trim();
					String author = bookAuthor.text().trim();
					
					if (!(bookAuthor.text().trim()).equals("��������")) {
							list.add( new BookDTO(name, author) );
					}
					
				}//for
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int addBook(BookDTO book) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	
	
	private static List<BookDTO> userDatabase;
	

    public BookDAO() {
        userDatabase = new ArrayList<>();
    }

    // ����� �߰� �޼���
    public void addMember(BookDTO user) {
        userDatabase.add(user);
    }

    // ����� ���̵� ���� ���� Ȯ�� �޼���
    public boolean checkUserExistence(String userID) {
        for (BookDTO user : userDatabase) {
            if (user.getMemberId().equals(userID)) {
                return true; // ���̵� �����ϸ� true ��ȯ
            }
        }
        return false; // ���̵� �������� ������ false ��ȯ
    }

    // ��й�ȣ Ȯ�� �޼���
    public boolean isPasswordCorrect(String userID, String password) {
        for (BookDTO user : userDatabase) {
            if (user.getMemberId().equals(userID)) {
                return user.getPassword().equals(password); // ���̵� ��ġ�ϴ� ������� ��й�ȣ Ȯ��
            }
        }
        return false; // ���̵� �������� ������ false ��ȯ
    }

    public boolean isMemberID(String username) {
        for (BookDTO user : userDatabase) {
            if (user.getMemberId().equals(username)) {
                return true; // ���̵� �����ϸ� true ��ȯ
            }
        }
        return false; // ���̵� �������� ������ false ��ȯ
    }
    
    
  //�ڡڡڰ����ڸ��
    public boolean deleteMember(String memberId) {
        Iterator<BookDTO> iterator = userDatabase.iterator();
        while (iterator.hasNext()) {
        	BookDTO member = iterator.next();
            if (member.getMemberId().equals(memberId)) {
                iterator.remove();
                return true; 
            }
        }
        return false; 
    }
	public static List<BookDTO> getAllMembers() {
		return userDatabase;
	}
	

}