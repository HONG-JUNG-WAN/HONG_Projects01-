package com.emp;

/*
 * Thread를 이용한 클라이언트 구현, IP와 port를 지정하고, Socket 라이브러리 활용
 * 
 * */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

class EmpClient extends Thread {
	
	private List<Employee> emps;
	private String ip = "localhost";
	private int port = 6000;
	
	

	public EmpClient(List<Employee> emps) {
		this.emps = emps;
	}


	@Override
	public void run() { /* run() : 쓰레드의 실질적인 코드 블록.*/
		Socket s = null;
		ObjectOutputStream oos = null;
		
		try {
			s = new Socket(ip, port);
			
			oos = new ObjectOutputStream(s.getOutputStream());
			
			for(Employee e : emps) {
				oos.writeObject(e);
				oos.flush();
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				oos.close();
				s.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
	
}