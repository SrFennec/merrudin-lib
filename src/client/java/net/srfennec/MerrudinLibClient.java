package net.srfennec;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.srfennec.lib.util.DynamicModelUtil;

import java.util.ArrayList;
import java.util.List;

public class MerrudinLibClient implements ClientModInitializer,ModelLoadingPlugin  {
	//public static DynamicModels Models = new DynamicModels();
	public static List<Identifier> Models = new ArrayList<Identifier>();
	@Override
	public void onInitializeClient() {
		MerrudinLib.LOGGER.info("Merrudin-lib registering dynamic models");
		ModelLoadingPlugin.register(this);
		//DynamicModelUtil.registerDynamicItemModel(
		//				Identifier.of(MerrudinLib.MOD_ID,"test_0"),
		//				Identifier.of(MerrudinLib.MOD_ID,"test_1"),
		//				Identifier.of(MerrudinLib.MOD_ID,"test_2")
		//);
	}
	@Override
	public void onInitializeModelLoader(Context pluginContext) {
		pluginContext.addModels(Models);
	}
}
