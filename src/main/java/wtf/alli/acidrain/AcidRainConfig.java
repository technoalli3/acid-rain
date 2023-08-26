package wtf.alli.acidrain;

import org.quiltmc.config.api.WrappedConfig;
import org.quiltmc.config.api.annotations.Comment;

public class AcidRainConfig extends WrappedConfig {

    public final Main main = new Main();
    public class Main implements Section {
        @Comment("Enable sky colour change")
        public final boolean skyColourEnabled = true;
        @Comment("Sky colour")
        final int skyColour = 0x507500;

        @Comment("Enable sky fog colour change")
        final boolean skyFogEnabled = true;
        @Comment("Sky fog colour")
        final int skyFogColour = 0x2C0236;

        @Comment("Enable water colour change")
        final boolean waterColourEnabled = true;
        @Comment("Water colour")
        final int waterColour = 0x20F400;

        @Comment("Enable water fog colour change")
        final boolean waterFogEnabled = true;
        @Comment("Water fog colour")
        final int waterFogColour = 0x20F400;

        @Comment("Enable foliage colour change")
        final boolean foliageEnabled = true;
        @Comment(value = "Foliage colour")
        final int foliageColour = 0xADADAD;

        @Comment(value = "Enable grass colour change")
        final boolean grassEnabled = true;
        @Comment(value = "Grass colour")
        final int grassColour = 0x434343;

        @Comment(value = "Hurt players?")
        public final boolean hurtPlayers = true;

        @Comment(value = "Hurt non-player entities?")
        public final boolean hurtEntities = true;
    }
    /*@Override
    public String getName() {
        return "main";
    }

    @Override
    public @Nullable String getModid() {
        return AcidRainMain.MOD_ID;
    }

    @Override
    public String getDirectory() {
        return "acidrain";
    }*/
}
