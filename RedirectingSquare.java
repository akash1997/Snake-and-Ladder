package snakenladder;

import java.util.ArrayList;
/**
 *
 * @author AKASH
 */
public class RedirectingSquare extends Square{
    int to;
	public RedirectingSquare(int _number, int _to) {
		super(_number);
		this.to=_to;
	}
	
	@Override
	public boolean add(Player p,int from) {
		if(from<to)
			System.out.println("Wow, Ladder to "+to);
		else
			System.out.println("Ohno, Snake to "+to);
		p.move(from,to);
		return true;
	}
	
	@Override
	public ArrayList playersHere() {
		return null;
	}

	@Override
	public String getPlayers() {
		if(number<to)
			return "Ladder to "+to;
		else
			return "Snake to "+to;
	}
	
	
}
