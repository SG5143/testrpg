package managers;

import java.util.ArrayList;

import item.Item;
import units.Player;

public class UserDataManager {

	private static int gold;
	private static ArrayList<Player> playerList;
	private static ArrayList<Player> partyList;
	private static ArrayList<Item> itemList;

	private UserDataManager() {
		playerList = new ArrayList<Player>();
		partyList = new ArrayList<Player>();
		itemList = new ArrayList<Item>();
		UserDataManager.gold = 5000;
	}

	private static UserDataManager instance = new UserDataManager();

	public static UserDataManager getInstance() {
		return instance;
	}

	public static void setUserData(int money, ArrayList<Item> itemList) {
		UserDataManager.gold = money;
		UserDataManager.itemList = itemList;
	}

	public static void addItemList(Item item) {
		UserDataManager.itemList.add(item);
	}

	public static int getGold() {
		return gold;
	}

	public static void setGold(int gold) {
		UserDataManager.gold = gold;
	}

	public static void addPlayer(Player player) {
		playerList.add(player);
	}

	public static void joinPartyByindex(int index) {
		Player player = playerList.get(index);
		partyList.add(player);
		player.party = true;
	}

	public static void removePlayerByIndex(int index) {
		playerList.remove(index);
	}

	public static void removePartyByIndex(int index) {
		Player player = partyList.get(index);
		partyList.remove(index);
		player.party = false;
	}

	public static void removeItemByIndex(int index) {
		itemList.remove(index);
	}

	public static Player getPlayerByIndex(int index) {
		return playerList.get(index);
	}

	public static int getPlayerListSize() {
		return playerList.size();
	}

	public static int getItemListSize() {
		return itemList.size();
	}

	public static Item getItemByIndex(int index) {
		return itemList.get(index);
	}
}