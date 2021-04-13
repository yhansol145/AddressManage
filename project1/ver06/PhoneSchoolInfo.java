package project1.ver06;

class PhoneSchoolInfo extends PhoneInfo {
	String 전공;
	String 학년;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String 전공, String 학년) {
		super(name, phoneNumber);
		this.전공 = 전공;
		this.학년 = 학년;
	}
}