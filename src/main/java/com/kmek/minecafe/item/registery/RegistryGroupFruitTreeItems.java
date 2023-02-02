package com.kmek.minecafe.item.registery;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryGroupFruitTreeItems /*extends RegistryGroup<FruitItems, Item>*/ {
    private final String name;
    private final Block seedCrop;
    private final DeferredRegister<Item> REG;
    protected List<FruitItems> values = Arrays.asList(FruitItems.values());
    protected final Map<FruitItems, Item> group = new HashMap<>();

    public RegistryGroupFruitTreeItems(String fruitName, Block seedCrop, DeferredRegister<Item> items) {
        this.REG = items;
//        super(items, Arrays.asList(FruitItems.values()));
        this.name = fruitName;
        this.seedCrop = seedCrop;

    }

    public RegistryGroupFruitTreeItems skip(FruitItems toSkip) {
//        skipInner(toSkip);
        this.values = values.stream().filter(val -> val != toSkip).toList();
        return this;
    }

    public RegistryGroupFruitTreeItems override(FruitItems toOverride, Item toSet) {
//        overrideInner(toOverride, toSet);
        skip(toOverride);
        group.put(toOverride, toSet);
        return this;
    }

    public Map<FruitItems, Item> build() {
        values.forEach(this::buildItem);
        return group;
    }

//    @Override
    protected void buildItem(FruitItems val) {
        switch (val) {
            case FRUIT:
                REG.register(name, () -> new Item(new Item.Properties()
                        .food(new FoodProperties.Builder()
                                .nutrition(3)
                                .saturationMod(1f)
                                .build())));
                break;
            case SEEDS:
                REG.register(name + "_seeds", () -> new ItemNameBlockItem(seedCrop, new Item.Properties()));
                break;
        }
    }
}
