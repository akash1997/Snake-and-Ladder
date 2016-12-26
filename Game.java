package snakenladder;

import java.util.Scanner;

/**
 *
 * @author AKASH
 */
public class Game {
    
	static Player[] p;
	static Board b;
	static int value=0;
	static int chances=0;
    public static void main(String[] args) {
        
		Scanner scan=new Scanner(System.in);
                int turn=0;
		
		System.out.print("Enter the number of players playing: ");
		int number=scan.nextInt();
		b=new Board();
		createPlayers(number);
		Dice d=new Dice();
		System.out.println("Rolling the dice 60,000 times for testing purposes:");
		d.rollTest();
		System.out.println(b.getSquare(0).getPlayers());
		while("\"\"".equals(b.getSquare(100).getPlayers())) {
			b.display();
			System.out.println("Turn of P"+(turn%number+1));
			play(turn%number,d);
			turn++;
		}
		System.out.println("Congratulations, "+Board.getSquare(100).getPlayers()+" wins!");
		b.display();
    }
    static void createPlayers(int number) {
		p=new Player[number];
		for(int i=0;i<number;i++) {
			p[i]=new Player(i);
			b.getSquare(0).add(p[i],0);
		}
	}

	private static void play(int player,Dice d) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Press enter to roll the die!");
		String inp=scan.nextLine();
		int die=d.rollDice();
                System.out.println("Rolled a :-");
                System.out.println(" ------- ");
                switch (die) {
                    case 1:System.out.println("|       |\n|   o   |\n|       |");
                        break;
                    case 2:System.out.println("| o     |\n|       |\n|     o |");
                        break;
                    case 3:System.out.println("| o     |\n|   o   |\n|     o |");
                        break;
                    case 4:System.out.println("| o   o |\n|       |\n| o   o |");
                        break;
                    case 5:System.out.println("| o   o |\n|   o   |\n| o   o |");
                        break;
                    default:System.out.println("| o   o |\n| o   o |\n| o   o |");
                }
                System.out.println(" ------- ");
		value+=die;
		chances++;
		while(die==6 && chances<3) {
			die=d.rollDice();
                        System.out.println(" ------- ");
                        switch (die) {
                            case 1:System.out.println("|       |\n|   o   |\n|       |");
                                break;
                            case 2:System.out.println("| o     |\n|       |\n|     o |");
                                break;
                            case 3:System.out.println("| o     |\n|   o   |\n|     o |");
                                break;
                            case 4:System.out.println("| o   o |\n|       |\n| o   o |");
                                break;
                            case 5:System.out.println("| o   o |\n|   o   |\n| o   o |");
                                break;
                            default:System.out.println("| o   o |\n| o   o |\n| o   o |");
                        }
                        System.out.println(" ------- ");
			value+=die;
			if(die==6)
				chances++;
		}
		if(chances==3) {
			System.out.println("Rolled 6 thrice. Bad luck.");
			chances=0;
			value=0;
			return;
		}
		for(int i=0;i<100;i++) {
			//System.out.println(Board.getSquare(i).number);
			Square curr=Board.getSquare(i);
			if(curr instanceof NormalSquare) {
				if(Board.getSquare(i).playersHere().contains(p[player])) {
					if((i+value)<=100) {
						System.out.println("Moving from "+i+" to "+(i+value));
						p[player].move(i, (i+value));
					}
					else {
						System.out.println("Exceeding 100, better luck next time.");
						return;
					}
					break;
				}
			}
		}
		/*int i=Player.getLocation();
		if((i+value)<=100) {
			System.out.println("Moving from "+i+" to "+(i+value));
			p[player].move(i, (i+value));
		}
		else {
			System.out.println("Exceeding 100, better luck next time.");
			return;
		}*/
		value=0;
		chances=0;
	}
}
