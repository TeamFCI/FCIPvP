package de.happyhappyboy.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.slikey.effectlib.EffectManager;

public class FCIPvP extends JavaPlugin {
	public static EffectManager em;
	public void onEnable() {
		PluginManager Pm = this.getServer().getPluginManager();
		em = new EffectManager(this);
		
		
	}
	
}
