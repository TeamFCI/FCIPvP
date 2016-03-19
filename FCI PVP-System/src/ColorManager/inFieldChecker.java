package ColorManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class inFieldChecker implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = (Player) e.getPlayer();
		if(ColorManager.enable == false) {
			return;
		}
//		Location min = dataprovider.getLocation("EnergyCore//area.yml", p, "Area1.Location");
//		Location max = dataprovider.getLocation("EnergyCore//area.yml", p, "Area2.Location");
//		for(int x = min.getBlockX(); x <= max.getBlockX(); x++){
//		    for(int y = min.getBlockY(); y <= max.getBlockY(); y++){
//		        for(int z = min.getBlockZ(); z <= max.getBlockZ(); z++){
//		            Location loc = new Location(min.getWorld(), x, y, z);
//		            Location pLoc = p.getLocation();
//		            if(loc.equals(pLoc)) {
//		            	p.sendMessage("Jop!");
//		            }
//		        }
//		    }
//		}
		int maxPlayers = Bukkit.getOnlinePlayers().size();
		int i = 0;
		i = i + 1;
		Location loc = p.getLocation();
		loc.setY(loc.getY() - 2);
		Block block1 = loc.getBlock();
		loc.setY(loc.getY() - 1);
		Block block2 = loc.getBlock();
		loc.setY(loc.getY() - 1);
		Block block3 = loc.getBlock();
		if(block1.getType() == Material.WOOL) {
			if(block2.getType() == Material.REDSTONE_BLOCK) {
				if(block3.getType() == Material.BEDROCK) {
					ColorManager.inField = true;
					ColorManager.inFieldPlayer = p;
					ColorManager.infieldplayers.add(p.getName());
				} else {
					if(i == maxPlayers) {
						ColorManager.inField = false;
					}
				}
			}
		}
	}
	
}
