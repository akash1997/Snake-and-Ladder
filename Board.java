package snakenladder;

import java.util.*;

/**
 *
 * @author AKASH
 */
public class Board {
    
	static Square[] s;
    public Board() {
		s=new Square[101];
		initialise();
    }
	private void initialise() {
		ArrayList<Integer> redirectingFrom=new ArrayList<>(Arrays.asList(4,9,17,20,28,40,51,54,62,63,64,71,87,93,95,99));
		ArrayList<Integer> redirectingTo=new ArrayList<>(Arrays.asList(14,31,7,38,84,59,67,34,19,81,60,91,24,73,75,78));
		//System.out.println("Initialising board...");
		for(int i=0;i<101;i++) {
			if(!redirectingFrom.isEmpty()) {
				if(redirectingFrom.get(0)==i) {
					s[i]=new RedirectingSquare(i,redirectingTo.remove(0));
					redirectingFrom.remove(0);
				}
				else
					s[i]=new NormalSquare(i);
			}
			else
				s[i]=new NormalSquare(i);
		}
	}
	/*void addPlayer(int location,Player p) {
		s[location].players.add(p);
	}*/
	static Square getSquare(int location) {
		//System.out.println(location);
		return s[location];
	}
	
	static void display() {
		System.out.print(" ");
		for(int i=0;i<129;i++)
			System.out.print("_");
		System.out.println("");
		for(int i=9;i>=0;i--) {
			if(i%2==0){
				for(int j=10*i+1;j<10*i+11;j++) {
					System.out.printf("|%-12s",s[j].number);
				}
				System.out.println("|");
				for(int j=10*i+1;j<10*i+11;j++) {
					if(!"\"\"".equals(s[j].getPlayers()))
						System.out.printf("|%-12s",s[j].getPlayers());
					else
						System.out.printf("|%-12s","");
				}
				System.out.println("|");
				System.out.print("|");
				for(int y=0;y<10;y++) {
					for(int z=0;z<12;z++) {
						System.out.print("_");
					}
					System.out.print("|");
				}
				System.out.println("");
			}
			else {
				for(int j=10*i+10;j>=10*i+1;j--) {
					System.out.printf("|%-12s",s[j].number);
				}
				System.out.println("|");
				for(int j=10*i+10;j>=10*i+1;j--) {
					if(!"\"\"".equals(s[j].getPlayers()))
						System.out.printf("|%-12s",s[j].getPlayers());
					else
						System.out.printf("|%-12s","");
				}
				System.out.println("|");
				System.out.print("|");
				for(int y=0;y<10;y++) {
					for(int z=0;z<12;z++) {
						System.out.print("_");
					}
					System.out.print("|");
				}
				System.out.println("");
			}
		}
	}
}