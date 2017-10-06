package wiiv.magipsi;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vazkii.psi.api.spell.SpellParam;

@Mod(modid = MagicalPsi.MOD_ID, name = MagicalPsi.MOD_NAME, version = MagicalPsi.VERSION, dependencies = MagicalPsi.DEPENDENCIES)
public class MagicalPsi {

	public static final String MOD_ID = "magipsi";
	public static final String MOD_NAME = "Magical Psi";
	public static final String VERSION = "dev";
	public static final String DEPENDENCIES = "required-after:psi";

	public MagicalPsi() {
		ensureResourceOrder();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModCraftingRecipes.init();
		changeArrowColors();
	}

	private void changeArrowColors() {
		SpellParam.RED = 0xFF003F;
		SpellParam.GREEN = 0x3FFF00;
		SpellParam.BLUE = 0x007FFF;
		SpellParam.PURPLE = 0xBF7FFF;
		SpellParam.CYAN = 0x00FFBF;
		SpellParam.YELLOW = 0xFFBF00; // For entities
		SpellParam.GRAY = 0x3F3F3F; // For connectors
	}

	// Construction is called before resources are loaded and before
	// proxies are assigned, so we have to reflect around
	private void ensureResourceOrder() {
		if(FMLCommonHandler.instance().getSide().isServer())
			return;

		String classname = "wiiv.magipsi.ResourceProxy";
		try {
			Class<?> clazz = Class.forName(classname);
			clazz.getMethod("init").invoke(null);
		} catch(Throwable e) {
			FMLLog.severe("[Magical Psi] Could not hook Resource Proxy.");
			e.printStackTrace();
		}
	}

}
