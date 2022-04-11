package com.alli.acidrain;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static net.minecraft.block.Blocks.*;

public class AcidRainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(DEAD_HORN_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(DEAD_BRAIN_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(DEAD_BUBBLE_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(DEAD_FIRE_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(DEAD_TUBE_CORAL_BLOCK, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(TUBE_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BRAIN_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(FIRE_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(HORN_CORAL_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BUBBLE_CORAL_BLOCK, RenderLayer.getCutoutMipped());
    }
}
