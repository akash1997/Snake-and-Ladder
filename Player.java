package snakenladder;

/**
 *
 * @author AKASH
 */
public class Player {
	String name;
    public Player(int _number) {
		this.name="P"+(_number+1);
	}
	boolean move(int i,int f) {
		Square curr=Board.getSquare(i);
		Square next=Board.getSquare(f);
		curr.playersHere().remove(this);
		next.add(this,i);
		return true;
	}
}
