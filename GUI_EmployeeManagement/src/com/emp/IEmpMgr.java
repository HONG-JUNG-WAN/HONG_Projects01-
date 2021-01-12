package com.emp;

/* 구현이 필요한 메소드들을 작성한 인터페이스
 * 
 * load : emp.dat에 저장되어 있는 정보 가져오기.
 * save : emp.dat에 save하여 기존 정보 갱신
 * add : 직원 정보 추가
 * search : 직원 정보 검색
 * update : 직원 정보 수정
 * delete : 직원 정보 삭제
 * 
 * */

import java.util.List;

public interface IEmpMgr {
	// filename에서 객체를 읽어들이는 메서드
	public void load(String filename) ;
	// filename에 객체를 쓰는 메서드
	public void save(String filename) ;
	// Employee를 저장하는 매서드
	public void add(Employee b) throws DuplicateException;
	// 전체 직원정보를 리턴하는 메서드
	public List<Employee> search(); 
	// 번호를 이용하여 검색된 직원을 리턴하는 메서드
	public Employee search(int num) throws RecordNotFoundException;  
	// 번호를 찾아 직원정보를 수정하는 메서드
	public void update(Employee b) throws RecordNotFoundException;
	// 번호를 찾아 직원 정보를 삭제하는 메서드
	public void delete(int num) throws RecordNotFoundException;
}