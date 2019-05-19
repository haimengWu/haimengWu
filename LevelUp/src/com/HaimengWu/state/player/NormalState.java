package com.HaimengWu.state.player;

import com.HaimengWu.beans.Player;
import com.HaimengWu.state.PlayerState;

public class NormalState implements PlayerState{
	
	public Player doAction(Player player) {
		player.normal();
		return player;
	}

}
