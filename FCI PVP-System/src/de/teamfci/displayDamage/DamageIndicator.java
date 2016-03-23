package de.teamfci.displayDamage;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import de.teamfci.fcipvp.FCIPVP;

public class DamageIndicator {
	public static HashMap<String, BukkitRunnable> showDmg = new HashMap<String, BukkitRunnable>();
	public static FCIPVP pl;
	public DamageIndicator(FCIPVP pl) {
		this.pl = pl;
	}
	
	public static void indicator(final Entity damager, Entity entity, final double damage) {
		final Location loc = entity.getLocation();
		loc.setY(loc.getY() + 0.4);
		Random r = new Random();
		double x = r.nextInt(2);
		double z = r.nextInt(2);
		int b = r.nextInt(4);
		if(b == 0) {
			loc.setX(loc.getX() + x);
			loc.setZ(loc.getZ() + z);
		}
		if(b == 1) {
			loc.setX(loc.getX() - x);
			loc.setZ(loc.getZ() - z);
		}
		if(b == 2) {
			loc.setX(loc.getX() - x);
			loc.setZ(loc.getZ() + z);
		}
		if(b == 3) {
			loc.setX(loc.getX() + x);
			loc.setZ(loc.getZ() - z);
		}
		final ArmorStand armorStand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		armorStand.setGravity(false);
		armorStand.setCustomName("§c-"+(int)damage+"❤");
		armorStand.setCustomNameVisible(true);
		armorStand.setVisible(false);
		showDmg.put(damager.getName(), new BukkitRunnable() {
			@Override
			public void run() {
				armorStand.remove();
				showDmg.remove(damager.getName());
			}
			
		});
		showDmg.get(damager.getName()).runTaskLater(pl, 10L);
	}
	
}
