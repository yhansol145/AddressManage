package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver07.MenuItem.NumOfMenuItem;
import project1.ver07.SubMenuItem.NumOfSubMenuItem;
	
public class PhoneBookManager {
	
	HashSet<PhoneInfo> phoneInfo = new HashSet<PhoneInfo>();
	
	MenuItem menuItem = new MenuItem();
	SubMenuItem subMenuItem = new SubMenuItem();
	
//	public PhoneInfo[] myPhoneInfo;
//	public int numOfPhoneInfo;
//	
//	public PhoneBookManager() {
//		myPhoneInfo = new PhoneInfo[100];
//		numOfPhoneInfo = 0;
//	}
	
	// 메뉴출력
	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println(NumOfMenuItem.ONE +". 데이터 입력");
		System.out.println(NumOfMenuItem.TWO +". 데이터 검색");
		System.out.println(NumOfMenuItem.THR +". 데이터 삭제");
		System.out.println(NumOfMenuItem.FOU +". 주소록 출력");
		System.out.println(NumOfMenuItem.FIV +". 프로그램 종료");
		System.out.print("선택 : ");
	}
	
	// 입력
	public void dataInput(int choice) {
		
		Scanner scan = new Scanner(System.in);
		
		String name, phoneNumber, 전공, 학번, 회사명;
		
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
			phoneInfo.add(normalInfo);
//			myPhoneInfo[numOfPhoneInfo++] = phoneInfo;
			
		}
		else if(choice==2) {
			scan.nextLine();
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.print("전공 : ");전공 = scan.nextLine();
			System.out.print("학번 : ");학번 = scan.nextLine();
			
			PhoneInfo schoolInfo = new PhoneSchoolInfo(name, phoneNumber, 전공, 학번);
			phoneInfo.add(schoolInfo);
		}
		else if(choice==3) {
			scan.nextLine();
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.print("회사 : ");회사명 = scan.nextLine();
			
			PhoneInfo companyInfo = new PhoneCompanyInfo(name, phoneNumber, 회사명);
			phoneInfo.add(companyInfo);
		}
		
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}
	
	// 검색
	public void dataSearch() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("이름을 통해 검색합니다.");
		System.out.print("이름 : ");
		String searchName = scan.nextLine();
		
		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo inputName = itr.next();
			if(inputName.name.equals(searchName)) {
				System.out.println("검색결과가 있습니다.");
				System.out.println(searchName);
			}
			else {
				System.out.println("검색결과가 없습니다.");
			}
		}
	}
	
	// 삭제
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("정보를 삭제합니다.");
		System.out.print("이름 : ");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
//		for(int i=0 ; i<numOfPhoneInfo ; i++) {
//			if(deleteName.compareTo(myPhoneInfo[i].name)==0) {
//				myPhoneInfo[i] = null;
//				deleteIndex = i;
//				numOfPhoneInfo--;
//				break;
//			}
//		}
		
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIndex ; i<numOfPhoneInfo ; i++) {
				myPhoneInfo[i] = myPhoneInfo[i+1];
			}
			System.out.println("데이터("+ deleteIndex+"번)이 삭제되었습니다.");
		}
	}
	
	// 주소록 전체 출력
	public void dataAllShow() {
		
		Iterator itr = phoneInfo.iterator();
		while(itr.hasNext()) {
			Object phoneInfo = itr.next();
			
		}
	}
}

