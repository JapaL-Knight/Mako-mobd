package net.mobmako.makomobd.item.custom;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {

    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Text AMETHYST_ENGRAVING_TEXT = Text.translatable("upgrade.makomobd.amethyst_macuahuitl_upgrade")
            .formatted(TITLE_FORMATTING);
    private static final Text AMETHYST_ENGRAVING_APPLIES_TO_TEXT = Text.translatable("item.makomobd.smithing_template.amethyst_engraving.applies_to")
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text AMETHYST_ENGRAVING_INGREDIENTS_TEXT = Text.translatable("item.makomobd.smithing_template.amethyst_engraving.ingredients")
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text AMETHYST_ENGRAVING_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable("item.makomobd.smithing_template.amethyst_engraving.base_slot_description");
    private static final Text AMETHYST_ENGRAVING_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable("item.makomobd.smithing_template.amethyst_engraving.additions_slot_description");


    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, FeatureFlag... requiredFeatures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, requiredFeatures);
    }

    public static SmithingTemplateItem createMacuahuitlUpgrade() {
        return new SmithingTemplateItem(
                AMETHYST_ENGRAVING_APPLIES_TO_TEXT,
                AMETHYST_ENGRAVING_INGREDIENTS_TEXT,
                AMETHYST_ENGRAVING_TEXT,
                AMETHYST_ENGRAVING_BASE_SLOT_DESCRIPTION_TEXT,
                AMETHYST_ENGRAVING_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                List.of(Identifier.tryParse("makomobd:item/macuahuitl_empty_slot")),
                List.of(Identifier.ofVanilla("item/empty_slot_amethyst_shard"))
        );
    }
}
