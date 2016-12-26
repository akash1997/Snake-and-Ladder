package snakenladder;
import java.util.ArrayList;
/**
 *
 * @author AKASH
 */
abstract class Square {
	int number;
    public Square(int _number) {
		this.number=_number;
	}
	/*static void add(Player p) {
		NormalSquare.addPlayer(p);
	}*/
	public abstract boolean add(Player p,int from);
	
	public abstract String getPlayers();
	
	public abstract ArrayList playersHere();
	
	int getNumber() {
		return number;
	}
}
