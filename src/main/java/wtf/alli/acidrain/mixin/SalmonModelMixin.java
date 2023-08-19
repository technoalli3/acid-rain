package wtf.alli.acidrain.mixin;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SalmonEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SalmonEntityModel.class)
public class SalmonModelMixin {

    /**
     * @author TechnoAlli3
     * @reason Nightmare fish
     */
    @Overwrite
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("body_front", ModelPartBuilder.create().uv(0, 0).cuboid(-5.5F, 3.5F, 9.0F, 11.0F, 11.0F, 13.0F), ModelTransform.pivot(0.0F, 20.0F, 0.0F));
        ModelPartData modelPartData3 = modelPartData.addChild("body_back", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, 3.5F, 4.0F, 7.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, 20.0F, 8.0F));
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -4.0F, -12.0F, 2.0F, 4.0F, 3.0F), ModelTransform.pivot(0.0F, 20.0F, 0.0F));
        modelPartData3.addChild("back_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 3.5F, 12.0F, 0.0F, 7.0F, 6.0F), ModelTransform.pivot(0.0F, 7.0F, 12.0F));
        modelPartData2.addChild("top_front_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 14.5F, -8.0F, 0.0F, 7.0F, 10.0F), ModelTransform.pivot(0.0F, 14.5F, -2.0F));
        modelPartData3.addChild("top_back_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F), ModelTransform.pivot(0.0F, -4.5F, -1.0F));
        modelPartData.addChild("right_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), ModelTransform.of(-5.5F, 9.5F, -3.0F, 0.0F, -25.0F, -0.0F));
        modelPartData.addChild("left_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), ModelTransform.of(-5.5F, 9.5F, -3.0F, 0.0F, 25.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
}
