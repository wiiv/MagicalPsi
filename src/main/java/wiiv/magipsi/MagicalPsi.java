package wiiv.magipsi;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wiiv.magipsi.proxy.CommonProxy;

@Mod(modid = MagicalPsi.MOD_ID, name = MagicalPsi.MOD_NAME, version = MagicalPsi.VERSION, dependencies = MagicalPsi.DEPENDENCIES)
public class MagicalPsi {

	public static final String MOD_ID = "magipsi";
	public static final String MOD_NAME = "Magical Psi";
	public static final String VERSION = "1.3";
	public static final String DEPENDENCIES = "required-after:psi";

	public static final String COMMON_PROXY = "wiiv.magipsi.proxy.CommonProxy";
	public static final String CLIENT_PROXY = "wiiv.magipsi.proxy.ClientProxy";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
	
	@SidedProxy(serverSide = COMMON_PROXY, clientSide = CLIENT_PROXY)
	public static CommonProxy proxy;
	
	public MagicalPsi() {
		ensureResourceOrder();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModCraftingRecipes.init();
		proxy.replacePsiAssets();
	}

	// Construction is called before resources are loaded and before
	// proxies are assigned, so we have to reflect around
	private void ensureResourceOrder() {
		if(FMLCommonHandler.instance().getSide().isServer())
			return;

		String classname = "wiiv.magipsi.client.ResourceProxy";
		try {
			Class<?> clazz = Class.forName(classname);
			clazz.getMethod("init").invoke(null);
		} catch(Throwable e) {
			LOGGER.error("Could not hook Resource Proxy.", e);
		}
	}

}

