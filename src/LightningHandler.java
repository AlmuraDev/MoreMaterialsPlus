
import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.particle.Particle;
import org.getspout.spoutapi.particle.Particle.ParticleType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LightningHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location loc, SpoutPlayer player) {
		// Striking lightning and effect on block location
		player.getWorld().strikeLightning(loc);
		player.getWorld().strikeLightningEffect(loc);
		
		// Spawn a Pig Zombie
		player.getWorld().spawnCreature(loc, EntityType.PIG_ZOMBIE);
		
		// Playing yellow explosion particles on 1 above block location
		Location loc2 = loc;
		loc2.setY(loc2.getY() + 1.0D);
		Particle smokeParticle = new Particle(ParticleType.EXPLODE, loc2, new Vector(0.5D, 3.0D, 0.5D));
		smokeParticle.setParticleBlue(0.0F).setParticleGreen(1.0F).setParticleRed(1.0F);
		smokeParticle.setMaxAge(60).setAmount(15).setGravity(1.1F);
		smokeParticle.spawn();
	}

	public void shutdown() {
	}
}