package ColorManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.teamfci.fcipvp.FCIPVP;

public class ColorManager {
	public static FCIPVP pl;
	@SuppressWarnings("static-access")
	public ColorManager(FCIPVP pl) {
		this.pl = pl;
	}
	public static ArrayList<Double> usedCoreState = new ArrayList<Double>();
    /*
	 * Is one Player in EnerbyCore Field
	 */
	static boolean inField = false;
	static Player inFieldPlayer = null;
	/*
	 * Custom Blocks
	 */
	public static HashMap<String, Integer> customBlocks = new HashMap<String, Integer>();
	public static boolean toogleCustomBlock = false;
	/*
	 * ColorManager-Timer
	 */
	static ArrayList<String> infieldplayers = new ArrayList<String>();
	public static HashMap<String, BukkitRunnable> chooser = new HashMap<String, BukkitRunnable>();
	public static boolean enable = false;
	/*
	 * CoreState-Editor
	 */
	public static HashMap<Player, Double> editor = new HashMap<Player, Double>();
	/*
	 * CoreState-Editor
	 */
	public static double d = 0.0;
	/*
	 * Current Color Level
	 */
	double color = 0.0;
	@SuppressWarnings("deprecation")
	public static void setColorLevel(double coreState) {
		if(inField == true) {
			if(coreState == 333.3) {
				for(int a = 0; a < 10000; a++) {
					double v = d + 0.01; 
					v = Math.round(100.0 * v) / 100.0;
					d = v;
					File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+d+"%.yml");
					if(!usedCoreState.contains(d) && file.exists()) {
						usedCoreState.add(d);
						setWool(d);
						break;
					}
					if(d == 100.0) {
						Bukkit.broadcastMessage("100%");
						enable = false;
						d = 0.0;
					}
				}
			} else {
				File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+"%.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				int b = cfg.getInt("EnergyCore.ColorManager.TotalAmount");
				for(int i = 1; i < b+1; i++) {
					double x = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.X");
					double y = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Y");
					double z = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Z");
					String w = cfg.getString("EnergyCore.ColorManager.Wool."+i+".Location.World");
					Bukkit.broadcastMessage("TeamBlock Current ID: " + i);
					Bukkit.broadcastMessage("a x:"+x+" y:"+y+" z:"+z+" world:"+w);
					World world = Bukkit.getWorld(w);
					Bukkit.broadcastMessage("b");
					Location loc = new Location(world, x, y, z);
					Bukkit.broadcastMessage("c");
					loc.getBlock().setType(Material.LAPIS_BLOCK);
					Bukkit.broadcastMessage("block 1.0% Amount "+i);
				}
			}
		}
	}
	
	public static void setWool(double d) {
		Bukkit.broadcastMessage("§aEnergyCre State:§e "+d+"%");
		File f = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+d+"%.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		int b = cfg.getInt("EnergyCore.ColorManager.TotalAmount");
		for(int i = 1; i < b+1; i++) {
			double x = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.X");
			double y = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Y");
			double z = (double) cfg.getInt("EnergyCore.ColorManager.Wool."+i+".Location.Z");
			String w = cfg.getString("EnergyCore.ColorManager.Wool."+i+".Location.World");
			World world = Bukkit.getWorld(w);
			Location loc = new Location(world, x, y, z);
			String blockID = cfg.getString("EnergyCore.ColorManager.Wool."+i+".CustomBlock");
			String[] array = blockID.split(":");
			int id = Integer.valueOf(array[0]);
			int subid = Integer.valueOf(array[1]);
			loc.getBlock().setTypeId(id);
			loc.getBlock().setData((byte) subid);
		}
	}
	
	public static void setTeamBlock(Location loc, Player p, double coreState) {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+"%.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int b = cfg.getInt("EnergyCore.ColorManager.TotalAmount");
		b = b + 1;
		String n = b+"";
		cfg.set("EnergyCore.ColorManager.TotalAmount", b);
		cfg.set("EnergyCore.ColorManager.Wool."+n+".Location.X", loc.getX());
		cfg.set("EnergyCore.ColorManager.Wool."+n+".Location.Y", loc.getY());
		cfg.set("EnergyCore.ColorManager.Wool."+n+".Location.Z", loc.getZ());
		cfg.set("EnergyCore.ColorManager.Wool."+n+".Location.World", loc.getWorld().getName().toString());
		int id = customBlocks.get(p.getName()+":ID");
		int subid = customBlocks.get(p.getName()+":SubID");
		String s = id+":"+subid;
		cfg.set("EnergyCore.ColorManager.Wool."+n+".CustomBlock", s);
		try {
			cfg.save(file);
		} catch (IOException e) {
			p.sendMessage("§cFehler beim Absepichern der Datei!");
			p.sendMessage("§cplugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+"%.yml");
			e.printStackTrace();
		}
//		if (!file.exists()) {
//			Bukkit.broadcastMessage("§cDatei: "+coreState+".yml");
//			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//ColorManager//Wool Blocks//FlagState - "+coreState+".yml");
//			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
//		}
		p.sendMessage("§aColorManager-Marker für CoreSate.'§f"+coreState+"%§a' wurde gesetzt!");
	}
	
	public static void enableColorChanging() {
		chooser.put("ColorChooser", new BukkitRunnable() {
			@Override
			public void run() {
				if(enable == true) {
					if(inFieldPlayer != null) {
						if(inFieldPlayer.hasPermission("fci.pvp.infield")) {
							setColorLevel(333.3);
						}
					}
				}
			}
			
		});
		chooser.get("ColorChooser").runTaskTimer(pl, 20L, 20L);
	}
	
}
