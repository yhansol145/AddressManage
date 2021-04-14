package project1;

import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver08.PhoneBookManager;
import project1.ver08.SubMenuItem;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;


public class PhoneBookVer08 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		AutoSaverT save = new AutoSaverT(manager);
		save.setDaemon(true);
//		save.start();
//		save.interrupt();
		
		int choice;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			try {
				manager.printMenu();
				choice = scan.nextInt();
				
				if(choice>6 || choice<1) {
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
					save.start();
					System.out.println();
					continue;
				case 6:
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