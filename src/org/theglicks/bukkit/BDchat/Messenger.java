package org.theglicks.bukkit.BDchat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messenger {
	
	public static void ccError(Player p){
		p.sendMessage(ChatColor.RED + "Please use /cc (channel) [message]");
	}
	
	public static void channelChangedMessage(Player p, String channel){
		p.sendMessage(ChatColor.GREEN + "You are now talking in channel: " + channel);
	}
	
	public static void invalidChannel(Player player, String channel){
		player.sendMessage(ChatColor.RED + "Channel does not exist: " + channel);
	}
}