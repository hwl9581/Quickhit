package cn.kgc.quickhit;

/**
 * 玩家级别
 */
public class Level {
	private int levelNo; // 级别号
	private int strLength; // 各级别一次输出字符串的长度
	private int strTime; // 各级别输出字符串的次数
	private int timeLimit; // 各级别闯关的时间限制
	private int perScore; // 各级别成功输入一次字符串后增加的分值
	public Level(int levelNo, int strLength, int strTime, int timeLimit,
			int perScore) {
		this.levelNo = levelNo;
		this.strLength = strLength;
		this.strTime = strTime;
		this.timeLimit = timeLimit;
		this.perScore = perScore;
	}
	public int getLevelNo() {
		return levelNo;
	}
	public int getStrLength() {
		return strLength;
	}
	public int getStrTime() {
		return strTime;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public int getPerScore() {
		return perScore;
	}
}
