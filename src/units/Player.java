package units;

import managers.IOManager;

public class Player {

	private String name; // 유저 이름

	private int level; // 플레이어 레벨
	private int maxHp; // 최대 체력
	private int hp; // 체력
	private int exp; // 경험치
	private int att; // 공격력

	private boolean party;

	public Player() {}

	public Player(String name, int maxHp, int att) {
		super();
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.att = att;
	}

	public Player(String name, int level, int maxHp, int hp, int exp, int att, boolean party) {
		super();
		this.name = name;
		this.level = level;
		this.maxHp = maxHp;
		this.hp = hp;
		this.exp = exp;
		this.att = att;
		this.party = party;
	}

	public void attack(Monster target) {
		
	}
	
	public void printPlayer() {
		String info = String.format("[%15s][%5d/%5d][Att : %d]", name, hp, maxHp, att);
		IOManager.printString(info);
	}
}