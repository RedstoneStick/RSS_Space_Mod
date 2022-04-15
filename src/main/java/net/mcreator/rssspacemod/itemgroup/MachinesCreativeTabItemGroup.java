
package net.mcreator.rssspacemod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.rssspacemod.block.RedstoneGeneratorOnBlock;
import net.mcreator.rssspacemod.RssSpaceModModElements;

@RssSpaceModModElements.ModElement.Tag
public class MachinesCreativeTabItemGroup extends RssSpaceModModElements.ModElement {
	public MachinesCreativeTabItemGroup(RssSpaceModModElements instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmachines_creative_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RedstoneGeneratorOnBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
