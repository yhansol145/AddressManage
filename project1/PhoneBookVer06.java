package project1;

import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver06.PhoneBookManager;
import project1.ver06.MenuSelectException;


public class PhoneBookVer06 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		
		int choice;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			try {
				manager.printMenu();
				choice = scan.nextInt();
				
				if(choice>5 || choice<1) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
				
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
					System.exit(choice);
				}
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				e.printStackTrace();
				scan.nextLine();
			}
			catch(NullPointerException e) {
				e.printStackTrace();
				scan.nextLine();
			}
		}
	}
}