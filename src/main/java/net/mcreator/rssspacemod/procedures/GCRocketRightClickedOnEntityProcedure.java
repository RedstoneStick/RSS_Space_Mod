package net.mcreator.rssspacemod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ActionResultType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.Map;

public class GCRocketRightClickedOnEntityProcedure {

	public static ActionResultType executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure GCRocketRightClickedOnEntity!");
			return ActionResultType.PASS;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
			((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("The Universe is not yet ready to show you its secrets"),
					(false));
		}
		return ActionResultType.SUCCESS;
	}
}
