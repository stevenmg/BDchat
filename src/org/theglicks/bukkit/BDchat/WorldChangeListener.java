package org.theglicks.bukkit.BDchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChangeListener implements Listener {
  
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent worldChangeEvent){
		PlayerWorldList.Add(worldChangeEvent.getPlayer(), worldChangeEvent.getPlayer().getWorld());
	}
}
