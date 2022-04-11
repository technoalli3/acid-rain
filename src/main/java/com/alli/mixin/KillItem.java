package com.alli.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.entity.EntityType.ITEM;

@Mixin(Entity.class)
public abstract class KillItem {
    @Shadow public abstract void playSound(SoundEvent sound, float volume, float pitch);

    @Inject(method="move", at=@At("TAIL"))
    private void killEntityInAcid(MovementType movementType, Vec3d movement, CallbackInfo ci) {
        Entity entity = ((Entity)(Object)this);
        if (entity.getType()==ITEM) {
            if(entity.isTouchingWaterOrRain()) {
                String key = String.valueOf(entity.getName());
                if(!key.contains("'item.acidrain.raw_nightmare_fish'")){
                    if(!key.contains("boat")) {
                        this.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 1F, 1F);
                        entity.damage(DamageSource.DROWN, Integer.MAX_VALUE);
                    }
                }
            }
            int posX = entity.getBlockX();
            int posY = entity.getBlockY();
            int posZ = entity.getBlockZ();
            BlockPos pos = new BlockPos(posX, posY, posZ);
            BlockState bstate = ((Entity) (Object) this).getEntityWorld().getBlockState(pos);//get blockstate
            String state = String.valueOf(bstate);
            if(state.contains("minecraft:water_cauldron")) {
                this.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 1F, 1F);
                entity.damage(DamageSource.DROWN, Integer.MAX_VALUE);
            }
        }
    }
}
