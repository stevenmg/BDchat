package org.theglicks.bukkit.BDchat;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayerWorldList {
  
	private static HashMap<Player, World> playerWorlds = new HashMap<Player, World>();
	
	public static void Add(Player p, World w){
		playerWorlds.put(p, w);
	}
	
	public static void remove(Player player){
		playerWorlds.remove(player);
	}
	
	public static void loadPlayers(){
		for(Player currentPlayer: Bukkit.getOnlinePlayers()){
			PlayerWorldList.Add(currentPlayer, currentPlayer.getWorld());
		}
	}
	
	public static HashMap<Player, World> GetList(){
		return playerWorlds;
	}
}
