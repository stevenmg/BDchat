package org.theglicks.bukkit.BDchat;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {
  public void onPlayerLeave(PlayerQuitEvent playerLeave){
		Channels.removePlayer(playerLeave.getPlayer());
		PlayerWorldList.remove(playerLeave.getPlayer());
	}
}
