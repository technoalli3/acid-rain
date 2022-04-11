package com.alli.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.PotionUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(PotionUtil.class)
public class WaterBottleMixin {
    @Inject(method="getColor(Ljava/util/Collection;)I", at=@At("HEAD"), cancellable = true)
    private static void getColor(Collection<StatusEffectInstance> effects, CallbackInfoReturnable<Integer> cir) {
        int i = 2159616;
        if (effects.isEmpty()) {
            cir.setReturnValue(i);
        }
    }
}
