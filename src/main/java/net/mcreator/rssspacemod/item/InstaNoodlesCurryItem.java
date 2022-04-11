
package net.mcreator.rssspacemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.rssspacemod.itemgroup.ItemsCreativeTabItemGroup;
import net.mcreator.rssspacemod.RssSpaceModModElements;

import java.util.List;

@RssSpaceModModElements.ModElement.Tag
public class InstaNoodlesCurryItem extends RssSpaceModModElements.ModElement {
	@ObjectHolder("rss_space_mod:insta_noodles_curry")
	public static final Item block = null;

	public InstaNoodlesCurryItem(RssSpaceModModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemsCreativeTabItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f)

							.build()));
			setRegistryName("insta_noodles_curry");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Expired a very long time ago"));
		}
	}
}
