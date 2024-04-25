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

    // 사용자 추가 메서드
    public void addMember(LibMemDTO user) {
        userDatabase.add(user);
    }

    // 사용자 아이디 존재 여부 확인 메서드
    public boolean checkUserExistence(String userID) {
        for (LibMemDTO user : userDatabase) {
            if (user.getMemberId().equals(userID)) {
                return true; // 아이디가 존재하면 true 반환
            }
        }
        return false; // 아이디가 존재하지 않으면 false 반환
    }

    // 비밀번호 확인 메서드
    public boolean isPasswordCorrect(String userID, String password) {
        for (LibMemDTO user : userDatabase) {
            if (user.getMemberId().equals(userID)) {
                return user.getPassword().equals(password); // 아이디가 일치하는 사용자의 비밀번호 확인
            }
        }
        return false; // 아이디가 존재하지 않으면 false 반환
    }

    public boolean isMemberID(String username) {
        for (LibMemDTO user : userDatabase) {
            if (user.getMemberId().equals(username)) {
                return true; // 아이디가 존재하면 true 반환
            }
        }
        return false; // 아이디가 존재하지 않으면 false 반환
    }
    
    
  //★★★관리자모드
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