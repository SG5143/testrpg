package managers;

import java.util.ArrayList;
import java.util.Random;

import units.Monster;

public class UnitManager {
	private Random random;

	private ArrayList<Monster> monsterList;

	private final String PATE = "managers.";
	private final String MONS[] = { "아직!", "안 만듬", "몬스터" };

	private UnitManager() {

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
}