package com.alli.acidrain.items;

import com.alli.acidrain.AcidRainMain;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.alli.acidrain.items.AcidRainFoodComponents.RAW_NIGHTMARE_FISH_FOOD;
import static com.alli.acidrain.items.AcidRainFoodComponents.COOKED_NIGHTMARE_FISH_FOOD;

public class ModItems {
    public static final Item RAW_NIGHTMARE_FISH = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(RAW_NIGHTMARE_FISH_FOOD));
    public static final Item COOKED_NIGHTMARE_FISH = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(COOKED_NIGHTMARE_FISH_FOOD));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(AcidRainMain.MOD_ID, "raw_nightmare_fish"), RAW_NIGHTMARE_FISH);
        Registry.register(Registry.ITEM, new Identifier(AcidRainMain.MOD_ID, "cooked_nightmare_fish"), COOKED_NIGHTMARE_FISH);
    }
}
