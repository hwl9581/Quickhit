package cn.kgc.quickhit;

import java.util.Scanner;
/**
 * ����ࡣ
 */
public class Player {

	private int levelNo; // �����
	private int curScore; // ��ǰ����
	private long startTime = 0; // ������ʼʱ��
	private int elapsedTime; // ����������ʱ��

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
	 * �������Ϸ��
	 */
	public void play() {
		Game game = new Game(this);
		Scanner input = new Scanner(System.in);
		// ���ѭ����ѭ��һ�μ����һ��
		for (int i = 0; i < LevelParam.levels.length; i++) {
			// 1�� ����
			this.levelNo += 1;
			// 2�� �������ʱ����,��������
			this.startTime = System.currentTimeMillis();
			this.curScore = 0;
			// 3�� �ڲ�ѭ����ѭ��һ�����һ���ַ�������������롢�Ƚ�
			for (int j = 0; j < LevelParam.levels[levelNo-1].getStrTime(); j++) {
				// 3.1����Ϸ����ַ���
				String outStr = game.printStr();
				// 3.2�������û�����
				String inStr = input.next();
				// 3.3����Ϸ�ж���������Ƿ���ȷ���������Ӧ�����Ϣ
				game.printResult(outStr, inStr);
			}
		}
	}
}
