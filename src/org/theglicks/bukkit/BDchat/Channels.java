package org.theglicks.bukkit.BDchat;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Channels{
  
	private static HashMap<String, String> channels = new HashMap<String, String>();
	private static HashMap<Player, String> playerChannels = new HashMap<Player, String>();
	private static HashMap<String, String> channelPrefix = new HashMap<String, String>();
	private static HashMap<String, String> channelFormat = new HashMap<String, String>();
	
	public static void addChannel(String channel, String type, String prefix, String format){
		channels.put(channel, type);
		channelPrefix.put(channel, prefix.replace(".", ""));
		channelFormat.put(channel, format.replace(".", ""));
	}
	
	public static HashMap<String, String> GetChannels(){
		return channels;
	}
	
	public static boolean ChangeChannel(Player p, String Channel, boolean sendMessage){
		if (channels.containsKey(Channel)) {
			playerChannels.put(p, Channel);
			if(sendMessage == true){
				Messenger.ChannelChangedMessage(p, Channel);
			}
			return true;
		}
		else{
			Messenger.SendErrorMessage(p, 1);
		}
		return false;
	}
	
	public static void loadPlayers(){
		for(Player currentPlayer: Bukkit.getOnlinePlayers()){
			Channels.ChangeChannel(currentPlayer, BDchat.defChannel(), false);
		}
	}
	
	public static void removePlayer(Player player){
		playerChannels.remove(player);
	}
	
	public static String GetPlayerChannel(Player player){
		return playerChannels.get(player);
	}
	
	public static String GetChannelType(String channel){
		return channels.get(channel);
	}
	
	public static String getPrefix(String channel){
		return channelPrefix.get(channel);
	}
	
	public static String getFormat(String channel){
		return channelFormat.get(channel);
	}
}
