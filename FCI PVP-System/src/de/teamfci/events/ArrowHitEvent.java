package de.teamfci.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHitEvent implements Listener {
	
	@EventHandler
	public void hit(ProjectileHitEvent e) {
		Entity ent = e.getEntity();
		if(ent instanceof Arrow) {
			ent.remove();
		}
	}
	
}
