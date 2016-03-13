package de.happyhappyboy.main;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.happyhappyboy.commands.CommandFcipvp;
import de.happyhappyboy.events.ShieldActivateEvent;
import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;



public class FCIPVP extends JavaPlugin {
	
	public static EffectManager em;
	
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ShieldActivateEvent(this), this);
		this.getCommand("fcipvp").setExecutor(new CommandFcipvp());
		em = new EffectManager(EffectLib.instance());
	}
	
	public static ItemStack getBlutSplitter() {
		ItemStack splitter = new ItemStack(Material.STONE);
		
		
		return splitter;
	}
	
}
