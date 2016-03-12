package de.happyhappyboy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.happyhappyboy.main.FCIPvP;
import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;

public class CommandsFcipvp implements CommandExecutor {
	EffectManager em = FCIPvP.em;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender; 
			if(args.length == 0) {
				if(p.hasPermission("fci.fcipvp.fcipvp")) {
					p.sendMessage("§b/fcipvp helix");
					p.sendMessage("§b/fcipvp dna");
					p.sendMessage("§b/fcipvp atom");
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
			if(args.length == 1) {
				if(p.hasPermission("fci.fcipvp.example")) {
					
					Effect eff = new Ef(em);
					
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
		}
		
		return false;
	}
	
}
