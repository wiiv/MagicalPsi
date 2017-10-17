package wiiv.magipsi.proxy;

import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.common.item.armor.ItemPsimetalArmor;
import wiiv.magipsi.client.ModelFocusingPlate;

public class ClientProxy extends CommonProxy {

	@Override
	public void replacePsiAssets() {
		SpellParam.RED = 0xFF003F;
		SpellParam.GREEN = 0x3FFF00;
		SpellParam.BLUE = 0x007FFF;
		SpellParam.PURPLE = 0xBF7FFF;
		SpellParam.CYAN = 0x00FFBF;
		SpellParam.YELLOW = 0xFFBF00; // For entities
		SpellParam.GRAY = 0x3F3F3F; // For connectors
		
		ItemPsimetalArmor.modelSupplier = ModelFocusingPlate::new;
	}
	
}
