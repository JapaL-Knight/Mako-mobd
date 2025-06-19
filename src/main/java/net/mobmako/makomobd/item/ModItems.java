package net.mobmako.makomobd.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mobmako.makomobd.MakoMobd;
import net.mobmako.makomobd.item.custom.AmethystMachuahuitlItem;
import net.mobmako.makomobd.item.custom.ModSmithingTemplateItem;

public class ModItems {

    public static final Item KNOWLEDGE_OF_EFFICIENCY = registerItem("knowledge_of_efficiency", new Item(new Item.Settings()));
    public static final Item MACUAHUITL = registerItem("macuahuitl", new Item(new Item.Settings().maxCount(1)));
    public static final Item AMETHYST_MACUAHUITL = registerItem("amethyst_macuahuitl", new AmethystMachuahuitlItem(new Item.Settings()));
    public static final Item AMETHYST_ENGRAVING_SMITHING_TEMPLATE = registerItem("amethyst_engraving_smithing_template", ModSmithingTemplateItem.createMacuahuitlUpgrade());

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MakoMobd.MOD_ID, name), item);
    }

    public static void registerModItems( ){
        MakoMobd.LOGGER.info("Registrando items de mods para " + MakoMobd.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(AMETHYST_MACUAHUITL);
            fabricItemGroupEntries.add(MACUAHUITL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(KNOWLEDGE_OF_EFFICIENCY);
            fabricItemGroupEntries.add(AMETHYST_ENGRAVING_SMITHING_TEMPLATE);
        });

    }
}
