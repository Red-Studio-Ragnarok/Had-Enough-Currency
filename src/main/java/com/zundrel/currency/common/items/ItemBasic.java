package com.zundrel.currency.common.items;

import com.zundrel.currency.Currency;
import com.zundrel.currency.common.info.ModInfo;
import net.minecraft.item.Item;

import static net.minecraft.creativetab.CreativeTabs.MISC;

public class ItemBasic extends Item {
	public ItemBasic(String unlocalizedName, int maxStackSize) {
		super();
		setRegistryName(unlocalizedName);
		setCreativeTab(MISC);
		setTranslationKey(this.getRegistryName().toString().replace(ModInfo.MODID + ":", ""));
		setMaxStackSize(maxStackSize);
	}

	public void registerItemModel(Item i) {
		Currency.proxy.registerItemRenderer(i, 0, this.getTranslationKey().substring(5));
	}
}