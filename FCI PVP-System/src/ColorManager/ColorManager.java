package ColorManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.teamfci.fcipvp.FCIPVP;

public class ColorManager {
	public static FCIPVP pl;
	public ColorManager(FCIPVP pl) {
		this.pl = pl;
	}
	static /*
	 * Is one Player in EnerbyCore Field
	 */
	boolean inField = false;
	static Player inFieldPlayer = null;
	/*
	 * ColorManager-Timer
	 */
	static ArrayList<String> infieldplayers = new ArrayList<String>();
	static HashMap<String, BukkitRunnable> chooser = new HashMap<String, BukkitRunnable>();
	public static boolean enable = false;
	/*
	 * CoreState-Editor
	 */
	public static HashMap<Player, Double> editor = new HashMap<Player, Double>();
//	public static ArrayList<String> editorList = new ArrayList<String>();
	/*
	 * Current Color Level
	 */
	double color = 0.0;
	public static void setColorLevel(double coreState) {
		if(inField == true) {
			File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+"%.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			int b = cfg.getInt("EnergyCore.ColorManager.TotalAmount");
			for(int i = 0; i < b; i++) {
				double x = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.X");
				double y = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Y");
				double z = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Z");
				float yaw = (float) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Yaw");
				float pitch = (float) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Pitch");
				String w = cfg.getString("EnergyCore.ColorManager.Wool."+i+".Location.World");
				World world = (World) Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z, yaw, pitch);
				loc.getBlock().setType(Material.LAPIS_BLOCK);
				Bukkit.broadcastMessage("block 1.0% Amount "+i);
			}
		}
	}
	
	public static void setTeamBlock(Location loc, Player p, double coreState) {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+"%.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int b = cfg.getInt("EnergyCore.ColorManager.TotalAmount");
		b = b + 1;
		cfg.set("EnergyCore.ColorManager.TotalAmount", b);
		cfg.set("EnergyCore.ColorManager.Wool."+b+".Location.X", loc.getX());
		cfg.set("EnergyCore.ColorManager.Wool."+b+".Location.Y", loc.getY());
		cfg.set("EnergyCore.ColorManager.Wool."+b+".Location.Z", loc.getZ());
		cfg.set("EnergyCore.ColorManager.Wool."+b+".Location.Yaw", loc.getYaw());
		cfg.set("EnergyCore.ColorManager.Wool."+b+".Location.Pitch", loc.getPitch());
		cfg.set("EnergyCore.ColorManager.Wool."+b+".Location.World", loc.getWorld().getName());
		try {
			cfg.save(file);
		} catch (IOException e) {
			p.sendMessage("¤cFehler beim Absepichern der Datei!");
			p.sendMessage("¤cplugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+"%.yml");
			e.printStackTrace();
		}
//		if (!file.exists()) {
//			Bukkit.broadcastMessage("¤cDatei: "+coreState+".yml");
//			Bukkit.broadcastMessage("¤cPath: ¤7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+".yml");
//			Bukkit.broadcastMessage("¤ckonnte nicht gefunden werden!");
//		}
		p.sendMessage("¤aColorManager-Marker fŸr CoreSate.'¤f"+coreState+"%¤a' wurde gesetzt!");
	}
	
	public static void enableColorChanging() {
		chooser.put("ColorChooser", new BukkitRunnable() {
			@Override
			public void run() {
				if(enable == true) {
					Bukkit.broadcastMessage("1");
					if(inFieldPlayer != null) {
						if(inFieldPlayer.hasPermission("fci.pvp.infield")) {
							Bukkit.broadcastMessage("1.1");
							inFieldPlayer.sendMessage("inField = true | Player inField = " + inFieldPlayer.getName());
							setColorLevel(1.0);
						}
					}
				}
			}
			
		});
		chooser.get("ColorChooser").runTaskTimer(pl, 20L, 20L);
	}
	
}
