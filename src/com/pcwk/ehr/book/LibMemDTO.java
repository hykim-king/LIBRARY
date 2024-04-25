package com.pcwk.ehr.book;
import com.google.gson.Gson;

public class LibMemDTO {
   
    
    private String name;
    private String memberID;
    private String password;

    // 기본 생성자
    public LibMemDTO() {}

    // 생성자
    public LibMemDTO(String name, String memberID, String password) {
        this.name = name;
        this.memberID = memberID;
        this.password = password;
    }

   
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberID;
    }

    public String getPassword() {
        return password;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "LibMemDTO [name=" + name + ", memberID=" + memberID + ", password=" + password + "]";
    }

    
}