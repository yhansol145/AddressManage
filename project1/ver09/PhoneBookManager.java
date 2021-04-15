package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;
import jdbc.connect.IConnectImpl;

public class PhoneBookManager extends IConnectImpl{
	
	public PhoneBookManager() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	public PhoneInfo[] myPhoneInfo;
	public int numOfPhoneInfo;
	
	
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
		try {
			String query = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("이름 : ");
			String name = scan.nextLine();
			System.out.println("전화번호 : ");
			String phonenumber = scan.nextLine();
			System.out.println("생년월일 : ");
			String birthday = scan.nextLine();
			psmt.setString(1, name);
			psmt.setString(2, phonenumber);
			psmt.setString(3, birthday);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 삭제
	public void dataDelete() {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, scanValue("삭제 할 이름"));
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 검색
    public void dataSearch() {
	    try {
	        while(true) {
	        String sql = "SELECT * FROM phonebook_tb "
	                  + " WHERE name LIKE '%'||?||'%'";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, scanValue("찾는이름"));
            rs = psmt.executeQuery();
            	while(rs.next()) {
            		String name = rs.getString(1);
		            String phone = rs.getString(2);
		            String birthday = rs.getString(3);
		            System.out.printf("%s %s %s\n",
		                     name, phone, birthday);
            	}
	        }
	    }
        catch(SQLException e) {
        e.printStackTrace();
	    }
    }
	
	// 주소록 전체 출력
   public void dataAllShow() {
	    try {   
	    	stmt = con.createStatement();
		    String query = "SELECT * from phonebook_tb";
		    rs = stmt.executeQuery(query);
		    while(rs.next()) {
		        String name = rs.getString(1);
		        String phone = rs.getString(2);
		        String birthday = rs.getString(3);
		        System.out.printf("%s %s %s\n",
		               name, phone, birthday);
		    }
	    }
	    catch(SQLException e) {
	    System.out.println("쿼리오류발생");
	    e.printStackTrace();
	    }
	    System.out.println("전체정보가 출력되었습니다.");
	}
	
	@Override
	public void close() {
		super.close();
	}
}
