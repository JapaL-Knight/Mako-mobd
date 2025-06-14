package net.mobmako.makomobd.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mobmako.makomobd.MakoMobd;

public class ModItems {

    public static final Item KNOWLEDGE_OF_EFFICIENCY = registerItem("knowledge_of_efficiency", new Item(new Item.Settings()));
    public static final Item AMETHYST_MACUAHUITL = registerItem("amethyst_macuahuitl", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MakoMobd.MOD_ID, name), item);
    }

    public static void registerModItems( ){
        MakoMobd.LOGGER.info("Registrando items de mods para " + MakoMobd.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(AMETHYST_MACUAHUITL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(KNOWLEDGE_OF_EFFICIENCY);
        });


    }
}
