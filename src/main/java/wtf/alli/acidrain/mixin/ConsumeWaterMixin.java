package wtf.alli.acidrain.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.entity.effect.StatusEffects.*;
import static net.minecraft.item.Items.POTION;

@Mixin(PotionItem.class)
public class ConsumeWaterMixin {
    @Inject(method="finishUsing", at=@At(value="INVOKE", target="Lnet/minecraft/item/ItemStack;decrement(I)V"))
    private void CheckForWater(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if(stack.isOf(POTION)){//is potion
            String name = String.valueOf(stack.getName());//get name string
            if(name.contains("item.minecraft.potion.effect.water")) {
                user.addStatusEffect(new StatusEffectInstance(BLINDNESS, 600));
                user.addStatusEffect(new StatusEffectInstance(NAUSEA, 2400));
                user.addStatusEffect(new StatusEffectInstance(POISON, 140));
            }
        }
    }
}
