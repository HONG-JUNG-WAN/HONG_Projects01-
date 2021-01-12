package com.server;

/*
 * ServerSocket을 통한 서버 구현, 지정된 포트로 직원 정보가 들어오면, console창에 
 * emp.dat에 저장되어있는 직원 정보 출력.
 * 
 * 자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 반환하는 기술.
 * JVM의 메모리에 상주되어 있는 객체 데이터를 바이트 형태로 변환하는 기술
 * 
 * */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;  // 직렬화 진행
import java.io.ObjectOutputStream; // 직렬화 진행 
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.emp.Employee;

public class EmpServer {

	private int port = 6000;

	public void receive() {
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(port);
			System.out.println("ServerSocket ok. port=" + port);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		while(true) {
			Socket s = null;
			ObjectInputStream ois = null;
			
			try {
				System.out.println("server ready...");
				s = ss.accept();
				
				ois = new ObjectInputStream(s.getInputStream());
				
				while(true) {
					Employee e = (Employee) ois.readObject();
					if(e == null) break;
					System.out.println(e);
				}
			} catch (Exception e) {
				//System.err.println(e);
			} finally {
				try {
					System.out.println("receive ok");
					ois.close();
					s.close();
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		}
	}
	public static void main(String[] args) {
		new EmpServer().receive();
	}

}