
package net.mcreator.rssspacemod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.rssspacemod.item.MoonTeleporterItemItem;
import net.mcreator.rssspacemod.RssSpaceModModElements;

@RssSpaceModModElements.ModElement.Tag
public class ToolsAndArmourCreativeTabItemGroup extends RssSpaceModModElements.ModElement {
	public ToolsAndArmourCreativeTabItemGroup(RssSpaceModModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtools_and_armour_creative_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MoonTeleporterItemItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
