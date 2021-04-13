package project1.ver03;

import java.util.Scanner;

import project1.ver03.PhoneInfo;

public class PhoneBookManager {
	
	public PhoneInfo[] myPhoneInfo;
	public int numOfPhoneInfo;
	
	public PhoneBookManager() {
		myPhoneInfo = new PhoneInfo[100];
		numOfPhoneInfo = 0;
	}
	
	// 메뉴출력
	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}
	
	// 입력
	public void dataInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = scan.nextLine();
		System.out.print("생년월일 : ");
		String birthday = scan.nextLine();
		
		PhoneInfo phoneInfo = new PhoneInfo(name, phoneNumber, birthday);
		myPhoneInfo[numOfPhoneInfo++] = phoneInfo;
		
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}
	
	// 검색
	public void dataSearch() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("이름을 통해 검색합니다.");
		System.out.print("이름 : ");
		String searchName = scan.nextLine();
		
		for(int i=0 ; i<numOfPhoneInfo ; i++) {
			if(searchName.compareTo(myPhoneInfo[i].name)==0) {
				myPhoneInfo[i].showPhoneInfo();
				System.out.println("요청하는 정보를 찾았습니다.");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("찾는정보가 없습니다.");
	}
	
	// 삭제
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("정보를 삭제합니다.");
		System.out.print("이름 : ");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0 ; i<numOfPhoneInfo ; i++) {
			if(deleteName.compareTo(myPhoneInfo[i].name)==0) {
				myPhoneInfo[i] = null;
				deleteIndex = i;
				numOfPhoneInfo--;
				break;
			}
		}
		
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
		for(int i=0 ; i<numOfPhoneInfo ; i++) {
			myPhoneInfo[i].showPhoneInfo();
		}
		System.out.println("전체정보가 출력되었습니다.");
	}
}
