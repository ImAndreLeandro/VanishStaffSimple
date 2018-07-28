package net.imandreleandro.vanishstaffsimple;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdVanish implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("vanish") || cmd.getName().equalsIgnoreCase("v")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				if (!p.hasPermission(Main.getInstance().getConfig().getString("Permission"))) {
					for (String s : Main.getInstance().getConfig().getStringList("No_Permission")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
					}
					return true;
				}
				
				if (Vanish.list.contains(p)) {
					Vanish.list.remove(p);
					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						all.showPlayer(p);
					}
				} else {
					Vanish.list.add(p);
					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						if (all.hasPermission(Main.getInstance().getConfig().getString("Permission"))) {
							all.showPlayer(p);
						} else {
							all.hidePlayer(p);
						}
					}
					Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new Runnable() {
						public void run() {
							if (Vanish.list.contains(p)) {
								new ActionBar(p, ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Vanish_Message")));
							}
						}
					}, 20L, 20L);
				}
				
			}
		}
		return false;
	}
	
}
