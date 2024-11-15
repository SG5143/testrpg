package stage;

import item.Item;
import managers.IOManager;
import managers.UserDataManager;

public class Inventory implements Stage {
	public void activate() {
		stageInfo();
		while (true) {
			String menu = IOManager.inputString("여기에 입력 ☞ ");

			if (menu.equals("나가기"))
				break;
			else if (isValidInputNum(menu)) {
				sellItem(menu);
				stageInfo();
			}
		}
	}

	private boolean isValidInputNum(String menu) {
		int num = -1;

		try {
			num = Integer.parseInt(menu) - 1;

			if (num >= 0 && num < UserDataManager.getItemListSize())
				return true;

		} catch (NumberFormatException e) {
			return false;
		}

		return false;
	}

	private void sellItem(String menu) {
		int select = Integer.parseInt(menu) - 1;

		Item item = UserDataManager.getItemByIndex(select);

		int userGold = UserDataManager.getGold();

		if (item.getPrice() + userGold > 999999) {
			printSellFailure();
			return;
		}

		UserDataManager.setGold(userGold + item.getPrice() / 2);
		UserDataManager.removeItemByIndex(select);

		printSellSuccess();
	}

	private void printSellFailure() {
		String msg = """

				=========================================
				=                                       =
				=          판매에 실패했습니다!         =
				=                                       =
				=========================================
				""";
		IOManager.printString(msg);
	}

	private void printSellSuccess() {
		String msg = """

				=========================================
				=                                       =
				=          판매에 성공했습니다!         =
				=                                       =
				=========================================
				""";
		IOManager.printString(msg);
	}

	private void stageInfo() {
		String msg = """

				=========================================
				=              < 인벤토리 >             =
				=                                       =
				=     이름      체력   공격        가격 =
				""";
		IOManager.printString(msg);

		for (int i = 0; i < UserDataManager.getItemListSize(); i++) {
			Item item = UserDataManager.getItemByIndex(i);
			IOManager.printString(String.format("= %2d)%-6s\t%5d\t%3d\t%7d =\n", i + 1, item.getName(), item.getHp(),
					item.getAtt(), item.getPrice()));
		}

		msg = """
				=========================================
				=       번호를 입력하면 판매 가능       =
				=          단 판매 시 가격 절반         =
				=  나가기를 입력하면 로비로 이동합니다  =
				=       현재 Gold : %10d          =
				=========================================
				""";
		IOManager.printString(String.format(msg, UserDataManager.getGold()));
	}
}
