package net.srfennec.lib.util;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.util.Identifier;
import net.srfennec.MerrudinLib;
import net.srfennec.MerrudinLibClient;
import net.srfennec.lib.items.ModelDynamicItem;

import java.util.Arrays;

public class DynamicModelUtil implements ModelLoadingPlugin {
    public static void registerDynamicItemModel(ModelDynamicItem item) {
        for (Identifier model : item.getModels()){
            MerrudinLibClient.Models.add(model);

        }
    }


    public static void registerDynamicItemModel(Identifier ... models) {
        for (Identifier model : models){
            MerrudinLibClient.Models.add(model);
        }
    }

    @Override
    public void onInitializeModelLoader(Context pluginContext) {

    }
}
