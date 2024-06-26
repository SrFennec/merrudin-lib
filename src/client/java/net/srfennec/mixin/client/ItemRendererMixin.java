package net.srfennec.mixin.client;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.srfennec.lib.items.ModelDynamicItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow protected abstract void renderBakedItemModel(BakedModel model, ItemStack stack, int light, int overlay, MatrixStack matrices, VertexConsumer vertices);
    @Shadow @Final
    private ItemModels models;

    @Redirect(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderBakedItemModel(Lnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/item/ItemStack;IILnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;)V"))
    public void merrudin$renderBakedModel(ItemRenderer instance, BakedModel model, ItemStack stack, int light, int overlay, MatrixStack matrices, VertexConsumer vertices){
        if(stack.getItem() instanceof ModelDynamicItem){
            this.renderBakedItemModels(stack,light,overlay,matrices,vertices);
        }else{
            renderBakedItemModel(model,stack,light,overlay,matrices,vertices);
        }
    }
    @Unique
    public void renderBakedItemModels(ItemStack stack, int light, int overlay, MatrixStack matrices, VertexConsumer vertices){
        ModelDynamicItem item = (ModelDynamicItem) stack.getItem();
        Identifier[] item_models = item.getCurrentModel(stack);
        for (Identifier item_model : item_models) {
            BakedModel model = models.getModelManager().getModel(item_model);
            renderBakedItemModel(model, stack, light, overlay, matrices, vertices);
        }
    }
}
