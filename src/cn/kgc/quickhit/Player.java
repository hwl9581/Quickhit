package cn.kgc.quickhit;

import java.util.Scanner;
/**
 * 玩家类。
 */
public class Player {

	private int levelNo; // 级别号
	private int curScore; // 当前积分
	private long startTime = 0; // 各级别开始时间
	private int elapsedTime; // 各级别已用时间

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public int getCurScore() {
		return curScore;
	}

	public void setCurScore(int curScore) {
		this.curScore = curScore;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapseTime) {
		this.elapsedTime = elapseTime;
	}

	/**
	 * 玩家玩游戏。
	 */
	public void play() {
		Game game = new Game(this);
		Scanner input = new Scanner(System.in);
		// 外层循环，循环一次级别晋一级
		for (int i = 0; i < LevelParam.levels.length; i++) {
			// 1、 晋级
			this.levelNo += 1;
			// 2、 晋级后计时清零,积分清零
			this.startTime = System.currentTimeMillis();
			this.curScore = 0;
			// 3、 内层循环，循环一次完成一次字符串的输出、输入、比较
			for (int j = 0; j < LevelParam.levels[levelNo-1].getStrTime(); j++) {
				// 3.1、游戏输出字符串
				String outStr = game.printStr();
				// 3.2、接收用户输入
				String inStr = input.next();
				// 3.3、游戏判断玩家输入是否正确，并输出相应结果信息
				game.printResult(outStr, inStr);
			}
		}
	}
}
