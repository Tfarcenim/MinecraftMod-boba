package com.kmek.bobamod.block.entity;

import com.kmek.bobamod.BobaMod;
import com.kmek.bobamod.block.ModBlocksInit;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BobaMod.MODID);

    public static final RegistryObject<BlockEntityType<WaffleIronBlockEntity>> WAFFLE_IRON =
            BLOCK_ENTITIES.register("waffle_iron", () ->
                    BlockEntityType.Builder.of(WaffleIronBlockEntity::new,
                            ModBlocksInit.WAFFLE_IRON.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
