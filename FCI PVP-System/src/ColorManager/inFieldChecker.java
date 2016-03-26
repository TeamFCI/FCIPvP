package ColorManager;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import de.teamfci.fcipvp.FCIPVP;

public class inFieldChecker implements Listener {
	
	public static FCIPVP pl;
	@SuppressWarnings("static-access")
	public inFieldChecker(FCIPVP pl) {
		this.pl = pl;
	}
	static HashMap<String, BukkitRunnable> checker = new HashMap<String, BukkitRunnable>();
	static ArrayList<String> list = new ArrayList<String>();
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		for(Player target : Bukkit.getOnlinePlayers()) {
			Location loc = target.getLocation();
			loc.add(0,-2,0);
			if(loc.getBlock().getType() == Material.WOOL) {
				loc.add(0,-1,0);
				if(loc.getBlock().getType() == Material.REDSTONE_BLOCK) {
					loc.add(0,-1,0);
					if(loc.getBlock().getType() == Material.BEDROCK) {
						ColorManager.inField = true;
						ColorManager.inFieldPlayer = target;
						break;
					} else {
						ColorManager.inField = false;
						ColorManager.inFieldPlayer = null;
					}
				} else {
					ColorManager.inField = false;
					ColorManager.inFieldPlayer = null;
				}
			} else {
				ColorManager.inField = false;
				ColorManager.inFieldPlayer = null;
			}
		}
	}
	
//	public static void start() {
//		checker.put("delay", new BukkitRunnable() {
//			@Override
//			public void run() {
//				if(ColorManager.enable == true) {
//					if(!list.contains("yes")) {
//						list.add("yes");
//						checker.put("check", new BukkitRunnable() {
//							@Override
//							public void run() {
//								if(ColorManager.enable == true) {
//									for(Player target : Bukkit.getOnlinePlayers()) {
//										Location loc = target.getLocation();
//										loc.add(0,-2,0);
//										if(loc.getBlock().getType() == Material.WOOL) {
//											loc.add(0,-1,0);
//											if(loc.getBlock().getType() == Material.REDSTONE_BLOCK) {
//												loc.add(0,-1,0);
//												if(loc.getBlock().getType() == Material.BEDROCK) {
//													ColorManager.inFieldPlayer = target;
//													list.remove("yes");
//													stop();
//												} else {
//													ColorManager.inFieldPlayer = null;
//												}
//											} else {
//												ColorManager.inFieldPlayer = null;
//											}
//										} else {
//											ColorManager.inFieldPlayer = null;
//										}
//									}
//								}
//							}
//							
//						});
//						checker.get("check").runTaskTimer(pl, 20L, 20L);
//					}
//				}
//			}
//			
//		});
//		checker.get("delay").runTaskTimer(pl, 30L, 30L);
//	}
//		
//	public static void stop() {
//		checker.get("check").cancel();
//	}
	
}
