package com.pcwk.ehr.member;

import com.pcwk.ehr.cmn.DTO;

public class MemberDTO  extends DTO {
	private String memberId;  //회원아이디
	private String name;	  //이름
	private String passwd;	  //비번
	private String email;	  //이메일
	private String cellphone; //핸드폰
	private String regDate;	  //등록일
	private String regId;	  //등록자ID
	
	public MemberDTO(){}

	public MemberDTO(String memberId, String name, String passwd, String email, String cellphone, String regDate,
			String regId) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.cellphone = cellphone;
		this.regDate = regDate;
		this.regId = regId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", name=" + name + ", passwd=" + passwd + ", email=" + email
				+ ", cellphone=" + cellphone + ", regDate=" + regDate + ", regId=" + regId + "]";
	}
	
	
}