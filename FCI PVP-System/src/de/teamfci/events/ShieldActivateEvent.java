
package de.teamfci.events;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.effect.DragonEffect;
import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.effect.WarpEffect;
import de.slikey.effectlib.util.DynamicLocation;
import de.slikey.effectlib.util.ParticleEffect;
import de.teamfci.fcipvp.FCIPVP;

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
					DynamicLocation loc = new DynamicLocation(p.getLocation());
					final ShieldEffect eff1 = new ShieldEffect(FCIPVP.em);
					eff1.setDynamicOrigin(loc);
					eff1.particle = ParticleEffect.CRIT_MAGIC;
					eff1.autoOrient = false;
					eff1.radius = 4;
					eff1.particles = 200;
					
					final WarpEffect eff2 = new WarpEffect(FCIPVP.em);
					eff2.setDynamicOrigin(loc);
					eff2.particle = ParticleEffect.SPELL_WITCH;
					eff2.autoOrient = false;
					eff2.start();
					for(Player p2 : Bukkit.getOnlinePlayers()) {
						p2.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1, 1);
					}
					for(Entity ent : p.getNearbyEntities(3, 3, 3)) {
						if(ent instanceof Player || ent.getType().equals(EntityType.ARROW) || ent.getType().equals(EntityType.FIREBALL) || ent instanceof Monster) {
							ent.setVelocity(ent.getLocation().getDirection().multiply(-1D).setY(1D));
						}
					}
					File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"+p.getName()+"config.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					final int duration = cfg.getInt("Player.Class.Magier.Abilities.Shield.Duration");
			        final String shieldType = cfg.getString("Player.Class.Magier.Abilities.Shield.Type");
					
					shield.put(p.getName(), new BukkitRunnable() {
						int count = 0;
						int amount = 40 - eff1.radius;
						
						@Override
						public void run() {
							DynamicLocation loc = new DynamicLocation(p.getLocation());
							eff1.setDynamicOrigin(loc);
							eff1.autoOrient = false;
							eff2.setDynamicOrigin(loc);
							eff2.autoOrient = false;
							
							DragonEffect eff3 = new DragonEffect(FCIPVP.em);
							for(Entity ent : p.getNearbyEntities(eff1.radius, eff1.radius, eff1.radius)) {
								if(ent instanceof Animals || ent instanceof Item) {
								}else{
									ent.setVelocity(ent.getLocation().getDirection().multiply(-1.6D).setY(1D));
								}
							}
							if(count >= amount) {
								if(count <= 40) {
									if(eff1.radius != 0) {
										eff1.radius = eff1.radius - 1;
									}
								}
							}
							if(count == 1) {
								Location l = p.getLocation();
								l.setPitch(-90);
								DynamicLocation loc1 = new DynamicLocation(l);
								eff3.setDynamicOrigin(loc1);
								eff3.iterations = 10;
								eff3.particle = ParticleEffect.ENCHANTMENT_TABLE;
								eff3.start();
							}
							if(count == 5) {
								eff1.start();
							}
							if(count >= 7 && count <= 10) {
								if(eff1.radius != 0) {
									eff1.radius = eff1.radius + 1;
								}
							}
							if(count == 40) {
								eff3.duration = 1200;
								eff1.cancel();
								eff2.cancel();
							}
							if(count == 55) {
								shield.get(p.getName()).cancel();
								shield.remove(p.getName());
								count = 0;
							}
							count++;
						}
					});
					shield.get(p.getName()).runTaskTimer(pl, 1L, 1L);
				}
			}
		}
	}
}