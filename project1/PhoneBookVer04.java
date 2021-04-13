package project1;

import java.util.Scanner;
import project1.ver04.PhoneBookManager;

public class PhoneBookVer04 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		
		int choice;
		
		while(true) {
			manager.printMenu();
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				manager.dataInput(choice);
				System.out.println();
				continue;
			case 2:
				manager.dataSearch();
				System.out.println();
				continue;
			case 3:
				manager.dataDelete();
				System.out.println();
				continue;
			case 4:
				manager.dataAllShow();
				System.out.println();
				continue;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			break;
		}
	}
}
