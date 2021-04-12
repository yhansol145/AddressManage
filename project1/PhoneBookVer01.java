package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {
		
		PhoneInfo phoneinfo1 = new PhoneInfo("성낙현", "010-7906-3600", "751130");
		PhoneInfo phoneinfo2 = new PhoneInfo("류상미", "010-7669-4120");
		
		phoneinfo1.showPhoneInfo();
		System.out.println();
		phoneinfo2.showPhoneInfo();
		
	}

}
