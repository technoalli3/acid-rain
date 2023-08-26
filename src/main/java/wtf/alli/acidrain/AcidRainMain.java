package wtf.alli.acidrain;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.config.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import wtf.alli.acidrain.enchantment.AcidProtection;
import wtf.alli.acidrain.items.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

import java.util.*;

public class AcidRainMain implements ModInitializer {
    public static final String MOD_ID = "acidrain";
    public static Enchantment ACID_PROTECTION = Registry.register(
            Registries.ENCHANTMENT,
            new Identifier("acidrain", "acid_protection"),
            new AcidProtection(
                    Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR_CHEST,
                    new EquipmentSlot[] {EquipmentSlot.CHEST})
    );
    public static final AcidRainConfig CONFIG = QuiltConfig.create("acidrain", "config", AcidRainConfig.class);

    public static boolean getSkyColourEnabled() {
        return CONFIG.main.skyColourEnabled;
    }
    public static int getSkyColour() {
        return CONFIG.main.skyColour;
    }

    public static boolean getWaterColourEnabled() {
        return CONFIG.main.waterColourEnabled;
    }
    public static int getWaterColour() {
        return CONFIG.main.waterColour;
    }

    public static boolean getSkyFogEnabled() {
        return CONFIG.main.skyFogEnabled;
    }
    public static int getSkyFogColour() {
        return CONFIG.main.skyFogColour;
    }

    public static boolean getWaterFogEnabled() {
        return CONFIG.main.waterFogEnabled;
    }
    public static int getWaterFogColour() {
        return CONFIG.main.waterFogColour;
    }

    public static boolean getFoliageEnabled() {
        return CONFIG.main.foliageEnabled;
    }
    public static int getFoliageColour() {
        return CONFIG.main.foliageColour;
    }

    public static boolean getGrassEnabled() {
        return CONFIG.main.grassEnabled;
    }
    public static int getGrassColour() {
        return CONFIG.main.grassColour;
    }

    @Override
    public void onInitialize(ModContainer mod) {
        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) -> {
            if (Registries.ITEM_GROUP.getKey(group).get() == ItemGroups.FOOD_AND_DRINKS) {
                entries.addStack(ModItems.COOKED_NIGHTMARE_FISH.getDefaultStack());
                entries.addStack(ModItems.RAW_NIGHTMARE_FISH.getDefaultStack());
            }
        });
        ModItems.registerItems();
    }
}
