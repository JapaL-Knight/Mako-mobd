package net.mobmako.makomobd;

import net.fabricmc.api.ModInitializer;

import net.mobmako.makomobd.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakoMobd implements ModInitializer {
	public static final String MOD_ID = "makomobd";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
	}
}