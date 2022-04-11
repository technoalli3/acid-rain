package com.alli.acidrain;

import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AcidRainConfig implements Config {

    @Comment(value = "Enable sky colour change")
    boolean skyColourEnabled = true;
    @Comment(value = "Sky colour")
    int skyColour = 0x507500;

    @Comment(value = "Enable sky fog colour change")
    boolean skyFogEnabled = true;
    @Comment(value = "Sky fog colour")
    int skyFogColour = 0x2C0236;

    @Comment(value = "Enable water colour change")
    boolean waterColourEnabled = true;
    @Comment(value = "Water colour")
    int waterColour = 0x20F400;

    @Comment(value = "Enable water fog colour change")
    boolean waterFogEnabled = true;
    @Comment(value = "Water fog colour")
    int waterFogColour = 0x20F400;

    @Comment(value = "Enable foliage colour change")
    boolean foliageEnabled = true;
    @Comment(value = "Foliage colour")
    int foliageColour = 0xADADAD;

    @Comment(value = "Enable grass colour change")
    boolean grassEnabled = true;
    @Comment(value = "Grass colour")
    int grassColour = 0x434343;

    @Override
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
    }
}
