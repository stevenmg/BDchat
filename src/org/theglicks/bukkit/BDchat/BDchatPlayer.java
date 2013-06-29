package org.theglicks.bukkit.BDchat;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class BDchatPlayer {
	
	private String playerName;
	private String playerChannel;
	
	public BDchatPlayer(String name){
		playerName = name;
	}
	
	public Player getPlayer(){
		return Bukkit.getPlayer(playerName);
	}
	
	public String getName(){
		return playerName;
	}
	
	public Channel getChannel(){
		return BDchat.channelList.get(playerChannel);
	}
	
	public String getChannelAsString(){
		return playerChannel;
	}
	
	public boolean setChannel(String channel, boolean sendMessage){		
		if(BDchat.channelList.containsKey(channel)){
			playerChannel = channel;
			
			if(sendMessage == true){
				Messenger.channelChangedMessage(getPlayer(), playerChannel);
			} return true;
		} else {
			Messenger.invalidChannel(getPlayer(), playerChannel);
			return false;
		}
	}
	
	public World getWorld(){
		return getPlayer().getWorld();
	}
}