
package net.mcreator.rssspacemod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.rssspacemod.item.CockpitBlueprintItem;
import net.mcreator.rssspacemod.RssSpaceModModElements;

@RssSpaceModModElements.ModElement.Tag
public class ItemsCreativeTabItemGroup extends RssSpaceModModElements.ModElement {
	public ItemsCreativeTabItemGroup(RssSpaceModModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabitems_creative_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CockpitBlueprintItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
