package wiiv.magipsi.common.core.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import wiiv.magipsi.common.crafting.ModCraftingRecipes;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		
		ModCraftingRecipes.init();
	}

}
