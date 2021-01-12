package com.emp;

/*
 * 직원 정보 객체 : 번호, 이름, 직책, 거주지
 * 정보 CRUD를 위한 getter와 setter 생성 및 서버 출력에 필요한 toString 메소드 오버라이드 
 * 소켓에서 객체 단위 전송을 위한 직렬화(Serializable)적용
 * 
 * */

import java.io.Serializable;


public class Employee implements Serializable{ /*java.io.Serialzable 인터페이스를 상속받은 객체는 직렬화 할 수 있는 기본 조건*/
		private int empNo;
		private String name;
		private String position;
		private String dept;
		

		public Employee() {
		}

		public Employee(int empNo, String name, String position, String dept ) {
			super();
			this.empNo = empNo;
			this.name = name;
			this.position = position;
			this.dept = dept;
		}

		public int getEmpNo() {
			return empNo;
		}
		
		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}	

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(empNo);
			builder.append("  ");
			builder.append(name);
			builder.append("  ");
			builder.append(position);
			builder.append("  ");
			builder.append(dept);
			return builder.toString();
		}
		
}
