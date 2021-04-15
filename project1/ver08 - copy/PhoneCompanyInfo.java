package project1.ver08;

class PhoneCompanyInfo extends PhoneInfo {
	String 회사명;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String 회사명) {
		super(name, phoneNumber);
		this.회사명 = 회사명;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.printf("이름 : %s, 전화번호 : %s, 회사명 : %s\n"
				, name, phoneNumber, 회사명);
	}
	@Override
	public String toString() {
		return "이름 : " + name + ",\n 전화번호 : " + phoneNumber + ", 회사명 : " + 회사명;
	}
}