package stage;

import java.util.HashMap;
import java.util.Map;

import managers.IOManager;
import managers.UserDataManager;

public class Lobby {
	UserDataManager userData;
	Map<String, Stage> stageList;

	public Lobby() {
		userData = UserDataManager.getInstance();
		stageList = new HashMap<String, Stage>();
		stageList.put("길드", new Guild());
		stageList.put("파티", new Party());
		stageList.put("전투", new Bettle());
		stageList.put("상점", new Shop());
		stageList.put("인벤토리", new Inventory());
	}

	public boolean activate() {
		stageInfo();
		while (true) {
			String menu = IOManager.inputString("여기에 입력 ☞ ");

			if (stageList.containsKey(menu)) {
				stageList.get(menu).activate();
				stageInfo();
			} else if (menu.equals("종료"))
				break;
		}
		return false;
	}

	private void stageInfo() {
		String msg = """

				===========================
				=        < 로비 >         =
				=      아래의 메뉴를      =
				=   입력하면 이동합니다   =
				=                         =
				=   전투 | 파티 | 길드    =
				=   상점 | 인벤토리       =
				===========================
				""";
		IOManager.printString(msg);
	}
}