package snakenladder;

/**
 *
 * @author AKASH
 */
public class Dice {
    static int rollDice() {
		Double val=Math.floor(6*Math.random())+1;
		return val.intValue();
	}
	static void rollTest() {
		int[] val=new int[6];
		for(int i=0;i<60000;i++) {
			int value=rollDice();
			val[value-1]++;
		}
		System.out.println("Dice test results: ");
		for(int i=0;i<6;i++) {
			System.out.println((i+1)+": "+val[i]);
		}
	}
}
