package org.theglicks.bukkit.BDchat;

import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

public class ChatListener implements Listener {
  @EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent playerChat){
		
		playerChat.getRecipients().clear();
		
		Player chatSender = playerChat.getPlayer();
		String playerChannel = Channels.GetPlayerChannel(chatSender);
		String channelType = Channels.GetChannelType(playerChannel);
		String prefix = Channels.getPrefix(playerChannel);
		
		if(channelType.equals("global")){
			playerChat.getRecipients().addAll(PlayerWorldList.GetList().keySet());
		} else if(channelType.equals("local_range")){
			Location senderLocation = playerChat.getPlayer().getLocation();
			for (Entry<Player, World> currentEntry : PlayerWorldList.GetList().entrySet()){
				if(currentEntry.getValue().equals(chatSender.getWorld())){
					if(currentEntry.getKey().getLocation().distance(senderLocation) < /*MClass.getRange(playerChannel)*/ 150){
						playerChat.getRecipients().add(currentEntry.getKey());
					}
				}
			}
		} else if(channelType.equals("local_world")){
			World senderWorld = chatSender.getWorld();
			for(Entry<Player, World> currentEntry : PlayerWorldList.GetList().entrySet()){
				if(currentEntry.getValue().equals(senderWorld)){
					playerChat.getRecipients().add(currentEntry.getKey());
				}
			}
		} else if(channelType.equals("faction_only")){
			playerChat.getRecipients().clear();
			FPlayer fsender = FPlayers.i.get(chatSender);
			for (FPlayer fplayer: FPlayers.i.get()){
				if(fplayer.getFaction().equals(fsender.getFaction())){
					playerChat.getRecipients().add(fplayer.getPlayer());
				}
			}
		}		
		
		for(Player currentPlayer: PlayerWorldList.GetList().keySet()){
			if(!Permissions.canView(currentPlayer, playerChannel)){
				playerChat.getRecipients().remove(currentPlayer);
			}
		}
		playerChat.setFormat(playerChat.getFormat().replace("[BDchat]", ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.WHITE));
		playerChat.setMessage(ChatColor.translateAlternateColorCodes('&', Channels.getFormat(playerChannel)) + playerChat.getMessage());
	}
}
