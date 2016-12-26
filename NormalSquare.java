package snakenladder;

import java.util.ArrayList;

/**
 *
 * @author AKASH
 */
public class NormalSquare extends Square{
	ArrayList<Player> players=new ArrayList<>();
	public NormalSquare(int _number) {
		super(_number);
	}
	
	@Override
	public boolean add(Player p,int from) {
		players.add(p);
		return true;
	}

	@Override
	public String getPlayers() {
		String here="\"";
		if(!players.isEmpty()) {
			for(int i=0;i<players.size()-1;i++) {
				here+=players.get(i).name+",";
			}
			here+=players.get(players.size()-1).name;
		}
		here+="\"";
		return here;
	}
	@Override
	public ArrayList playersHere() {
		return players;
	}
	
}
