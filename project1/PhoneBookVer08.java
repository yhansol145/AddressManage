package project1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver08.PhoneBookManager;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;

public class PhoneBookVer08 {

	public static void main(String[] args) {

		PhoneBookManager manager = new PhoneBookManager();
		ArrayList<AutoSaverT> save = new ArrayList<AutoSaverT>();
		int index = 0;
		int choice;
		Scanner scan = new Scanner(System.in);
		manager.callPhoneBook();

		while (true) {
			try {
				manager.printMenu();
				choice = scan.nextInt();

				if (choice > 6 || choice < 1) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}

				switch (choice) {
				case MenuItem.ONE:
					manager.dataInput(choice);
					System.out.println();
					break;

				case MenuItem.TWO:
					manager.dataSearch();
					System.out.println();
					continue;

				case MenuItem.THR:
					manager.dataDelete();
					System.out.println();
					continue;

				case MenuItem.FOU:
					manager.dataAllShow();
					System.out.println();
					continue;

				case MenuItem.FIV:
					System.out.println("== 저장옵션 선택 ==");
					System.out.println("저장옵션을 선택하세요.");
					System.out.println("1. 자동저장On,   2. 자동저장Off");
					choice = scan.nextInt();
					if (choice == 1) {
						save.add(new AutoSaverT(manager));
						save.get(index).setDaemon(true);
						save.get(index).start();
						System.out.println("자동저장을 시작합니다.");
					} else if (choice == 2) {
						save.get(index).interrupt();
						index++;
						System.out.println("자동저장이 종료됩니다.");
					}
					break;

				case MenuItem.SIX:
					manager.savePhoneBook();
					System.out.println("프로그램을 종료합니다.");
					System.exit(choice);
				}
			} catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				e.printStackTrace();
				scan.nextLine();
			} catch (NullPointerException e) {
				e.printStackTrace();
				scan.nextLine();
			} catch (IllegalThreadStateException e) {
				System.out.println("이미 자동저장이 실행중입니다.");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("자동저장이 실행되고 있지 않습니다.");
			}
		}
	}
}