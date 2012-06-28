
import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.particle.Particle;
import org.getspout.spoutapi.particle.Particle.ParticleType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PoisonHandler extends GenericHandler {
	
	public void init(Main main) {
  	}

  	public void onActivation(Location location, SpoutPlayer player) {
  		// Add poison effect to player
  		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 100));
  		
  		// Playing green drip particles on player location
  		Location loc = player.getLocation();
  		Particle poisonParticle = new Particle(ParticleType.DRIPWATER, loc, new Vector(0.5D, 3.0D, 0.5D));
  		poisonParticle.setParticleBlue(0.0F).setParticleGreen(1.0F).setParticleRed(0.0F);
  		poisonParticle.setMaxAge(40).setAmount(15).setGravity(0.9F);
  		poisonParticle.spawn();
  	}

  	public void shutdown() {
  	}
}