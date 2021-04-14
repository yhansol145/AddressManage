package project1.ver07;

import java.util.Scanner;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	
	public PhoneInfo() {
		
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
	}
	
	public void showPhoneInfo(String name, String phoneNumber) {
		System.out.println("name : "+ name);
		System.out.println("phone : "+ phoneNumber);
	}
	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		if(phoneInfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}


