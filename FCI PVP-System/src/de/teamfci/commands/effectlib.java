package de.teamfci.commands;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.slikey.effectlib.effect.AnimatedBallEffect;
import de.slikey.effectlib.effect.ArcEffect;
import de.slikey.effectlib.effect.AtomEffect;
import de.slikey.effectlib.effect.BigBangEffect;
import de.slikey.effectlib.effect.BleedEffect;
import de.slikey.effectlib.effect.CircleEffect;
import de.slikey.effectlib.effect.CloudEffect;
import de.slikey.effectlib.effect.ColoredImageEffect;
import de.slikey.effectlib.effect.ConeEffect;
import de.slikey.effectlib.effect.CubeEffect;
import de.slikey.effectlib.effect.DiscoBallEffect;
import de.slikey.effectlib.effect.DnaEffect;
import de.slikey.effectlib.effect.DonutEffect;
import de.slikey.effectlib.effect.DragonEffect;
import de.slikey.effectlib.effect.EarthEffect;
import de.slikey.effectlib.effect.ExplodeEffect;
import de.slikey.effectlib.effect.FlameEffect;
import de.slikey.effectlib.effect.FountainEffect;
import de.slikey.effectlib.effect.GridEffect;
import de.slikey.effectlib.effect.HeartEffect;
import de.slikey.effectlib.effect.HelixEffect;
import de.slikey.effectlib.effect.HillEffect;
import de.slikey.effectlib.effect.IconEffect;
import de.slikey.effectlib.effect.ImageEffect;
import de.slikey.effectlib.effect.JumpEffect;
import de.slikey.effectlib.effect.LineEffect;
import de.slikey.effectlib.effect.LoveEffect;
import de.slikey.effectlib.effect.MusicEffect;
import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.effect.SkyRocketEffect;
import de.slikey.effectlib.effect.SmokeEffect;
import de.slikey.effectlib.effect.SphereEffect;
import de.slikey.effectlib.effect.StarEffect;
import de.slikey.effectlib.effect.TextEffect;
import de.slikey.effectlib.effect.TornadoEffect;
import de.slikey.effectlib.effect.TraceEffect;
import de.slikey.effectlib.effect.TurnEffect;
import de.slikey.effectlib.effect.VortexEffect;
import de.slikey.effectlib.effect.WarpEffect;
import de.slikey.effectlib.effect.WaveEffect;
import de.slikey.effectlib.util.DynamicLocation;
import de.slikey.effectlib.util.ParticleEffect;
import de.teamfci.fcipvp.FCIPVP;



public class effectlib implements CommandExecutor {
	FCIPVP pl;
	
	public effectlib(FCIPVP pl) {
		this.pl = pl;
	}
	ArrayList<String> list = new ArrayList<String>();
	@SuppressWarnings("static-access")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
	final Player p = (Player) sender;
	
	if(args.length == 0 ) {
		if(p.hasPermission("effect.par")) {
			p.sendMessage("§c/par help");
		}else {
			p.sendMessage("§8§oDu hast leider keine §4§oPermission");
		}
	}
	if(args.length >= 1 ) {
		if(p.hasPermission("effect.par")) {
			if(args[0].equalsIgnoreCase("help")) {
				list.clear();
				list.add("§c/par §f<§7text§4§4, §7§7dna§4§4, §7§7tornado§4§4, §7§7vortex§4§4, §7§7warp§4§4, §7§7ball§4§4, §7§7atom§4§4, §7§7bleed§4§4, §7§7wave§4§4, §7§7circle§4§4, §7§7arc§4§4, §7§7disco§4§4, §7§7love§4§4, §7§7dragon§4§4, §7§7bigbang§4§4, §7§7cloud§4§4, §7§7cube§4§4, §7§7cone§4§4, §7§7helix§4§4, §7§7fontain§4§4, §7§7earth§4§4, §7§7grid§4§4, §7§7flame§4§4, §7§7hill§4§4, §7§7heart§4§4, §7§7explode§4§4, §7§7icon§4§4, §7§7image§4§4, §7§7shield§4§4, §7§7line§4§4, §7§7colorimage§4§4, §7§7jump§4§4, §7§7music§4§4, §7§7skyrocket§4§4, §7§7sphere§4§4, §7§7smoke§4§4, §7§7turn§4§4, §7§7trace§4§4, §7§7star>");
				p.sendMessage(list + "");
			}
			if(args[0].equals("text")) {
				 p.sendMessage("§8§oZauberei!");
				 String msg = "";
				 for(int i = 1; i < args.length; i++){
					 msg = msg + " " + args[i];
				 }
				 TextEffect effect = new TextEffect(pl.em);
				 effect.particle = ParticleEffect.FLAME;
				 effect.text = msg;
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("dna")) {
				 p.sendMessage("§8§oZauberei!");
				 DnaEffect effect = new DnaEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("tornado")) {
				 p.sendMessage("§8§oZauberei!");
				 TornadoEffect effect = new TornadoEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("vortex")) {
				 p.sendMessage("§8§oZauberei!");
				 VortexEffect effect = new VortexEffect(pl.em);
				 effect.particle = ParticleEffect.CRIT_MAGIC;
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("warp")) {
				 p.sendMessage("§8§oZauberei!");
				 WarpEffect effect = new WarpEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("ball")) {
				 p.sendMessage("§8§oZauberei!");
				 AnimatedBallEffect effect = new AnimatedBallEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("atom")) {
				 p.sendMessage("§8§oZauberei!");
				 AtomEffect effect = new AtomEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("bleed")) {
				 p.sendMessage("§8§oZauberei!");
				 BleedEffect effect = new BleedEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("wave")) {
				 p.sendMessage("§8§oZauberei!");
				 WaveEffect effect = new WaveEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("circle")) {
				 p.sendMessage("§8§oZauberei!");
				 CircleEffect effect = new CircleEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("arc")) {
				 p.sendMessage("§8§oZauberei!");
				 ArcEffect effect = new ArcEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("disco")) {
				 p.sendMessage("§8§oZauberei!");
				 DiscoBallEffect effect = new DiscoBallEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("donut")) {
				 p.sendMessage("§8§oZauberei!");
				 DonutEffect effect = new DonutEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("love")) {
				 p.sendMessage("§8§oZauberei!");
				 LoveEffect effect = new LoveEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			
			/*
			 * --------------------------------------------------------------
			 */
			
			if(args[0].equals("dragon")) {
				 p.sendMessage("§8§oZauberei!");
				 DragonEffect effect = new DragonEffect(pl.em);
				 effect.particle = ParticleEffect.ENCHANTMENT_TABLE;
				 effect.speed = 4;
				 effect.autoOrient = true;
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("bigbang")) {
				 p.sendMessage("§8§oZauberei!");
				 BigBangEffect effect = new BigBangEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("cloud")) {
				 p.sendMessage("§8§oZauberei!");
				 CloudEffect effect = new CloudEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("cube")) {
				 p.sendMessage("§8§oZauberei!");
				 CubeEffect effect = new CubeEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("cone")) {
				 p.sendMessage("§8§oZauberei!");
				 ConeEffect effect = new ConeEffect(pl.em);
				 Location l = p.getLocation();
				 l.setPitch(-90);
				 DynamicLocation loc = new DynamicLocation(l);
					effect.setDynamicOrigin(loc);
					effect.particle = ParticleEffect.CRIT_MAGIC;
					effect.start();
			}
			if(args[0].equals("helix")) {
				 p.sendMessage("§8§oZauberei!");
				 HelixEffect effect = new HelixEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("fontain")) {
				 p.sendMessage("§8§oZauberei!");
				 FountainEffect effect = new FountainEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("earth")) {
				 p.sendMessage("§8§oZauberei!");
				 EarthEffect effect = new EarthEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("grid")) {
				 p.sendMessage("§8§oZauberei!");
				 GridEffect effect = new GridEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			
			if(args[0].equals("flame")) {
				 p.sendMessage("§8§oZauberei!");
				 FlameEffect effect = new FlameEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("hill")) {
				 p.sendMessage("§8§oZauberei!");
				 HillEffect effect = new HillEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("heart")) {
				 p.sendMessage("§8§oZauberei!");
				 HeartEffect effect = new HeartEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("explode")) {
				 p.sendMessage("§8§oZauberei!");
				 ExplodeEffect effect = new ExplodeEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			
			/*
			 * -------------------------------------------------------------
			 */
			
			if(args[0].equals("icon")) {
			    p.sendMessage("§8§oZauberei!");
				IconEffect effect = new IconEffect(pl.em);
				DynamicLocation loc = new DynamicLocation(p.getLocation());
				effect.setDynamicOrigin(loc);
				effect.start();
			}
			if(args[0].equals("image")) {
				 p.sendMessage("§8§oZauberei!");
				 ImageEffect effect = null;
				try {
					effect = new ImageEffect(pl.em);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DynamicLocation loc = new DynamicLocation(p.getLocation());
				effect.setDynamicOrigin(loc);
				effect.start();
			}
			if(args[0].equals("shield")) {
				 p.sendMessage("§8§oZauberei!");
				 ShieldEffect effect = new ShieldEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("line")) {
				 p.sendMessage("§8§oZauberei!");
				 LineEffect effect = new LineEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("colorimage")) {
				 p.sendMessage("§8§oZauberei!");
				 ColoredImageEffect effect = null;
				try {
					effect = new ColoredImageEffect(pl.em);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("jump")) {
				 p.sendMessage("§8§oZauberei!");
				 JumpEffect effect = new JumpEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("music")) {
				 p.sendMessage("§8§oZauberei!");
				 MusicEffect effect = new MusicEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("skyrocket")) {
				 p.sendMessage("§8§oZauberei!");
				 SkyRocketEffect effect = new SkyRocketEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("sphere")) {
				 p.sendMessage("§8§oZauberei!");
				 SphereEffect effect = new SphereEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("smoke")) {
				 p.sendMessage("§8§oZauberei!");
				 SmokeEffect effect = new SmokeEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("turn")) {
				 p.sendMessage("§8§oZauberei!");
				 TurnEffect effect = new TurnEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("trace")) {
				 p.sendMessage("§8§oZauberei!");
				 TraceEffect effect = new TraceEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			if(args[0].equals("star")) {
				 p.sendMessage("§8§oZauberei!");
				 StarEffect effect = new StarEffect(pl.em);
				 DynamicLocation loc = new DynamicLocation(p.getLocation());
					effect.setDynamicOrigin(loc);
					effect.start();
			}
			
		}else {
			p.sendMessage("§8§oDu hast leider keine §4§oPermission");
		}
	}
		
		
		
	return false;	
	}
	
}
