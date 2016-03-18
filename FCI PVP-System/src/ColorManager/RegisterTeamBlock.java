package ColorManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RegisterTeamBlock implements Listener {
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			ItemStack item = p.getItemInHand();
			if(item.getType() == Material.FEATHER) {
				if(p.hasPermission("fci.pvp.colormanager.editor")) {
					if(ColorManager.editor.containsKey(p)) {
						Block block = (Block) e.getClickedBlock();
						Location blockLoc = block.getLocation();
						blockLoc.getBlock().setType(Material.WOOL);
						double coreState = ColorManager.editor.get(p);
						ColorManager.setTeamBlock(blockLoc, p, coreState);
						p.sendMessage("¤aColorManager-Marker zum CoreState hinzugefügt!");
						p.sendMessage("¤aDein CoreState: ¤e"+coreState);
					} else {
						p.sendMessage("¤a/fcipvp colormanager editor (0.0->100.0)|exit");
					}
				}
			}
		}
	}
}
