package org.theglicks.bukkit.BDchat.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.theglicks.bukkit.BDchat.BDchat;
import org.theglicks.bukkit.BDchat.BDchatPlayer;

public class LoginListener implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent playerLogin){
		BDchatPlayer BDplayer = new BDchatPlayer(playerLogin.getPlayer().getName());
		BDplayer.setChannel(BDchat.mainConfig.getConfig().getString("defaultChannel"), false);
		BDchat.BDchatPlayerList.put(BDplayer.getName(), BDplayer);
	}
}