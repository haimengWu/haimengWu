package com.HaimengWu.state.player;

import com.HaimengWu.state.PlayerState;
import com.HaimengWu.beans.Player;

public class PlayerContext {
	private PlayerState playerState = null;
	
	public Player doAction(Player player) {
		return playerState.doAction(player);
	}
	
	public PlayerState getPlayerState() {
		return playerState;
	}
	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}
}
