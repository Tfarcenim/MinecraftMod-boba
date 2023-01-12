package com.kmek.bobamod.tags;

import com.kmek.bobamod.BobaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
//        public static final TagKey<Block> NEEDS_ZIRCON_TOOL = tag("needs_zircon_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(BobaMod.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> WAFFLE = tag("waffle");
        public static final TagKey<Item> WAFFLE_MOLD = tag("waffle_mold");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(BobaMod.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
