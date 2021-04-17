package project1.ver08;

public class AutoSaverT extends Thread {

	PhoneBookManager manager;

	public AutoSaverT(PhoneBookManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void run() {
		try {
			while (true) {
				manager.autoSave();
				System.out.println("주소록이 텍스트로 자동저장 되었습니다.");
				sleep(5000);
			}
		} catch (InterruptedException e) {
		}
	}
}
