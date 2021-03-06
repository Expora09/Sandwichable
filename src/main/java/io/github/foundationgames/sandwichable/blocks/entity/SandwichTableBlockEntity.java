package io.github.foundationgames.sandwichable.blocks.entity;

import io.github.foundationgames.sandwichable.blocks.BlocksRegistry;
import io.github.foundationgames.sandwichable.items.ItemsRegistry;
import io.github.foundationgames.sandwichable.items.SpreadRegistry;
import io.github.foundationgames.sandwichable.items.spread.SpreadItem;
import io.github.foundationgames.sandwichable.util.Util;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;

public class SandwichTableBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    private DefaultedList<ItemStack> foods = DefaultedList.ofSize(128, ItemStack.EMPTY);

    public SandwichTableBlockEntity() {
        super(BlocksRegistry.SANDWICHTABLE_BLOCKENTITY);
    }

    public void addFood(PlayerEntity player, ItemStack playerStack) {
        int i=0;
        while(this.foods.get(i)!=ItemStack.EMPTY && i < this.foods.size()-1) {i++;}
        ItemStack stack = playerStack.copy();
        stack.setCount(1);
        if(getFoodListSize() >= 127) {
            stack = ItemStack.EMPTY;
        } else if(!player.abilities.creativeMode) {
            playerStack.decrement(1);
        }
        if (i < this.foods.size()-1) {
            if(SpreadRegistry.INSTANCE.itemHasSpread(stack.getItem())) {
                ItemStack spread = new ItemStack(ItemsRegistry.SPREAD, 1);
                SpreadRegistry.INSTANCE.getSpreadFromItem(stack.getItem()).onPour(stack, spread);
                spread.getOrCreateTag().putString("spreadType", SpreadRegistry.INSTANCE.serialize(SpreadRegistry.INSTANCE.getSpreadFromItem(stack.getItem())));
                this.foods.set(i, spread);
                if(!player.isCreative()) {
                    player.giveItemStack(new ItemStack(SpreadRegistry.INSTANCE.getSpreadFromItem(stack.getItem()).getResultItem(), 1));
                }
            } else {
                this.foods.set(i, stack);
            }
        }
        if(this.getFoodListSize() >= 127) {
            player.sendMessage(new TranslatableText("message.sandwichtable.fullsandwich").formatted(Formatting.RED), true);
        }
    }

    public void addTopStackFrom(ItemStack stack) {
        int i=0;
        while(this.foods.get(i)!=ItemStack.EMPTY && i < this.foods.size()-1) {i++;}
        ItemStack nstack = stack.split(1);
        this.foods.set(i, nstack);
    }

    public ItemStack removeTopFood() {
        ItemStack r;
        int i=0;
        while(this.foods.get(i)!=ItemStack.EMPTY) {i++;}
        r = this.foods.get(i-1);
        this.foods.set(i-1, ItemStack.EMPTY);
        return r.getItem() instanceof SpreadItem ? ItemStack.EMPTY : r;
    }

    public ItemStack getTopFood() {
        ItemStack r;
        int i=0;
        while(this.foods.get(i)!=ItemStack.EMPTY) {i++;}
        r = this.foods.get(i-1);
        return r;
    }

    public DefaultedList<ItemStack> getFoodList() {
        return this.foods;
    }

    public void setFoodList(DefaultedList<ItemStack> list) {
        this.foods = list;
    }

    public int getFoodListSize() {
        int i=0;
        while(this.foods.get(i)!=ItemStack.EMPTY && i < this.foods.size()) {i++;}
        return i;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        DefaultedList<ItemStack> list = DefaultedList.ofSize(128, ItemStack.EMPTY);
        Inventories.fromTag(tag, list);
        setFoodList(list);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.foods);
        return tag;
    }

    public CompoundTag serializeSandwich(CompoundTag tag) {
        Inventories.toTag(tag, this.foods);
        return tag;
    }

    public void deserializeSandwich(CompoundTag tag) {
        DefaultedList<ItemStack> list = DefaultedList.ofSize(128, ItemStack.EMPTY);
        Inventories.fromTag(tag, list);
        setFoodList(list);
    }

    @Override
    public void fromClientTag(CompoundTag compoundTag) {
        this.fromTag(world.getBlockState(pos), compoundTag);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        return this.toTag(compoundTag);
    }
}
