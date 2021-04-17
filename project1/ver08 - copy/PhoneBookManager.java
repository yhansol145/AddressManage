package project1.ver08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {

	HashSet<PhoneInfo> phoneInfo = new HashSet<PhoneInfo>();

	// 메뉴출력
	public void printMenu() {
		System.out.println("=============== 메뉴를 선택하세요 ===============");
		System.out.println(MenuItem.ONE + ".주소록 입력 " + MenuItem.TWO + ".검색 " + MenuItem.THR + ".삭제 " + MenuItem.FOU
				+ ".출력 " + MenuItem.FIV + ".저장옵션 " + MenuItem.SIX + ".종료\n"
				+ "=============================================");
		System.out.print("메뉴선택 : ");
	}

	// 입력
	public void dataInput(int choice) {

		Scanner scan = new Scanner(System.in);

		String name, phoneNumber, 전공, 학번, 회사명;

		System.out.println("== 주소록을 입력함 ==");
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println(SubMenuItem.ONE + ". 일반, " + SubMenuItem.TWO + ". 동창, " + SubMenuItem.THR + " .회사 ");
		System.out.print("선택 >> ");
		choice = scan.nextInt();
		if (choice == 1) {
			scan.nextLine();
			System.out.print("이름 : ");
			name = scan.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scan.nextLine();

			PhoneInfo normalInfo = new PhoneInfo(name, phoneNumber);
			boolean a = phoneInfo.add(normalInfo);
			if (a == true) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("중복된 데이터가 있습니다.\n" + "덮어쓰시겠습니까? " + "1. Yes / 2. No");
				int ask = scan.nextInt();
				if (ask == 1) {
					phoneInfo.remove(normalInfo);
					phoneInfo.add(normalInfo);
				} else if (ask == 2) {
					System.out.println("기존 데이터를 유지합니다.");
				}
			}
		} else if (choice == 2) {
			scan.nextLine();
			System.out.print("이름 : ");
			name = scan.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scan.nextLine();
			System.out.print("전공 : ");
			전공 = scan.nextLine();
			System.out.print("학번 : ");
			학번 = scan.nextLine();

			PhoneInfo schoolInfo = new PhoneSchoolInfo(name, phoneNumber, 전공, 학번);
			boolean a = phoneInfo.add(schoolInfo);
			if (a == true) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("중복된 데이터가 있습니다.\n" + "덮어쓰시겠습니까? " + "1. Yes / 2. No");
				int ask = scan.nextInt();
				if (ask == 1) {
					phoneInfo.remove(schoolInfo);
					phoneInfo.add(schoolInfo);
				} else if (ask == 2) {
					System.out.println("기존 데이터를 유지합니다.");
				}
			}
		} else if (choice == 3) {
			scan.nextLine();
			System.out.print("이름 : ");
			name = scan.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scan.nextLine();
			System.out.print("회사 : ");
			회사명 = scan.nextLine();

			PhoneInfo companyInfo = new PhoneCompanyInfo(name, phoneNumber, 회사명);
			boolean a = phoneInfo.add(companyInfo);
			if (a == true) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("중복된 데이터가 있습니다.\n" + "덮어쓰시겠습니까? " + "1. Yes / 2. No");
				int ask = scan.nextInt();
				if (ask == 1) {
					phoneInfo.remove(companyInfo);
					phoneInfo.add(companyInfo);
				} else if (ask == 2) {
					System.out.println("기존 데이터를 유지합니다.");
				}
			}
		}
		System.out.println("== 입력이 완료되었습니다 ==");
	}

	// 검색
	public void dataSearch() {
		boolean isSearch = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 통해 검색합니다.");
		System.out.print("이름 : ");
		String searchName = scan.nextLine();

		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while (itr.hasNext()) {
			PhoneInfo inputName = itr.next();
			if (searchName.compareTo(inputName.name) == 0) {
				System.out.println("== 검색결과가 있습니다 ==");
				inputName.showPhoneInfo();
				isSearch = true;
			}
		}
		if (isSearch == false) {
			System.out.println("검색결과가 없습니다.");
		}
	}

	// 삭제
	public void dataDelete() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("정보를 삭제합니다.");
		System.out.print("이름 : ");
		String deleteName = scan.nextLine();

		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while (itr.hasNext()) {
			PhoneInfo inputName = itr.next();
			if (deleteName.compareTo(inputName.name) == 0) {
				System.out.println("== 데이터(" + inputName.name + ")이(가) 삭제되었습니다 ==");
				phoneInfo.remove(inputName);
				isFind = true;
				break;
			}
		}
		if (isFind == false) {
			System.out.println("정보를 찾지 못했습니다.");
		}
	}

	// 주소록 전체 출력
	public void dataAllShow() {

		System.out.println("== 주소록을 출력함 ==");

		Iterator<PhoneInfo> itr = phoneInfo.iterator();
		while (itr.hasNext()) {
			PhoneInfo object = itr.next();
			object.showPhoneInfo();
		}
		System.out.println("== 주소록 출력이 완료되었습니다 ==");
	}

	// 저장
	public void savePhoneBook() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/project1/ver08/PhoneBook.obj");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

			Iterator itr = phoneInfo.iterator();
			while (itr.hasNext()) {
				Object a = (Object) itr.next();
				objOut.writeObject(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 불러오기
	public void callPhoneBook() {
		try {
			FileInputStream fileIn = new FileInputStream("src/project1/ver08/PhoneBook.obj");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);

			while (true) {
				PhoneInfo phone = (PhoneInfo) objIn.readObject();
				if (phone == null) {
					break;
				}
				phoneInfo.add(phone);
			}
		} catch (EOFException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 입력정보를 파일로 저장하기
	public void autoSave() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));

			Iterator itr = phoneInfo.iterator();
			while (itr.hasNext()) {
				PhoneInfo input = (PhoneInfo) itr.next();
				out.println(input.toString());
			}
			out.close();
		} catch (Exception e) {
			System.out.println("입력정보 파일저장 시 예외발생");
		}
	}
}