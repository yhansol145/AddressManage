package project1.ver08;

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
		System.out.printf("이름 : %s, 전화번호 : %s, 전공 : %s, 학년 : %s\n"
				, name, phoneNumber, 전공, 학년);
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + ",\n 전화번호 : " + phoneNumber + ", 전공 : " + 전공 + ", 학년 : "+ 학년;
	}
}