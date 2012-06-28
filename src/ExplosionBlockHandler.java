

import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ExplosionBlockHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location location, SpoutPlayer player) {
		// Create explosion on block location
		SpoutBlock block = (SpoutBlock)location.getBlock();
		block.getWorld().createExplosion(location, 7.0F);
	}

	public void shutdown() {
	}
}