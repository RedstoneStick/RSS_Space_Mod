package net.mcreator.rssspacemod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.Map;

public class YellowcakeFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency entity for procedure YellowcakeFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (0.3 >= Math.random()) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("radiation").setDamageBypassesArmor(), (float) 200);
			}
		} else if (0.5 >= Math.random()) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("bad_decision").setDamageBypassesArmor(), (float) 200);
			}
		} else {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("overeat").setDamageBypassesArmor(), (float) 200);
			}
		}
	}
}
