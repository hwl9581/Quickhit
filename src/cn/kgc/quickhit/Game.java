package cn.kgc.quickhit;

import java.util.Random;
/**
 * 游戏类
 */
public class Game {
	private Player player;// 玩家
		
	/**
	 * 构造方法，传入玩家信息。
	 * @param player 玩家
	 */
	public Game(Player player) {
		this.player = player;
	}
	/**
	 * 输出指定级别规定长度的字符串。
	 * @return 输出的字符串，用于和用户输入比较
	 */
	public String printStr() {
		int strLength = LevelParam.levels[player.getLevelNo() - 1].getStrLength();
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		// 1、通过循环生成要输出的字符串
		for (int i = 0; i < strLength; i++) {
			// 1.1、产生随机数
			int rand = random.nextInt(strLength);
			// 1.2、根据随机数拼接字符串
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
		// 2、输出字符串
		System.out.println(buffer);
		// 3、返回字符串用于和玩家输入相比较
		return buffer.toString();
	}
	/**
	 * 判断玩家输入是否正确，并输出相应结果信息。
	 * @param out 游戏输出的字符串
	 * @param in 玩家输入的字符串
	 */
	public void printResult(String out, String in) {
		boolean flag;
		if (out.equals(in)) {
			flag=true;
		} else {
			flag=false;
		}
		// 1、 如果输入正确
		if (flag) {
			long currentTime = System.currentTimeMillis();
			// 1.1、 如果超时
			if ((currentTime - player.getStartTime()) / 1000 
					>LevelParam.levels[player.getLevelNo() - 1].getTimeLimit()) {
				System.out.println("你输入太慢了，已经超时，退出！");
				System.exit(1);
				// 1.2、 如果没有超时
			} else {				
				// 1.2.1、 计算当前积分
				player.setCurScore(player.getCurScore()
						+ LevelParam.levels[player.getLevelNo() - 1].getPerScore());
				// 1.2.2、 计算已用时间
				player.setElapsedTime((int) ((currentTime - player
						.getStartTime()) / 1000));
				// 1.2.3、输出当前积分、当前级别、已用时间
				System.out.println("输入正确，您的级别"+ player.getLevelNo()+" ,您的积分" + player.getCurScore() + ",已用时间"	+ player.getElapsedTime() + "秒。");
				// 1.2.4、判断用户是否已经闯过最后一关
				if (player.getLevelNo() == 6) {
					int score=LevelParam.levels[player.getLevelNo() - 1].getPerScore() 
							* LevelParam.levels[player.getLevelNo() - 1].getStrTime();//计算闯关分数
					if (player.getCurScore() == score) {
						System.out.println("你已闯关成功，成为绝世高手，恭喜你！！！");
						System.exit(0);
					}
				}
			}
			// 2、如果输入错误
		} else {
			System.out.println("输入错误，退出！");
			System.exit(1);
		}
	}
}
