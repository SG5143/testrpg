package stage;

import managers.IOManager;
import managers.UnitManager;
import units.Player;

// 길드원 조회
// 길드원 랜덤추가
// 길드원 삭제

public class Guild implements Stage {

	public Guild() {
		// 길드 정보 초기 설정 2 플레이어 제공 및 파티 참여 설정
		UnitManager.addPlayer(new Player("모험가", 1000, 40));
		UnitManager.addPlayer(new Player("초보자", 700, 80));

		UnitManager.joinPartyByindex(0);
		UnitManager.joinPartyByindex(1);
	}

	public void activate() {
		stageInfo();
		while (true) {
			String menu = IOManager.inputString("여기에 입력 ☞ ");

			if (menu.equals("뉴맴버")) {
				gennerateNewMember();
			} else if (menu.equals("")) {
				deleteMember();
			} else if (menu.equals("나가기")) {
				return;
			}
		}
	}

	public void gennerateNewMember() {

	}

	public void deleteMember() {

	}

	private void stageInfo() {
		String msg = """

				===========================
				=      < 나의 길드 >      =
				=                         =
				=    이름      체력  공격 =
				""";
		IOManager.printString(msg);

		for (int i = 0; i < UnitManager.getPlayerListSize(); i++) {
			Player player = UnitManager.getPlayerByIndex(i);
			IOManager.printString(
					String.format("= %2d)%-6s%5d  %3d  =\n", i + 1, player.getName(), player.getHp(), player.getAtt()));
		}

		msg = """
				===========================
				=         뉴맴버를        =
				=       입력하면 추가     =
				=        삭제-번호를      =
				=   입력하면 삭제됩니다.  =
				=     나가기를 입력하면   =
				=     로비로 이동합니다   =
				===========================
				""";
		IOManager.printString(msg);
	}
}