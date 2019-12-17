package cn.kgc.quickhit;

/**
 * ��Ҽ���
 */
public class Level {
	private int levelNo; // �����
	private int strLength; // ������һ������ַ����ĳ���
	private int strTime; // ����������ַ����Ĵ���
	private int timeLimit; // �����𴳹ص�ʱ������
	private int perScore; // ������ɹ�����һ���ַ��������ӵķ�ֵ
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
