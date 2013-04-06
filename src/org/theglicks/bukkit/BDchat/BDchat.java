package org.theglicks.bukkit.BDchat;

import org.bukkit.plugin.java.JavaPlugin;

public class BDchat extends JavaPlugin{  
	
	private static String defaultChannel;
	
	public void onEnable(){
		this.getConfig().options().copyDefaults(true);
		this.saveDefaultConfig();
		
		defaultChannel = getConfig().getString("DefaultChannel");
		
		for(String channel: getConfig().getConfigurationSection("Channels").getKeys(false)){
			String type = getConfig().getString("Channels." + channel + ".Type");
			String prefix = getConfig().getString("Channels." + channel + ".Prefix");
			String format = getConfig().getString("Channels." + channel + ".MessageFormat");
			Channels.addChannel(channel, type, prefix, format);
		}
		
		getCommand("cc").setExecutor(new CommandListener(this));
		
		getServer().getPluginManager().registerEvents(new WorldChangeListener(), this);
		getServer().getPluginManager().registerEvents(new LoginListener(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
		
		Channels.loadPlayers();
		PlayerWorldList.loadPlayers();
	}
	
	public void onDisable(){
		
	}
	
	public static String defChannel(){
		return defaultChannel;
	}
	
	/*public int getRange(String channel){
		return getConfig().getInt("Channels." + channel + ".Range");
	}*/
}
