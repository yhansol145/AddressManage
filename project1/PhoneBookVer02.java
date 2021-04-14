package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;


public class PhoneBookVer02 {

	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.println("선택 : ");
	}
	
	public static void readData() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 : ");
		String name = scanner.nextLine();
		System.out.println("전화번호 : ");
		String phoneNumber = scanner.nextLine();
		System.out.println("생년월일 : ");
		String birthday = scanner.nextLine();
		
		PhoneInfo phoneInfo = new PhoneInfo();
		phoneInfo.showPhoneInfo(name, phoneNumber, birthday);
	}
	
	public static void main(String[] args) {
		
		int choice;
		
		
		while(true) {
			
			showMenu();
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				readData();
				System.out.println();
				continue;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			break;
		}
	}
}
