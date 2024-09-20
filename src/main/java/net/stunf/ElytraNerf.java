package net.stunf;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElytraNerf implements ModInitializer {
	public static final String MOD_ID = "elytra-nerf";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded Elytra Nerf!");
	}
}