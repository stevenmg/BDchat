package org.theglicks.bukkit.BDchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor{

  public CommmandListener(BDchat mainClass) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player chatSender = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("cc")){
			if(args.length < 1){
				Messenger.SendErrorMessage(chatSender, 1);
			} else {
				if (Permissions.canTalk(chatSender, args[0])) {
					if (args.length == 1) {
						Channels.ChangeChannel(chatSender, args[0], true);
					} else if (args.length > 1) {
						String message = "";
						int counter = 0;
						for (String arg : args) {
							counter++;
							if (counter > 1) {
								message = message + arg + ' ';
							}
						}
						String currentChannel = Channels.GetPlayerChannel(chatSender);
						if(Channels.ChangeChannel(chatSender, args[0], false)){
							chatSender.chat(message);
							Channels.ChangeChannel(chatSender, currentChannel, false);
						}
					}
				} else {
					sender.sendMessage(ChatColor.RED + "You do not have permssion to talk in that channel!");
				}
			}
		}
		return false;
	}

}
