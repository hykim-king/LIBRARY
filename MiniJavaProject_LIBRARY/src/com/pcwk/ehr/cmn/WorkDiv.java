package com.pcwk.ehr.cmn;

import java.util.List;

public interface WorkDiv<T> extends PLog {
	/**
	 * 목록 조회
	 * @param search
	 * @return 목록에 대한 리스트 List<T>
	 */
	public List<T> doRetrieve(DTO search);
	
	/**
	 * 단건 저장
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doSave(T param);
	
	/**
	 * 단건 수정
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doUpdate(T param);
	
	/**
	 * 단건 삭제
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doDelete(T param);
	
	/**
	 * 단건 조회
	 * @param param
	 * @return T 리스트
	 */
	public T doSelectOne(T param);
	
	/**
	 * 객체 내용 파일에 저장(Json or XML)
	 * @return 저장건수
	 */
	public int doSaveFile();

	/**
	 * 파일(Json or XML) 객체로 변환
	 * @return 저장건수
	 */
	public int doReadFile();
	
	
}
