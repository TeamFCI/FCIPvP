package de.happyhappyboy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFcipvp implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			final Player p = (Player) sender; 
			if(args.length == 0) {
				if(p.hasPermission("fci.fcipvp.fcipvp")) {
					p.sendMessage("§b/fcipvp start");
					p.sendMessage("§b/fcipvp stop");
					p.sendMessage("§b/fcipvp set spawn|world|time|stats|Flag Value");
					p.sendMessage("§b/fcipvp info");
					p.sendMessage("§b/fcipvp debug");
					p.sendMessage("§b/fcipvp topten");
					p.sendMessage("§b/fcipvp tournament on|off");
					p.sendMessage("§b/fcipvp reload");
					
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
			if(args.length == 1) {
				if(p.hasPermission("fci.fcipvp.set.spawn")) {
					
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
		}
		
		return false;
	}
	
	public static Integer plusplus(int a) {
		a = a + 1;
		
		return a;
	}
	
}
