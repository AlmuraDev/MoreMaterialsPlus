import net.morematerials.Main;
import net.morematerials.handlers.GenericHandler;
import net.morematerials.manager.MainManager;
import net.morematerials.materials.SMCustomBlock;
import net.morematerials.smp.SmpPackage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

///////////////////////////////////////////////FAIL\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
public class BambooBlockHandler extends GenericHandler {
	
	public void init(Main main) {
  	}

	@SuppressWarnings("null")
	public void onActivation(Location loc, SpoutPlayer player) {
  		if (loc == null) return;
  		SpoutBlock b = (SpoutBlock) loc.getBlock();
  		ItemStack i = player.getItemInHand();
  		if (!(b instanceof CustomBlock)) return;
  		CustomBlock b2 = b.getCustomBlock();
  		Object item = MainManager.getSmpManager().getMaterial(new SpoutItemStack(b2, 1));
		if (item == null) return;
		if (!(item instanceof SMCustomBlock)) return;
		SmpPackage smp = null;
		org.getspout.spoutapi.material.Material mat = smp.getMaterial("block1");
		org.getspout.spoutapi.material.Material mat2 = smp.getMaterial("block2");
		org.getspout.spoutapi.material.Material mat3 = smp.getMaterial("block3");
		org.getspout.spoutapi.material.Material mat4 = smp.getMaterial("block4");
		if (player.isSneaking()) {
			if (i == null || i.equals(Material.SUGAR_CANE)) {
				if (item == mat2) b.setCustomBlock((CustomBlock) mat);
				else if (item == mat3) b.setCustomBlock((CustomBlock) mat2);
				else if (item == mat4) b.setCustomBlock((CustomBlock) mat3);
				else return;
				if (i == null) player.setItemInHand(new ItemStack(Material.SUGAR_CANE, 1));
				else player.getItemInHand().setAmount(i.getAmount() + 1);
			}
		} else {
			if (i != null || i.equals(Material.SUGAR_CANE)) {
				if (item == mat) b.setCustomBlock((CustomBlock) mat2);
				else if (item == mat2) b.setCustomBlock((CustomBlock) mat3);
				else if (item == mat3) b.setCustomBlock((CustomBlock) mat4);
				else return;
				if (i.getAmount() == 1) player.setItemInHand(null);
				else player.getItemInHand().setAmount(i.getAmount() - 1);
			}
		}
  	}

  	public void shutdown() {
  	}
}