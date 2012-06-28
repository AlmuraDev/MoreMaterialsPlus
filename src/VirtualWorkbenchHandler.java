
import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.getspout.spoutapi.player.SpoutPlayer;

public class VirtualWorkbenchHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location location, SpoutPlayer player) {
		// If the player is clicking on a door, return.
		if (location != null) {
			Material mat = location.getBlock().getType();
			if (mat.equals(Material.WOODEN_DOOR) || mat.equals(Material.IRON_DOOR) || mat.equals(Material.TRAP_DOOR) || mat.equals(Material.WOOD_DOOR) || mat.equals(Material.FENCE_GATE) || mat.equals(Material.IRON_DOOR_BLOCK)) return;
		}
		
		// Open the crafting table.
		player.openWorkbench(null, true);
	}

	public void shutdown() {
	}
}