package de.happyhappyboy.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.happyhappyboy.commands.CommandFcipvp;
import de.happyhappyboy.commands.effectlib;
import de.happyhappyboy.events.ShieldActivateEvent;
import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;



public class FCIPVP extends JavaPlugin {
	
	public static EffectManager em;
	
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ShieldActivateEvent(this), this);
		this.getCommand("fcipvp").setExecutor(new CommandFcipvp());
		this.getCommand("par").setExecutor(new effectlib(this));
		em = new EffectManager(EffectLib.instance());
	}
	
	public static ItemStack getBlutSplitter() {
		ItemStack splitter = new ItemStack(Material.STONE);
		
		
		return splitter;
	}
	
	public static void checkPlayerFiles(Player p) {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"+p.getName());
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()) {
			cfg.set("Player.Name", p.getName());
			cfg.set("Player.Class", "NONE");
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		p.sendMessage("�6Deine Spielerdatei wurde gefunden! �aPositiv");
	}
	public static void checkConfigs() {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"+p.getName());
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()) {
			cfg.set("Player.Name", p.getName());
			cfg.set("Player.Class", "NONE");
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		p.sendMessage("�6Die FCI-PvP Configs wurde gefunden! �aPositiv");
	}
	
}
