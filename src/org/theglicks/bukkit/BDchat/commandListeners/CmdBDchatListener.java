package org.theglicks.bukkit.BDchat.commandListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.theglicks.bukkit.BDchat.BDchat;
import org.theglicks.bukkit.BDchat.BDchatPlayer;
import org.theglicks.bukkit.BDchat.Channel;

public class CmdBDchatListener implements CommandExecutor {
	public CmdBDchatListener(BDchat bDchat) {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		BDchatPlayer BDplayer = BDchat.BDchatPlayerList.get(sender.getName());
		if (sender instanceof Player) {
			if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
				for (String currentLine : BDchat.helpMessage) {
					BDplayer.getPlayer().sendMessage(
							ChatColor.translateAlternateColorCodes('&',
									currentLine));
				}
			} else if (args[0].equalsIgnoreCase("list")) {
				BDplayer.getPlayer().sendMessage(
						"§7----------§c[§aBDchat§c]§7----------");
				for (Channel currentChannel1 : BDchat.channelList.values()) {
					BDplayer.getPlayer().sendMessage(
							"§2" + currentChannel1.getName() + ": §a"
									+ currentChannel1.getDescription());
				}
			}
		} else if (sender instanceof ConsoleCommandSender) {
			if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
				for (String currentLine : BDchat.helpMessage) {
					Bukkit.getLogger().info(currentLine);
				}
			} else if (args[0].equalsIgnoreCase("list")) {
				Bukkit.getLogger().info(
						"§7----------§c[§aBDchat§c]§7----------");
				for (Channel currentChannel1 : BDchat.channelList.values()) {
					Bukkit.getLogger().info(
							"§2" + currentChannel1.getName() + ": §a"
									+ currentChannel1.getDescription());
				}
			}
		}
		return true;
	}
}
