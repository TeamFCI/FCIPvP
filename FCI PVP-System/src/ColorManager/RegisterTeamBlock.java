package ColorManager;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.teamfci.fcipvp.FCIPVP;

public class RegisterTeamBlock implements Listener {
	public static FCIPVP pl;
	public RegisterTeamBlock(FCIPVP pl) {
		this.pl = pl;
	}
	public static HashMap<String, BukkitRunnable> showSelBlock = new HashMap<String, BukkitRunnable>();
	@SuppressWarnings("deprecation")
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
						if(ColorManager.customBlocks.containsKey(p.getName()+"ID") && ColorManager.customBlocks.containsKey(p.getName()+"SubID")) {
							p.sendMessage("§c/fcipvp color editor toggleblock (BlockID:SubID)");
							return;
						}
						if(showSelBlock.containsKey(p.getName())) {
							p.sendMessage("§cWarte bis der Block registriert wurde!");
							return;
						}
						showSelectedBlock(p, blockLoc, block.getType(), 0);
						double coreState = ColorManager.editor.get(p);
						ColorManager.setTeamBlock(blockLoc, p, coreState);
						blockLoc.add(0,1,0);
						for(Player p1 : Bukkit.getOnlinePlayers()) {
							for(int i = 0; i < 10; i++) {
								blockLoc.add(0,0.2,0);
								p1.playEffect(blockLoc, Effect.HAPPY_VILLAGER, 2);
							}
							blockLoc.add(0,-20,0);
							p.playSound(blockLoc, Sound.NOTE_PIANO, 1F, 1F);
						}
						p.sendMessage("§aColorManager-Marker zum CoreState hinzugefügt!");
						p.sendMessage("§aDein CoreState: §e"+coreState);
					} else {
						p.sendMessage("§a/fcipvp color editor (0.0->100.0)|exit");
					}
				}
			}
		}
	}
	
	public void showSelectedBlock(final Player p, final Location loc, final Material blockMat, final int anima) {
		showSelBlock.put(p.getName(), new BukkitRunnable() {
			int an = anima;
			@Override
			public void run() {
				if(an == 0) {
					loc.getBlock().setType(Material.WOOL);
				}
				if(an == 1) {
					loc.getBlock().setType(blockMat);
				}
				if(an == 2) {
					loc.getBlock().setType(Material.WOOL);
				}
				if(an == 3) {
					loc.getBlock().setType(blockMat);
				}
				if(an == 4) {
					loc.getBlock().setType(Material.WOOL);
				}
				if(an == 5) {
					loc.getBlock().setType(blockMat);
				}
				if(an == 6) {
					loc.getBlock().setType(Material.WOOL);
				}
				if(an == 7) {
					loc.getBlock().setType(blockMat);
				}
				if(an == 8) {
					loc.getBlock().setType(Material.WOOL);
				}
				if(an == 9) {
					loc.getBlock().setType(blockMat);
				}
				if(an == 10) {
					loc.getBlock().setType(Material.WOOL);
				}
				if(an == 11) {
					loc.getBlock().setType(blockMat);
				}
				if(an == 12) {
					showSelBlock.get(p.getName()).cancel();
					showSelBlock.remove(p.getName());
				}
				an++;
			}
		});
		showSelBlock.get(p.getName()).runTaskTimer(pl, 3L, 3L);
	}
	
}
