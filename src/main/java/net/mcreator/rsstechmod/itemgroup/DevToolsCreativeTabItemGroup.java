
package net.mcreator.rsstechmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.rsstechmod.item.MoonTeleporterItemItem;
import net.mcreator.rsstechmod.RssTechModModElements;

@RssTechModModElements.ModElement.Tag
public class DevToolsCreativeTabItemGroup extends RssTechModModElements.ModElement {
	public DevToolsCreativeTabItemGroup(RssTechModModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdev_tools_creative_tab") {
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
