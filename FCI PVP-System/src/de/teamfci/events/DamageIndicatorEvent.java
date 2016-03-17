package de.teamfci.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.teamfci.displayDamage.DamageIndicator;

public class DamageIndicatorEvent implements Listener {
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		Entity ent = e.getEntity();
		Entity dam = e.getDamager();
		if(ent instanceof Player && dam instanceof Player) {
			Player p2 = (Player) ent;
			Player p1 = (Player) dam;
			double damage = e.getDamage();
			DamageIndicator.indicator(p1, p2, damage);
		}
		
	}
	
}
