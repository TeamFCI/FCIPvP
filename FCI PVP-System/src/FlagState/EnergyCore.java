package FlagState;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class EnergyCore {
	/*
	 * Team own piece of FlagState
	 */
	static double ownPartOfTeamBlue = 0.0;
	static double ownPartOfTeamRed = 0.0;
	static double ownPartOfTeamGreen = 0.0;
	/*
	 * FlagState (Numeric)
	 */
	static double coreState = 0.0;
	
	public static void setFlagState() {
		String state = "100";
	}
	public static int getFlagStateINTEGER() {
		int state = 100;
		return state;
	}
	public static String getFlagStateSTRING() {
		String state = "100";
		return state;
	}
	
	public static void checkEnergyCoreConfig() {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//EnergyCore//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(file.exists()) {
			ownPartOfTeamBlue = (double) cfg.getInt("ColorManager.ownPartOfTeamBlue");
			ownPartOfTeamRed = (double) cfg.getInt("ColorManager.ownPartOfTeamRed");
			ownPartOfTeamGreen = (double) cfg.getInt("ColorManager.ownPartOfTeamGreen");
			coreState = (double) cfg.getInt("EnergyCore.coreState");
		} else {
			double n = 0.0;
			cfg.set("ColorManager.ownPartOfTeamBlue", n);
			cfg.set("ColorManager.ownPartOfTeamRed", n);
			cfg.set("ColorManager.ownPartOfTeamGreen", n);
			cfg.set("EnergyCore.coreState", n);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//ColorManager//config.yml");
		cfg = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()) {
			cfg.set("ColorManager.Blue.TeamBlock", "Block.WOOL");
			cfg.set("ColorManager.Blue.TeamBlock", "Block.WOOL");
			cfg.set("ColorManager.Blue.TeamBlock", "Block.WOOL");
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
