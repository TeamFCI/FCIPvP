package de.happyhappyboy.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.happyhappyboy.commands.CommandFcipvp;
import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;

public class FCIPvP extends JavaPlugin {
	public static EffectManager em;
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		em = new EffectManager(EffectLib.instance());
		this.getCommand("fcipvp").setExecutor(new CommandFcipvp());
	}
	
}
