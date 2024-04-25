package com.pcwk.ehr.book;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LibMemDAO {
	
	private static List<LibMemDTO> userDatabase;
	

   
    public LibMemDAO() {
        userDatabase = new ArrayList<>();
    }

    // ����� �߰� �޼���
    public void addMember(LibMemDTO user) {
        userDatabase.add(user);
    }

    // ����� ���̵� ���� ���� Ȯ�� �޼���
    public boolean checkUserExistence(String userID) {
        for (LibMemDTO user : userDatabase) {
            if (user.getMemberId().equals(userID)) {
                return true; // ���̵� �����ϸ� true ��ȯ
            }
        }
        return false; // ���̵� �������� ������ false ��ȯ
    }

    // ��й�ȣ Ȯ�� �޼���
    public boolean isPasswordCorrect(String userID, String password) {
        for (LibMemDTO user : userDatabase) {
            if (user.getMemberId().equals(userID)) {
                return user.getPassword().equals(password); // ���̵� ��ġ�ϴ� ������� ��й�ȣ Ȯ��
            }
        }
        return false; // ���̵� �������� ������ false ��ȯ
    }

    public boolean isMemberID(String username) {
        for (LibMemDTO user : userDatabase) {
            if (user.getMemberId().equals(username)) {
                return true; // ���̵� �����ϸ� true ��ȯ
            }
        }
        return false; // ���̵� �������� ������ false ��ȯ
    }
    
    
  //�ڡڡڰ����ڸ��
    public boolean deleteMember(String memberId) {
        Iterator<LibMemDTO> iterator = userDatabase.iterator();
        while (iterator.hasNext()) {
            LibMemDTO member = iterator.next();
            if (member.getMemberId().equals(memberId)) {
                iterator.remove();
                return true; 
            }
        }
        return false; 
    }
	public static List<LibMemDTO> getAllMembers() {
		return userDatabase;
	}


}