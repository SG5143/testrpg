package managers;

import java.util.ArrayList;
import java.util.Random;

import units.Monster;
import units.Player;

public class UnitManager {
	private Random random;

	private static ArrayList<Player> playerList;
	private static ArrayList<Player> partyList;
	private ArrayList<Monster> monsterList;

	private final String PATE = "managers.";
	private final String MONS[] = { "아직!", "안 만듬", "몬스터" };

	private UnitManager() {
		playerList = new ArrayList<Player>();
		monsterList = new ArrayList<Monster>();
		random = new Random();
	}

	private static UnitManager instance = new UnitManager();

	public static UnitManager getInstance() {
		return instance;
	}

	// 사이즈 만큼 괴물 추가
	public void generateRandomMoster(int size) {
		for (int i = 0; i < size; i++) {
			int num = random.nextInt(MONS.length);
			String className = PATE + MONS[num];
			try {
				Class<?> cls = Class.forName(className);
				Monster monster = (Monster) cls.getConstructor().newInstance();
				monsterList.add(monster);
			} catch (Exception e) {
				// 에러발생?
			}
		}
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

	public static Player getPlayerByIndex(int index) {
		return playerList.get(index);
	}

	public static int getPlayerListSize() {
		return playerList.size();
	}
}