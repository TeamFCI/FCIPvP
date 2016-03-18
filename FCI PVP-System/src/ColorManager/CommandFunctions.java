package ColorManager;

import org.bukkit.entity.Player;

public class CommandFunctions {
	public void exitEditor(Player p) {
		if(ColorManager.editor.containsKey(p)) {
			ColorManager.editor.remove(p);
			p.sendMessage("§aEditormodus verlassen!");
		} else {
			p.sendMessage("§aDu bist nicht im Editormodus!");
			p.sendMessage("§a/fcipvp colormanager editor (0.0->100.0)|exit");
		}
	}
	
	public void joinEditor(Player p, double coreState) {
		if(ColorManager.editor.containsKey(p)) {
			p.sendMessage("§aDu bist bereits im Editormodus!");
			coreState = ColorManager.editor.get(p);
			p.sendMessage("§aDein CoreState: §e"+coreState);
		} else {
			ColorManager.editor.put(p, coreState);
			p.sendMessage("§aEditormodus betreten!");
			coreState = ColorManager.editor.get(p);
			p.sendMessage("§aDein CoreState: §e"+coreState);
		}
	}
	
}
