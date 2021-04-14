package project1.ver08;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import project1.ver08.MenuItem.NumOfMenuItem;
import project1.ver08.SubMenuItem.NumOfSubMenuItem;
	
public class PhoneBookManager extends Thread{
	
	HashSet<PhoneInfo> phoneInfo = new HashSet<PhoneInfo>();
	
	MenuItem menuItem = new MenuItem();
	SubMenuItem subMenuItem = new SubMenuItem();

	
	// 메뉴출력
	public void printMenu() {
		System.out.println("=============== 메뉴를 선택하세요 ===============");
		System.out.println(NumOfMenuItem.ONE +".주소록 입력 "
					+ NumOfMenuItem.TWO +".검색 "
					+ NumOfMenuItem.THR +".삭제 "
					+ NumOfMenuItem.FOU +".출력 "
					+ NumOfMenuItem.FIV +".저장옵션 "
					+ NumOfMenuItem.SIX +".종료\n"
					+ "=============================================");
		System.out.print("메뉴선택 : ");
	}
	
	// 입력
	public void dataInput(int choice) {
		
		Scanner scan = new Scanner(System.in);
		
		String name, phoneNumber, 전공, 학번, 회사명;
		
		System.out.println("== 주소록을 입력함 ==");
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println(NumOfSubMenuItem.ONE + ". 일반, "
						+NumOfSubMenuItem.TWO + ". 동창, "
						+NumOfSubMenuItem.THR + " .회사 ");
		System.out.print("선택 >> ");
		choice = scan.nextInt();
		if(choice==1) {
			scan.nextLine();
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			
			PhoneInfo normalInfo = new PhoneInfo(name, phoneNumber);
			boolean a = phoneInfo.add(normalInfo);
			if(a==true) {
				phoneInfo.add(normalInfo);
			}
			else {
				System.out.println("중복된 데이터가 있습니다.\n"
						+ "덮어쓰시겠습니까? "+ "1. Yes / 2. No");
				int ask = scan.nextInt();
				if(ask==1) {
					phoneInfo.remove(normalInfo);
					phoneInfo.add(normalInfo);
				}
				else if(ask==2) {
					phoneInfo.remove(phoneInfo.add(normalInfo));
				}
			}
		}
		else if(choice==2) {
			scan.nextLine();
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.print("전공 : ");전공 = scan.nextLine();
			System.out.print("학번 : ");학번 = scan.nextLine();
			
			PhoneInfo schoolInfo = new PhoneSchoolInfo(name, phoneNumber, 전공, 학번);
			boolean a = phoneInfo.add(schoolInfo);
			if(a==true) {
				phoneInfo.add(schoolInfo);
			}
			else {
				System.out.println("중복된 데이터가 있습니다.\n"
						+ "덮어쓰시겠습니까? "+ "1. Yes / 2. No");
				int ask = scan.nextInt();
				if(ask==1) {
					phoneInfo.remove(schoolInfo);
					phoneInfo.add(schoolInfo);
				}
				else if(ask==2) {
					phoneInfo.remove(phoneInfo.add(schoolInfo));
				}
			}
		}
		else if(choice==3) {
			scan.nextLine();
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.print("회사 : ");회사명 = scan.nextLine();
			
			PhoneInfo companyInfo = new PhoneCompanyInfo(name, phoneNumber, 회사명);
			boolean a = phoneInfo.add(companyInfo);
			if(a==true) {
				phoneInfo.add(companyInfo);
			}
			else {
				System.out.println("중복된 데이터가 있습니다.\n"
						+ "덮어쓰시겠습니까? "+ "1. Yes / 2. No");
				int ask = scan.nextInt();
				if(ask==1) {
					phoneInfo.remove(companyInfo);
					phoneInfo.add(companyInfo);
				}
				else if(ask==2) {
					phoneInfo.remove(phoneInfo.add(companyInfo));
				}
			}
		}
		
		System.out.println("== 입력이 완료되었습니다 ==");
	}
	
	// 검색
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 통해 검색합니다.");
		System.out.print("이름 : ");
		String searchName = scan.nextLine();
		
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo inputName = itr.next();
			if(searchName.compareTo(inputName.name)==0) {
				System.out.println("== 검색결과가 있습니다 ==");
				inputName.showPhoneInfo();
			}
			else {
				System.out.println("== 검색결과가 없습니다 ==");
			}
		}
	}
	
	// 삭제
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("정보를 삭제합니다.");
		System.out.print("이름 : ");
		String deleteName = scan.nextLine();
		
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo inputName = itr.next();
			if(deleteName.compareTo(inputName.name)==0) {
				System.out.println("== 데이터("+inputName.name+")이(가) 삭제되었습니다 ==");
				phoneInfo.remove(inputName);
			}
			else {
				System.out.println("== 삭제된 데이터가 없습니다 ==");
			}
		}
	}
	
	// 주소록 전체 출력
	public void dataAllShow() {
		
		System.out.println("== 주소록을 출력함 ==");
		
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo object = itr.next();
			object.showPhoneInfo();
		}
		System.out.println("== 주소록 출력이 완료되었습니다 ==");
	}
	
	// 입력정보를 파일로 저장하기
	public void myThread() {
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		System.out.println("== 저장옵션 선택 ==");
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1. 자동저장On,   2. 자동저장Off");
		choice = scan.nextInt();
		if(choice==1) {
			start();
		}
		else if(choice==2) {
			interrupt();
		}
	}
	
	
	
	
	
//	try {
//		ObjectOutputStream out = 
//				new ObjectOutputStream(
//						new FileOutputStream("src/project1/ver08/AutoSaveBook.txt"));
//		
//		Iterator<PhoneInfo> itr = phoneInfo.iterator();
//		while(itr.hasNext()) {
//			PhoneInfo object = itr.next();
//		}
//		System.out.println("저장이 완료되었습니다.");
//		
//	}
//	catch(Exception e) {
//		System.out.println("입력정보 파일저장 시 예외발생");
//		e.printStackTrace();
//	}
	
	
	
	
}


