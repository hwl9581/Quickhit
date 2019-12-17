package cn.kgc.quickhit;

import java.util.Random;
/**
 * ��Ϸ��
 */
public class Game {
	private Player player;// ���
		
	/**
	 * ���췽�������������Ϣ��
	 * @param player ���
	 */
	public Game(Player player) {
		this.player = player;
	}
	/**
	 * ���ָ������涨���ȵ��ַ�����
	 * @return ������ַ��������ں��û�����Ƚ�
	 */
	public String printStr() {
		int strLength = LevelParam.levels[player.getLevelNo() - 1].getStrLength();
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		// 1��ͨ��ѭ������Ҫ������ַ���
		for (int i = 0; i < strLength; i++) {
			// 1.1�����������
			int rand = random.nextInt(strLength);
			// 1.2�����������ƴ���ַ���
			switch (rand) {
			case 0:
				buffer.append(">");
				break;
			case 1:
				buffer.append("<");
				break;
			case 2:
				buffer.append("*");
				break;
			case 3:
				buffer.append("&");
				break;
			case 4:
				buffer.append("%");
				break;
			case 5:
				buffer.append("#");
				break;
			}
		}
		// 2������ַ���
		System.out.println(buffer);
		// 3�������ַ������ں����������Ƚ�
		return buffer.toString();
	}
	/**
	 * �ж���������Ƿ���ȷ���������Ӧ�����Ϣ��
	 * @param out ��Ϸ������ַ���
	 * @param in ���������ַ���
	 */
	public void printResult(String out, String in) {
		boolean flag;
		if (out.equals(in)) {
			flag=true;
		} else {
			flag=false;
		}
		// 1�� ���������ȷ
		if (flag) {
			long currentTime = System.currentTimeMillis();
			// 1.1�� �����ʱ
			if ((currentTime - player.getStartTime()) / 1000 
					>LevelParam.levels[player.getLevelNo() - 1].getTimeLimit()) {
				System.out.println("������̫���ˣ��Ѿ���ʱ���˳���");
				System.exit(1);
				// 1.2�� ���û�г�ʱ
			} else {				
				// 1.2.1�� ���㵱ǰ����
				player.setCurScore(player.getCurScore()
						+ LevelParam.levels[player.getLevelNo() - 1].getPerScore());
				// 1.2.2�� ��������ʱ��
				player.setElapsedTime((int) ((currentTime - player
						.getStartTime()) / 1000));
				// 1.2.3�������ǰ���֡���ǰ��������ʱ��
				System.out.println("������ȷ�����ļ���"+ player.getLevelNo()+" ,���Ļ���" + player.getCurScore() + ",����ʱ��"	+ player.getElapsedTime() + "�롣");
				// 1.2.4���ж��û��Ƿ��Ѿ��������һ��
				if (player.getLevelNo() == 6) {
					int score=LevelParam.levels[player.getLevelNo() - 1].getPerScore() 
							* LevelParam.levels[player.getLevelNo() - 1].getStrTime();//���㴳�ط���
					if (player.getCurScore() == score) {
						System.out.println("���Ѵ��سɹ�����Ϊ�������֣���ϲ�㣡����");
						System.exit(0);
					}
				}
			}
			// 2������������
		} else {
			System.out.println("��������˳���");
			System.exit(1);
		}
	}
}
