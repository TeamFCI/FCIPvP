package de.teamfci.events;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.teamfci.displayDamage.DamageIndicator;

public class DamageIndicatorEvent implements Listener {
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		Entity ent = e.getEntity();
		Entity dam = e.getDamager();
		double damage = e.getDamage();
		if(ent instanceof ArmorStand) {
			return;
		}
		DamageIndicator.indicator(dam, ent, damage);
	}
	
}
