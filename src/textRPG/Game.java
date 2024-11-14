package textRPG;

import managers.IOManager;
import stage.Lobby;

public class Game {
	private Lobby lobby;
	private boolean isRun = true;

	private Game() {
		this.lobby = new Lobby();
	}

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	public void run() {
		startMessage();
		while (true) {
			String menu = IOManager.inputString("여기에 입력 ☞ ");

			if (menu.equals("시작"))
				isRun = lobby.activate();
			else if (menu.equals("종료"))
				isRun = false;

			if (!isRun) {
				exitMessage();
				return;
			}
		}
	}

	private void startMessage() {
		String msg = """
				===========================
				=        TEXT RPG         =
				=   시작하려면 "시작"을   =
				=   종료하려면 "종료"를   =
				=      입력해주세요.      =
				===========================
				""";
		IOManager.printString(msg);
	}

	private void exitMessage() {
		String msg = """

				===========================
				=       종료합니다        =
				===========================
				""";

		IOManager.printString(msg);
	}
}