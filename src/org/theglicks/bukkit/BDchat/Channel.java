package org.theglicks.bukkit.BDchat;

public class Channel {
	
	private String channelName;
	
	public Channel(String name){
		channelName = name;
	}
	
	public String getName(){
		return channelName;
	}
	
	public String getType(){
		return BDchat.channelConfig.getConfig().getString("channels." + channelName + ".type");
	}
	
	public String getDescription(){
		return BDchat.channelConfig.getConfig().getString("channels." + channelName + ".description");
	}
	
	public String getPrefix(){
		return BDchat.channelConfig.getConfig().getString("channels." + channelName + ".prefix");
	}
	
	public String getFormat(){
		return BDchat.channelConfig.getConfig().getString("channels." + channelName + ".format");
	}
	
	public int getRange(){
		return BDchat.channelConfig.getConfig().getInt("channels." + channelName + ".range");
	}
}