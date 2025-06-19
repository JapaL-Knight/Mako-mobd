package net.mobmako.makomobd;

import net.fabricmc.api.ClientModInitializer;
import net.mobmako.makomobd.util.ModModelPredicates;

public class MakoMobdClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();
    }
}
