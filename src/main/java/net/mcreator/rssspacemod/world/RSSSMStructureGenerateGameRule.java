package net.mcreator.rssspacemod.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.rssspacemod.RssSpaceModModElements;

import java.lang.reflect.Method;

@RssSpaceModModElements.ModElement.Tag
public class RSSSMStructureGenerateGameRule extends RssSpaceModModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("rSSSMStructureGenerate", GameRules.Category.MISC,
			create(true));

	public RSSSMStructureGenerateGameRule(RssSpaceModModElements instance) {
		super(instance, 71);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
