package org.theglicks.bukkit.BDchat;

import org.bukkit.entity.Player;

public class Permissions {
	public static boolean canView(Player player, String channel){
		if(player.hasPermission("BDchat." + channel + ".View")){
			return true;
		}
		return false;
	}
	public static boolean canTalk(Player player, String channel){
		if(player.hasPermission("BDchat." + channel + ".Talk")){
			return true;
		}
		return false;
	}
}