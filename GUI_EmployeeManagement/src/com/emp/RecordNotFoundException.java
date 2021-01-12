package com.emp;

/*
 * CRUD 메소드 구현 시, 직원 정보를 찾지 못하거나 이미 저장된 정보일 때 발생시킬 error 구현
 * 
 * */

class RecordNotFoundException extends Exception {

	@Override
	public String toString() {
		return super.toString() + ": 데이터가 없습니다.";
	}

}