package net.mobmako.makomobd.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.mobmako.makomobd.MakoMobd;
import net.mobmako.makomobd.item.ModItems;

public class ModModelPredicates {
    public static void registerModelPredicates(){
        ModelPredicateProviderRegistry.register(ModItems.AMETHYST_MACUAHUITL, Identifier.of(MakoMobd.MOD_ID, "amethyst"),
                (stack, world, entity, seed) -> (float) stack.getDamage() /3);
    }


}
