package project1.ver08;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class AutoSaverT extends Thread {
	
	PhoneBookManager manage = new PhoneBookManager();
	AutoSaverT myThread = new AutoSaverT();
	
	public void threading() {
		
		Scanner scan = new Scanner(System.in);
		
		int choice;
		
		System.out.println("== 저장옵션 선택 ==");
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1. 자동저장On,   2. 자동저장Off");
		
		choice = scan.nextInt();
		if(choice==1) {
			myThread.start();
		}
		else if(choice==2) {
			myThread.interrupt();
		}
	}
	
	public void run() {
		
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream("src/project1/ver08/AutoSaveBook.txt"));
			
			
			
		}
		catch(Exception e) {
			System.out.println("입력정보 파일저장 시 예외발생");
			e.printStackTrace();
		}
	}
	
	

}
