package com.kmek.minecafe.item.registery;

public enum FoodVariants {
    // Vanilla variants
    CARROT, POTATO, BEETROOT,
    SWEET_BERRY, GLOW_BERRY, WATERMELON, CHORUS_FRUIT,

    // Sweet variants
    VANILLA, CHOCOLATE, CARAMEL, PUMPKIN_SPICE, HONEY, BROWN_SUGAR,

    // Flowery
    ROSE, BUTTERFLY_PEA, LAVENDER, MATCHA,

    // Fruit tree crops
    APPLE,
    ORANGE,
    LEMON,
    LIME,
    AVOCADO,
    LYCHEE,
    BANANA,
    MANGO,
    CHERRY,
    PEACH,
    PEAR,
    PLUM,
    FIG,

    // To be implemented as growable crops eventually
    STRAWBERRY,
    WHITE_STRAWBERRY,
    RASPBERRY,
    BLUEBERRY,
    CRANBERRY,
    DRAGON_FRUIT,
    EGG_FRUIT,
    GRAPE,
    KIWI,
    MANGOSTEEN,
    PAPAYA,
    PASSION_FRUIT,
    PINEAPPLE,
    POMEGRANATE;

    public static final FoodVariants[] juices = {APPLE, ORANGE, LEMON, LIME, LYCHEE, MANGO, CHERRY, PEACH,
            PEAR, PLUM, FIG, SWEET_BERRY, WATERMELON, GLOW_BERRY, CHORUS_FRUIT, CARROT, POTATO, BEETROOT/*,
            STRAWBERRY, RASPBERRY, BLUEBERRY, CRANBERRY, DRAGON_FRUIT, GRAPE, KIWI, MANGOSTEEN, PAPAYA,
            PASSION_FRUIT, PINEAPPLE, POMEGRANATE*/};

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
