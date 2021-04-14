package project1.ver07;

class PhoneSchoolInfo extends PhoneInfo {
	String 전공;
	String 학년;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String 전공, String 학년) {
		super(name, phoneNumber);
		this.전공 = 전공;
		this.학년 = 학년;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("전공 : "+ 전공);
		System.out.println("학년 : "+ 학년);
	}
}