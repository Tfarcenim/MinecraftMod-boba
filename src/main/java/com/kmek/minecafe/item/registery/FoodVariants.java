package com.kmek.minecafe.item.registery;

public enum FoodVariants {
    // Vanilla variants
    CARROT, POTATO, BEETROOT,
    APPLE, SWEET_BERRY, GLOW_BERRY, WATERMELON, CHORUS_FRUIT,

    // Sweet variants
    /*VANILLA,*/ CHOCOLATE, CARAMEL, PUMPKIN_SPICE, HONEY, BROWN_SUGAR,

    // Flowery
    ROSE, BUTTERFLY_PEA, LAVENDER, MATCHA,

    // Fruit tree crops
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
    GRAPE,
    KIWI,
    DRAGON_FRUIT,
    PASSION_FRUIT,
    POMEGRANATE,
    COCONUT,
    MANGOSTEEN,
    MONKFRUIT,
    STARFRUIT,
    ACAI,

    // Bush crops
    RASPBERRY,
    BLUEBERRY,
    CRANBERRY,
    GOOSEBERRY,
    KIWIBERRY,
    BLACKBERRY,

    // Tilled crops
    STRAWBERRY,
    WHITE_STRAWBERRY,
    PINEAPPLE,
//    ALOE_VERA,
    MINT, // todo crop
    VANILLA,

    PECAN, // todo crops
    PEANUT,
    ALMOND,
    MACADAMIA_NUT,

    // todo Pumpkin-style crop and block
    HONEYDEW_MELON,

    // todo Full size tree?
    CINNAMON;

    public static final FoodVariants[] fruits = { APPLE, ORANGE, LEMON, LIME, AVOCADO, LYCHEE, BANANA, MANGO, CHERRY,
            PEACH, PEAR, PLUM, FIG, GRAPE, KIWI, PINEAPPLE, DRAGON_FRUIT, PASSION_FRUIT,
            POMEGRANATE, COCONUT, HONEYDEW_MELON, MANGOSTEEN, MONKFRUIT, ACAI,
            STARFRUIT, STRAWBERRY, WHITE_STRAWBERRY, RASPBERRY, BLUEBERRY, BLACKBERRY, CRANBERRY, GOOSEBERRY, KIWIBERRY
            /*ALOE_VERA*/ };

    public static final FoodVariants[] nuts = { ALMOND, PECAN, PEANUT, MACADAMIA_NUT };

    public static final FoodVariants[] treeCrops = { APPLE, ORANGE, LEMON, LIME, AVOCADO, LYCHEE, BANANA, MANGO, CHERRY,
            PEACH, PEAR, PLUM, FIG,
            GRAPE, KIWI, DRAGON_FRUIT, PASSION_FRUIT, POMEGRANATE, COCONUT, MANGOSTEEN, MONKFRUIT, STARFRUIT, ACAI };

    public static final FoodVariants[] bushCrops = { RASPBERRY, BLUEBERRY, BLACKBERRY, CRANBERRY, GOOSEBERRY, KIWIBERRY };

    public static final FoodVariants[] tilledCrops = { STRAWBERRY, WHITE_STRAWBERRY, PINEAPPLE };

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
