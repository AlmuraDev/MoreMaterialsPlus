
import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.player.SpoutPlayer;

public class FireBallItemHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location location, SpoutPlayer player) {
		Vector direction = player.getEyeLocation().getDirection().multiply(2);
		Fireball fireball = (Fireball)player.getWorld().spawn(player.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Fireball.class);
		fireball.setShooter(player);
		fireball.setVelocity(direction.multiply(0.25D));
		fireball.setYield(7.0F);
		fireball.setIsIncendiary(false);
	}
	
	public void shutdown() {
	}
}