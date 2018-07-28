package net.imandreleandro.vanishstaffsimple;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class eventJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		for (Player all : Bukkit.getServer().getOnlinePlayers()) {
			if (Vanish.list.contains(all)) {
				if (p.hasPermission(Main.getInstance().getConfig().getString("Permission"))) {
					p.showPlayer(all);
				} else {
					p.hidePlayer(all);
				}
			} else {
				p.showPlayer(all);
			}
		}
	}
	
}
