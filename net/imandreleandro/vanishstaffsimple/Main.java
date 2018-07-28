package net.imandreleandro.vanishstaffsimple;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main main;
	
	public static Main instance;
	
	public Main() {
		instance = this;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public void onEnable() {
		main = this;
		
		getCommand("vanish").setExecutor(new cmdVanish());
		getCommand("v").setExecutor(new cmdVanish());
		
		Bukkit.getPluginManager().registerEvents(new eventJoin(), this);
		
	}
	
	public void onDisable() {
		
	}
	
}
