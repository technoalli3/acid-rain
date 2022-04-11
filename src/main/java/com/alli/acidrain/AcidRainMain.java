package com.alli.acidrain;

import com.alli.acidrain.enchantment.AcidProtection;
import com.alli.acidrain.items.ModItems;
import draylar.omegaconfig.OmegaConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.*;

public class AcidRainMain implements ModInitializer {
    public static final String MOD_ID = "acidrain";
    public static Enchantment ACID_PROTECTION = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("acidrain", "acid_protection"),
            new AcidProtection(
                    Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR_CHEST,
                    new EquipmentSlot[] {EquipmentSlot.CHEST})
    );
    public static final AcidRainConfig CONFIG = OmegaConfig.register(AcidRainConfig.class);

    public static boolean getSkyColourEnabled() {
        return CONFIG.skyColourEnabled;
    }
    public static int getSkyColour() {
        return CONFIG.skyColour;
    }

    public static boolean getWaterColourEnabled() {
        return CONFIG.waterColourEnabled;
    }
    public static int getWaterColour() {
        return CONFIG.waterColour;
    }

    public static boolean getSkyFogEnabled() {
        return CONFIG.skyFogEnabled;
    }
    public static int getSkyFogColour() {
        return CONFIG.skyFogColour;
    }

    public static boolean getWaterFogEnabled() {
        return CONFIG.waterFogEnabled;
    }
    public static int getWaterFogColour() {
        return CONFIG.waterFogColour;
    }

    public static boolean getFoliageEnabled() {
        return CONFIG.foliageEnabled;
    }
    public static int getFoliageColour() {
        return CONFIG.foliageColour;
    }

    public static boolean getGrassEnabled() {
        return CONFIG.grassEnabled;
    }
    public static int getGrassColour() {
        return CONFIG.grassColour;
    }

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
