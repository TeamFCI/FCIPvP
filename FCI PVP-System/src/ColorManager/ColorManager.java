package ColorManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.teamfci.fcipvp.FCIPVP;

public class ColorManager {
	public static FCIPVP pl;
	public ColorManager(FCIPVP pl) {
		this.pl = pl;
	}
	/*
	 * CoreState-Editor
	 */
	public static HashMap<Player, Double> editor = new HashMap<Player, Double>();
//	public static ArrayList<String> editorList = new ArrayList<String>();
	/*
	 * Current Color Level
	 */
	double color = 0.0;
	public void setNextHigherColorLevel() {
		
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
	
}
