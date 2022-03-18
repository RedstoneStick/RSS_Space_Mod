
package net.mcreator.rsstechmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.rsstechmod.block.UraniumOreBlock;
import net.mcreator.rsstechmod.RssTechModModElements;

@RssTechModModElements.ModElement.Tag
public class OresCreativeTabItemGroup extends RssTechModModElements.ModElement {
	public OresCreativeTabItemGroup(RssTechModModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabores_creative_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(UraniumOreBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
