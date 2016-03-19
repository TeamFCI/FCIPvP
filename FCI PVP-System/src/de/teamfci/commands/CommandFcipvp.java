package de.teamfci.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ColorManager.CommandFunctions;
import ColorManager.ColorManager;
import de.teamfci.dataprovider.dataprovider;

public class CommandFcipvp implements CommandExecutor {
	static String prefix = "§a[§bFCI PVP§a] §b";
	CommandFunctions cf = new CommandFunctions();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			final Player p = (Player) sender; 
			if(args.length == 0) {
				if(p.hasPermission("fci.fcipvp.fcipvp")) {
					p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");
					p.sendMessage("§bPlugin von §aTeamFCI");
					p.sendMessage("§bAuftrag von §aTNT_Creepy");
					if(!p.hasPermission("fci.fcipvp.get.admincommands")){
						p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");
						return true;
					}
					p.sendMessage(prefix + "/fcipvp start");
					p.sendMessage(prefix + "/fcipvp stop");
					p.sendMessage(prefix + "/fcipvp set spawn (Team)|time|stats|Flag Value|Area1|Area2");
					p.sendMessage(prefix + "/fcipvp debug");
					p.sendMessage(prefix + "/fcipvp topten");
					p.sendMessage(prefix + "/fcipvp tournament on|off");
					p.sendMessage(prefix + "/fcipvp reload");
					p.sendMessage(prefix + "/fcipvp color editor (0.0->100.0)|exit");
					p.sendMessage(prefix + "/fcipvp enable on|off");
					p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
			if(args.length == 1) {
				if(p.hasPermission("fci.fcipvp.set.spawn")) {
					if(args[0].equalsIgnoreCase("set")) {
						p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");	
						p.sendMessage(prefix + "/fcipvp set spawn (Team)");
						p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");	
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
				if(p.hasPermission("fci.fcipvp.start")) {
					if(args[0].equalsIgnoreCase("start")) {
						Location l1 = dataprovider.getSpawnLocation("blau", p);
						Location l2 = dataprovider.getSpawnLocation("grün", p);
						Location l3 = dataprovider.getSpawnLocation("rot", p);
						Player hhb = Bukkit.getPlayer("HappyHappyBoy");
						Player tnt = Bukkit.getPlayer("TNT_Creepy");
						Player fil = Bukkit.getPlayer("FilipZocktan");
						if(hhb != null) {
							dataprovider.set("location", "Player.Event.PVP.Lastlocation.Location", hhb, "", 0, false);
							hhb.teleport(l1);
							hhb.sendMessage("§eDu bist Team §bBlau");
						}
						if(tnt != null) {
							dataprovider.set("location", "Player.Event.PVP.Lastlocation.Location", tnt, "", 0, false);
							tnt.teleport(l2);
							tnt.sendMessage("§eDu bist Team §aGrün");
						}
						if(fil != null) {
							dataprovider.set("location", "Player.Event.Lastlocation.Location", fil, "", 0, false);
							fil.teleport(l3);
							fil.sendMessage("§eDu bist Team §cRot");
						}
						Bukkit.broadcastMessage("§7[§6FCI-PVP§7] §8Das Event hat begonnen!");
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
				if(p.hasPermission("fci.fcipvp.stop")) {
					if(args[0].equalsIgnoreCase("stop")) {
						Player hhb = Bukkit.getPlayer("HappyHappyBoy");
						Player tnt = Bukkit.getPlayer("TNT_Creepy");
						Player fil = Bukkit.getPlayer("FilipZocktan");
						if(hhb != null) {
							Location l1 = dataprovider.getPlayerLocationFromConfig("pvp", hhb);
							hhb.teleport(l1);
							hhb.sendMessage("§cVerlassen");
						}
						if(tnt != null) {
							Location l2 = dataprovider.getPlayerLocationFromConfig("pvp", tnt);
							tnt.teleport(l2);
							tnt.sendMessage("§cVerlassen");
						}
						if(fil != null) {
							Location l3 = dataprovider.getPlayerLocationFromConfig("pvp", fil);
							fil.teleport(l3);
							fil.sendMessage("§cVerlassen");
						}
						Bukkit.broadcastMessage("§7[§6FCI-PVP§7] §8Das Event ist beendet worden!");
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
			if(args.length == 2) {
				if(p.hasPermission("fci.fcipvp.set.spawn")) {
					if(args[0].equalsIgnoreCase("set")) {
						if(args[1].equalsIgnoreCase("spawn")) {
							p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");
							p.sendMessage(prefix + "/fcipvp set spawn (Team)");
							p.sendMessage("§a§l *-*-*-*-*-*-*-*-*-*-*-*");
						}
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
				if(p.hasPermission("fci.fcipvp.set.areas")) {
					if(args[0].equalsIgnoreCase("set")) {
						if(args[1].equalsIgnoreCase("area1")) {
							dataprovider.setAreaLocation(p.getLocation(), p, "Area1");
							p.sendMessage("§aArea1(Eckpunkt) wurde gesetzt!");
						}
						if(args[1].equalsIgnoreCase("area2")) {
							dataprovider.setAreaLocation(p.getLocation(), p, "Area2");
							p.sendMessage("§aArea2(Eckpunkt) wurde gesetzt!");
						}
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
				if(p.hasPermission("fci.fcipvp.turn.colormanager")) {
					if(args[0].equalsIgnoreCase("enable")) {
						if(args[1].equalsIgnoreCase("off")) {
							ColorManager.enable = false;
							ColorManager.d = 0.0;
							p.sendMessage(prefix + "§aColorManager disabled");
						}
						if(args[1].equalsIgnoreCase("on")) {
							ColorManager.enable = true;
							ColorManager.d = 0.0;
							p.sendMessage(prefix + "§aColorManager enabled");
						}
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
			}
			if(args.length == 3) {
				if(p.hasPermission("fci.fcipvp.set.spawn")) {
					if(args[0].equalsIgnoreCase("set")) {
						if(args[1].equalsIgnoreCase("spawn")) {
							String team = args[2];
							if(team.equalsIgnoreCase("grün")) {
								dataprovider.setSpawnLocation(team, p.getLocation(), p);
							}
							if(team.equalsIgnoreCase("blau")) {
								dataprovider.setSpawnLocation(team, p.getLocation(), p);
							}
							if(team.equalsIgnoreCase("rot")) {
								dataprovider.setSpawnLocation(team, p.getLocation(), p);
							}
						}
					}
				} else {
					p.sendMessage("§cFehler: Du hast nicht die Permission dazu!");
				}
				if(p.hasPermission("fci.pvp.colormanager.editor")) {
					if(args[0].equalsIgnoreCase("color")) {
						if(args[1].equalsIgnoreCase("editor")) {
							if(args[2].equalsIgnoreCase("exit")) {
								cf.exitEditor(p);
							} else {
								double coreState = Double.valueOf(args[2]);
								cf.joinEditor(p, coreState);
							}
						}
					}
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
