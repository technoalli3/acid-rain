package wtf.alli.acidrain.mixin;

import wtf.alli.acidrain.AcidRainMain;
import net.minecraft.client.color.world.FoliageColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(FoliageColors.class)
public class BirchSpruceMixin {
    /**
     * @author TechnoAlli3
     * @reason to customize colours
     */
    @Overwrite
    public static int getSpruceColor() {
        int hex = AcidRainMain.getFoliageColour();
        String hexS = Integer.toHexString(hex);
        return Integer.parseInt(hexS,16);
    }

    /**
     * @author TechnoAlli3
     * @reason to customize colours
     */
    @Overwrite
    public static int getBirchColor() {
        int hex = AcidRainMain.getFoliageColour();
        String hexS = Integer.toHexString(hex);
        return Integer.parseInt(hexS,16);
    }

    /**
     * @author TechnoAlli3
     * @reason to customize colours
     */
    @Overwrite
    public static int method_43717() {
        //Mangrove foliage
        int hex = AcidRainMain.getFoliageColour();
        String hexS = Integer.toHexString(hex);
        return Integer.parseInt(hexS,16);
    }
}
