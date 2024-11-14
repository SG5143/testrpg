package textRPG;

import managers.IOManager;
import stage.Lobby;

public class Game {
	private Lobby lobby;

	private Game() {
		this.lobby = new Lobby();
	}

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	public void run() {
		startMessage();
		String menu = IOManager.inputString("여기에 입력 ☞ ");

		if (menu.equals("시작"))
			lobby.activate();
		else {
			exitMessage();
			return;
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