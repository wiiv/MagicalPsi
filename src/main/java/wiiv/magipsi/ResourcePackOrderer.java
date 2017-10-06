package wiiv.magipsi;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public final class ResourcePackOrderer {

	public static final String[] DEFAULT_RESOURCE_PACKS = new String[] { "aD", "field_110449_ao", "defaultResourcePacks" };
	
	private ResourcePackOrderer() { }
	
	// Called reflectively from MagicalPsi. Do not rename.
	public static void reorder() {
		List<IResourcePack> packs = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), DEFAULT_RESOURCE_PACKS);
		
		for(IResourcePack pack : packs)
			if(pack.getPackName().endsWith(":Magical Psi")) {
				packs.remove(pack);
				packs.add(pack);
				return;
			}
	}
	
}
