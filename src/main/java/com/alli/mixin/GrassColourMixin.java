package com.alli.mixin;

import net.minecraft.world.biome.BiomeEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BiomeEffects.Builder.class)
public abstract class GrassColourMixin {
    @Shadow private BiomeEffects.GrassColorModifier grassColorModifier;

    @Inject(method = "grassColorModifier",at=@At("HEAD"), cancellable = true)
    private void changeGrassColours(BiomeEffects.GrassColorModifier grassColorModifier, CallbackInfoReturnable<BiomeEffects.Builder> cir) {
        this.grassColorModifier = BiomeEffects.GrassColorModifier.NONE;
        cir.setReturnValue(((BiomeEffects.Builder)(Object)this));
    }
}
