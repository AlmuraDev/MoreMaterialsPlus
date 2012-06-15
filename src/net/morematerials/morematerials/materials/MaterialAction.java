/*
 The MIT License

 Copyright (c) 2012 Zloteanu Nichita (ZNickq) and Andre Mohren (IceReaper)

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */

package net.morematerials.morematerials.materials;

import java.util.logging.Level;
import net.morematerials.morematerials.manager.MainManager;
import net.morematerials.morematerials.smp.SmpPackage;
import org.bukkit.configuration.ConfigurationSection;
import org.getspout.spoutapi.material.Material;
import org.getspout.spoutapi.material.MaterialData;

public class MaterialAction {

	private SmpPackage smpPackage = null;
	private String sound = null;
	private String action = null;
	private Boolean consume = false;
	private Integer health = 0;
	private Integer hunger = 0;
	private Integer air = 0;
	private Integer experience = 0;
	private String returnedItem = null;
	private String permissionsBypass;

	public MaterialAction(ConfigurationSection config, SmpPackage smpPackage) {
		this.smpPackage = smpPackage;

		String lsound = config.getString("Sound", "");
		String laction = config.getString("Command", "");
		Boolean lconsume = config.getBoolean("Consume", false);
		Integer lhealth = config.getInt("Health", 0);
		Integer lhunger = config.getInt("Hunger", 0);
		Integer lair = config.getInt("Air", 0);
		Integer lexperience = config.getInt("Experience", 0);
		String lreturnedItem = config.getString("Give", "");
		String permBypass = config.getString("PermissionsBypass","");

		this.consume = lconsume;
		
		if (!lsound.equals("")) {
			try {
				this.sound = smpPackage.cacheFile(lsound);
			} catch (Exception e) {
				MainManager.getUtils().log("Couldn't load sound " + lsound + ".png from " + smpPackage.name + ".", Level.WARNING);
			}
		}

		if (!laction.equals("")) {
			this.action = laction;
		}
		
		if (lhealth != 0) {
			this.health = lhealth;
		}
		
		if (lhunger != 0) {
			this.hunger = lhunger;
		}
		
		if (lair != 0) {
			this.air = lair;
		}
		
		if (lexperience != 0) {
			this.experience = lexperience;
		}
		
		if (!lreturnedItem.equals("")) {
			this.returnedItem = lreturnedItem;
		}
		
		if(!permBypass.equals("")) {
			this.permissionsBypass = permBypass;
		}
	}

	public String getSound() {
		return this.sound;
	}

	public String getAction() {
		return this.action;
	}

	public Boolean getConsume() {
		return this.consume;
	}

	public Integer getHealth() {
		return this.health;
	}

	public Integer getHunger() {
		return this.hunger;
	}

	public Integer getAir() {
		return this.air;
	}

	public Integer getExperience() {
		return this.experience;
	}
	
	public String getPermissionsBypass() {
		return this.permissionsBypass;
	}

	public Material getReturnedItem() {
		if (this.returnedItem == null) {
			return null;
		} else if (this.returnedItem.matches("^[0-9]+$")) {
			return MaterialData.getMaterial(Integer.parseInt(this.returnedItem));
		} else {
			return (Material) this.smpPackage.getMaterial(this.returnedItem);
		}
	}
}
