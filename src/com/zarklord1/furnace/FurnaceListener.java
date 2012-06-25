package com.zarklord1.furnace;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.MaterialData;

public class FurnaceListener implements Listener {
	public static FurnaceApi plugin;
	
	public FurnaceListener(FurnaceApi instance) {
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerSmelt(FurnaceSmeltEvent event) {
		ItemStack source = event.getSource();
		ItemStack result = event.getResult();
		if (source.getTypeId() == 318) {
			if (FurnaceRecipes.spoutreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.spoutreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 351) {
			if (FurnaceRecipes.dyereciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.dyereciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 35) {
			if (FurnaceRecipes.woolreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.woolreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 17) {
			if (FurnaceRecipes.woodreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.woodreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 5) {
			if (FurnaceRecipes.planksreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.planksreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 18) {
			if (FurnaceRecipes.leavesreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.leavesreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 6) {
			if (FurnaceRecipes.sapplingreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.sapplingreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 263) {
			if (FurnaceRecipes.coalreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.coalreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 44) {
			if (FurnaceRecipes.slabreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.spoutreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 98) {
			if (FurnaceRecipes.stonebrickreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.stonebrickreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		} else if (source.getTypeId() == 383) {
			if (FurnaceRecipes.spawneggreciperesult.containsKey(source.getDurability())) {
				ItemStack r = FurnaceRecipes.spawneggreciperesult.get(source.getDurability());
				event.setResult(r);
				return;
			}
		}
		if (source.getTypeId() == 318) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 351) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 35) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 17) {
			event.setResult(new SpoutItemStack(MaterialData.charcoal));
			return;
		} else if (source.getTypeId() == 5) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 18) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 6) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 263) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 44) {
			if (source.getDurability() != 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 98) {
			if (source.getDurability() == 0) {
				event.setCancelled(true);
				return;
			} else {
				return;
			}
		} else if (source.getTypeId() == 383) {
			event.setCancelled(true);
			return;
		}
		List<Recipe> list = Bukkit.getRecipesFor(result);
		Object[] recipelist = list.toArray();
		for (int i = 0; i < recipelist.length; i++) {
			if (recipelist[i] instanceof FurnaceRecipe) {
				return;
			}
		}
		event.setCancelled(true);
	}
}
