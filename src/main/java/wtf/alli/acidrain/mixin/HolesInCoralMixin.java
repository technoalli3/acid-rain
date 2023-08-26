package wtf.alli.acidrain.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;

@Mixin(Blocks.class)
public class HolesInCoralMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/DeadCoralBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"), index = 0)
    private static AbstractBlock.Settings onBlocksClinit(AbstractBlock.Settings settings) {
        return settings.nonOpaque();
    }
}
