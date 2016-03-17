package de.teamfci.displayDamage;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.teamfci.fcipvp.FCIPVP;

public class DamageIndicator {
	public static HashMap<String, BukkitRunnable> showDmg = new HashMap<String, BukkitRunnable>();
	public static FCIPVP pl;
	public DamageIndicator(FCIPVP pl) {
		this.pl = pl;
	}
	
	public static void indicator(final Player damager, Player entity, final double damage) {
		final Location loc = entity.getLocation();	
		final ArmorStand a1 = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		a1.setGravity(false);
		a1.setCustomName("§c-"+(int)damage);
		a1.setCustomNameVisible(true);
		a1.setVisible(false);
		showDmg.put(damager.getName(), new BukkitRunnable() {
			int count = 0;
			Location l = loc;
			@Override
			public void run() {
				l.setY(l.getY() + 0.1);
				a1.teleport(l);
				if(count == 10) {
					a1.remove();
					showDmg.get(damager.getName()).cancel();
					showDmg.remove(damager.getName());
				}
				count ++;
			}
			
		});
		showDmg.get(damager.getName()).runTaskTimer(pl, 5L, 5L);
	}
	
}
