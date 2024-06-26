package net.srfennec.lib.items;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public interface ModelDynamicItem {
    Identifier[] DefaultModels = new Identifier[]{};
    default Identifier[] getModels(){
        return DefaultModels;
    }

    default Identifier[] getCurrentModel(ItemStack stack) {
        return new Identifier[]{getModels()[0]};
    }

}
