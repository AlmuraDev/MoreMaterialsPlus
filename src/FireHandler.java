
import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.getspout.spoutapi.player.SpoutPlayer;

public class FireHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location location, SpoutPlayer player) {
		// Set player on fire
		player.setFireTicks(80);
		
		// Play mobspawner flame effects
		Location loc = player.getLocation();
		player.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0, 2);
	}

	public void shutdown() {
	}
}