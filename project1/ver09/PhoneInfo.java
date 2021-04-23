package project1.ver09;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo() {
		
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "생년월일없음";
	}
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("생년월일 : "+ birthday);
	}
	
	//전체정보출
	public void showPhoneInfo(String name, String phoneNumber, String birthday) {
		System.out.println("name : "+ name);
		System.out.println("phone : "+ phoneNumber);
		System.out.println("birth : "+ birthday);

	}
	
}
