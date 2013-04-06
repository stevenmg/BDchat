package org.theglicks.bukkit.BDchat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messenger {
  
	public static void SendErrorMessage(Player p, int MessageID){
		switch (MessageID){
			case 1: p.sendMessage(ChatColor.RED + "Please use /cc (Channel Name)");
					break;
			case 2: p.sendMessage(ChatColor.RED + "Please use /cc (Channel Name) (Message)");
					break;
		}
	}
	
	public static void ChannelChangedMessage(Player p, String Channel){
		p.sendMessage(ChatColor.GREEN + "You are now talking in channel: " + Channel);
	}
}
