package de.happyhappyboy.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.happyhappyboy.main.FCIPVP;
import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.effect.WarpEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class ShieldActivateEvent implements Listener {
	public static HashMap<String, BukkitRunnable> shield = new HashMap<String, BukkitRunnable>();
	public static FCIPVP pl;
	public ShieldActivateEvent(FCIPVP pl) {
		this.pl = pl;
	}
	
	@EventHandler
	public void onBlock(PlayerInteractEvent e) {
		final Player p = (Player) e.getPlayer();
		ItemStack item = p.getItemInHand();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(p.isSneaking()){
				if(item.getType() != Material.DIAMOND_SWORD) {
					return;
				}
				if(p.hasPermission("fci.pvp.shield.use")) {
					
					
					if(shield.containsKey(p.getName())) {
						return;
					}
					if(p.getGameMode() != GameMode.CREATIVE){
						if(p.getFoodLevel() >= 1) {
						} else {
							p.sendMessage("§7Du bist zu hungrig.. Iss n Snickers.");
							return;
						}
						p.setFoodLevel(p.getFoodLevel()-2);
						p.sendMessage("§7Dir wurden §c-2 Keulen §7abgezogen! Du hast noch §a"+p.getFoodLevel()+" Keulen");
					}
					final ShieldEffect eff1 = new ShieldEffect(FCIPVP.em);
					eff1.setLocation(p.getLocation());
					eff1.particle = ParticleEffect.CRIT_MAGIC;
					eff1.start();
					final WarpEffect eff2 = new WarpEffect(FCIPVP.em);
					eff2.setLocation(p.getLocation());
					eff2.particle = ParticleEffect.SPELL_WITCH;
					eff2.start();
					for(Player p2 : Bukkit.getOnlinePlayers()) {
						p2.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1, 1);
					}
					for(Entity ent : p.getNearbyEntities(3, 3, 3)) {
						ent.setVelocity(ent.getLocation().getDirection().multiply(-1.6D).setY(1D));
					}
					shield.put(p.getName(), new BukkitRunnable() {

						@SuppressWarnings("unused") int count = 0;
						@Override
						public void run() {
							eff1.setLocation(p.getLocation());
							eff2.cancel();
							for(Entity ent : p.getNearbyEntities(3, 3, 3)) {
								ent.setVelocity(ent.getLocation().getDirection().multiply(-1.6D).setY(1D));
							}
							if(count == 2) {
								eff1.cancel();
								shield.get(p.getName()).cancel();
								shield.remove(p.getName());
							}
							count++;
						}
						
					});
					shield.get(p.getName()).runTaskTimer(pl, 5L, 5L);
					
				}
			}
		}
	}
	
}
