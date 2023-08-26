package wtf.alli.acidrain.mixin;

import wtf.alli.acidrain.AcidRainMain;
import net.minecraft.world.biome.BiomeEffects;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;

@Mixin(BiomeEffects.class)
public class BiomeColourMixin {
    @Shadow @Final private int skyColor;

    @Shadow @Final private int waterColor;

    @Shadow @Final private int fogColor;

    @Shadow @Final private int waterFogColor;

    @Shadow @Final private Optional<Integer> foliageColor;

    /**
     * @author TechnoAlli3
     * @reason acid is green
     */
    @Overwrite
    public int getWaterColor() {
        if(AcidRainMain.getWaterColourEnabled()) {
            return AcidRainMain.getWaterColour();
        }else {
            return this.waterColor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason matching fog colour
     */
    @Overwrite
    public int getWaterFogColor() {
        if(AcidRainMain.getWaterFogEnabled()){
            return AcidRainMain.getWaterFogColour();
        }else {
            return this.waterFogColor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason black fog
     */
    @Overwrite
    public int getFogColor() {
        if(AcidRainMain.getSkyFogEnabled()){
            return AcidRainMain.getSkyFogColour();
        }else {
            return this.fogColor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason black sky
     */
    @Overwrite
    public int getSkyColor() {
        if(AcidRainMain.getSkyColourEnabled()) {
            return AcidRainMain.getSkyColour();
        }else {
            return this.skyColor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason gray trees
     */
    @Overwrite
    public Optional<Integer> getFoliageColor() {
        if(AcidRainMain.getFoliageEnabled()){
            return Optional.of(AcidRainMain.getFoliageColour());
        }else {
            return this.foliageColor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason gray grass
     */
    @Overwrite
    public Optional<Integer> getGrassColor() {
        if(AcidRainMain.getGrassEnabled()){
            return Optional.of(AcidRainMain.getGrassColour());
        }else {
            return this.foliageColor;
        }
    }
}