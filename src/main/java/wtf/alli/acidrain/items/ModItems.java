package wtf.alli.acidrain.items;

import net.minecraft.registry.Registries;
import wtf.alli.acidrain.AcidRainMain;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static wtf.alli.acidrain.items.AcidRainFoodComponents.RAW_NIGHTMARE_FISH_FOOD;
import static wtf.alli.acidrain.items.AcidRainFoodComponents.COOKED_NIGHTMARE_FISH_FOOD;

public class ModItems {
    public static final Item RAW_NIGHTMARE_FISH = new Item(new QuiltItemSettings().food(RAW_NIGHTMARE_FISH_FOOD));
    public static final Item COOKED_NIGHTMARE_FISH = new Item(new QuiltItemSettings().food(COOKED_NIGHTMARE_FISH_FOOD));

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(AcidRainMain.MOD_ID, "raw_nightmare_fish"), RAW_NIGHTMARE_FISH);
        Registry.register(Registries.ITEM, new Identifier(AcidRainMain.MOD_ID, "cooked_nightmare_fish"), COOKED_NIGHTMARE_FISH);
    }
}
