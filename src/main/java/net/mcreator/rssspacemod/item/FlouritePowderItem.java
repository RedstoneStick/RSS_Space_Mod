
package net.mcreator.rssspacemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.rssspacemod.itemgroup.ItemsCreativeTabItemGroup;
import net.mcreator.rssspacemod.RssSpaceModModElements;

@RssSpaceModModElements.ModElement.Tag
public class FlouritePowderItem extends RssSpaceModModElements.ModElement {
	@ObjectHolder("rss_space_mod:flourite_powder")
	public static final Item block = null;

	public FlouritePowderItem(RssSpaceModModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemsCreativeTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("flourite_powder");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
