package wtf.alli.acidrain.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class AcidRainFoodComponents {
    public static final FoodComponent RAW_NIGHTMARE_FISH_FOOD = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400), 1.0F)
            .build();
    public static final FoodComponent COOKED_NIGHTMARE_FISH_FOOD = new FoodComponent.Builder()
            .hunger(9)
            .saturationModifier(4)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400), 1.0F)
            .build();
}