package net.mobmako.makomobd.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobmako.makomobd.item.ModItems;

import java.util.List;

public class AmethystMachuahuitlItem extends Item {
    public AmethystMachuahuitlItem(Settings settings) {
        super(settings
                .maxDamage(24)
                .component(DataComponentTypes.TOOL, createToolComponent())
                .attributeModifiers(createAttributeModifiers()));
    }


    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 7 , EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.4, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!(stack.getDamage()%3 == 0)){
            if (!miner.getWorld().isClient)
                world.playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_GLASS_BREAK,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.0f
                );
            }
        if(stack.getDamage() >= stack.getMaxDamage()-2){
            miner.setStackInHand(Hand.MAIN_HAND,new ItemStack(ModItems.MACUAHUITL));
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return 0xFF00FF;
    }


    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        if(stack.getDamage()%3==0){
            if (!attacker.getWorld().isClient) {
                World world = attacker.getWorld();
                world.playSound(
                        null,
                        target.getBlockPos(),
                        SoundEvents.BLOCK_GLASS_BREAK,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.0f
                );
            }
        }
        if(stack.getDamage() >= stack.getMaxDamage()) {
            attacker.setStackInHand(Hand.MAIN_HAND,new ItemStack(ModItems.MACUAHUITL));
        }
    }



}
