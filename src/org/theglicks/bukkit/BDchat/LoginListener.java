package org.theglicks.bukkit.BDchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginListener implements Listener {
  
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent playerLogin){
		PlayerWorldList.Add(playerLogin.getPlayer(), playerLogin.getPlayer().getWorld());
		Channels.ChangeChannel(playerLogin.getPlayer(), BDchat.defChannel(), false);
	}
}
