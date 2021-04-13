package project1.ver07;

class PhoneCompanyInfo extends PhoneInfo {
	String 회사명;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String 회사명) {
		super(name, phoneNumber);
		this.회사명 = 회사명;
	}
}