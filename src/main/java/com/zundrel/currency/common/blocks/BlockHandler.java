package com.zundrel.currency.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import com.zundrel.currency.Currency;
import com.zundrel.currency.common.info.ModInfo;
import com.zundrel.currency.common.items.ItemHandler;

import static net.minecraft.creativetab.CreativeTabs.MISC;

@EventBusSubscriber(modid = ModInfo.MODID)
public class BlockHandler {
	public static IForgeRegistry<Block> registry;

	public static Block atm;
	public static Block shopController;
	public static Block storageCrate;
	public static Block shelf;
	public static Block table;

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		registry = event.getRegistry();

		atm = register(new BlockATM("atm", Material.ROCK, 1.5F, SoundType.STONE, MISC));
		shopController = register(new BlockShopController("shop_controller", Material.ROCK, 1.5F, SoundType.STONE, MISC));
		storageCrate = register(new BlockStockCrate("stock_crate", Material.ROCK, 1.5F, SoundType.STONE, MISC));
		shelf = register(new BlockShelf("shelf", Material.WOOD, 0.5F, SoundType.WOOD, MISC));
		table = register(new BlockTable("table", Material.WOOD, 0.5F, SoundType.WOOD, MISC));
	}

	public static <T extends Block> T register(T b, ItemBlock ib) {
		registry.register(b);
		ib.setRegistryName(b.getRegistryName());
		ItemHandler.itemBlocks.add(ib);
		return b;
	}

	public static <T extends Block> T register(T b) {
		ItemBlock ib = new ItemBlock(b);
		return register(b, ib);
	}
}
