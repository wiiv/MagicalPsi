package wiiv.magipsi.proxy;

import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.common.item.ItemExosuitSensor;
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
		
		ItemExosuitSensor.defaultColor = 0xEFBFFF;
		ItemExosuitSensor.fireColor = 0xFF1F00;
		ItemExosuitSensor.lightColor = 0xFFDF00;
		ItemExosuitSensor.lowHealthColor = 0x7FFF00;
		ItemExosuitSensor.underwaterColor = 0x003FFF;
		
		ItemPsimetalArmor.modelSupplier = ModelFocusingPlate::new;
	}
	
}
