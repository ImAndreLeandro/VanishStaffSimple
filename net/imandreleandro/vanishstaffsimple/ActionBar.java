package net.imandreleandro.vanishstaffsimple;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class ActionBar {
	
	public ActionBar(Player p, String message) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(
				"{\"text\":\"" + message + "\"}"), (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
	
}
