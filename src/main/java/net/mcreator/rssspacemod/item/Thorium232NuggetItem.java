
package net.mcreator.rssspacemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.rssspacemod.itemgroup.ItemsCreativeTabItemGroup;
import net.mcreator.rssspacemod.RssSpaceModModElements;

import java.util.List;

@RssSpaceModModElements.ModElement.Tag
public class Thorium232NuggetItem extends RssSpaceModModElements.ModElement {
	@ObjectHolder("rss_space_mod:thorium_232_nugget")
	public static final Item block = null;

	public Thorium232NuggetItem(RssSpaceModModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemsCreativeTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("thorium_232_nugget");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A7a[Radioactive]"));
			list.add(new StringTextComponent("\u00A7e0,01RAD/s"));
		}
	}
}
