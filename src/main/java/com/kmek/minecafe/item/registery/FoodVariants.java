package com.kmek.minecafe.item.registery;

public enum FoodVariants {
    // Vanilla variants
    CARROT, POTATO, BEETROOT,
    SWEET_BERRY, GLOW_BERRY, WATERMELON, CHORUS_FRUIT,

    // Sweet variants
    /*VANILLA,*/ CHOCOLATE, CARAMEL, PUMPKIN_SPICE, HONEY, BROWN_SUGAR,

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

    // todo tree crop to add
    GRAPE,
    KIWI,
    DRAGON_FRUIT,
    PASSION_FRUIT,
    POMEGRANATE,
    COCONUT, // (special tree one day?)
    MANGOSTEEN,
    MONKFRUIT,
    STARFRUIT,
    ACAI,

    // todo Bush crop
    RASPBERRY,
    BLUEBERRY,
    CRANBERRY,
    GOOSEBERRY,
    KIWIBERRY,

    // todo 1 block Crop (custom art)
    STRAWBERRY,
    WHITE_STRAWBERRY,
    PINEAPPLE,
    ALOE_VERA,
    MINT,
    VANILLA,

    PECAN,
//    PEANUT, // eventually
//    ALMOND, // eventually

    // todo Pumpkin-style crop and block
    HONEYDEW_MELON,

    // todo Full size tree?
    CINNAMON;

    public static final FoodVariants[] fruits = { APPLE, ORANGE, LEMON, LIME, AVOCADO, LYCHEE, BANANA, MANGO, CHERRY,
            PEACH, PEAR, PLUM, FIG, GRAPE, KIWI, PINEAPPLE, DRAGON_FRUIT, PASSION_FRUIT,
            POMEGRANATE, COCONUT, HONEYDEW_MELON, MANGOSTEEN, MONKFRUIT,
            STARFRUIT, STRAWBERRY, WHITE_STRAWBERRY, RASPBERRY, BLUEBERRY, CRANBERRY, ACAI, GOOSEBERRY, KIWIBERRY,
            ALOE_VERA };

    public static final FoodVariants[] treeCrops = {APPLE, ORANGE, LEMON, LIME, AVOCADO, LYCHEE, BANANA, MANGO, CHERRY, PEACH,
            PEAR, PLUM, FIG/*, DRAGON_FRUIT, EGG_FRUIT, GRAPE, KIWI, MANGOSTEEN, PAPAYA, PASSION_FRUIT, POMEGRANATE, ACAI*/};

    public static final FoodVariants[] bushCrops = {RASPBERRY, BLUEBERRY, CRANBERRY, GOOSEBERRY, KIWIBERRY};

    public static final FoodVariants[] juices = {APPLE, ORANGE, LEMON, LIME, LYCHEE, MANGO, CHERRY, PEACH,
            PEAR, PLUM, FIG, SWEET_BERRY, WATERMELON, GLOW_BERRY, CHORUS_FRUIT, CARROT, POTATO, BEETROOT/*,
            STRAWBERRY, RASPBERRY, BLUEBERRY, CRANBERRY, DRAGON_FRUIT, GRAPE, KIWI, MANGOSTEEN, PAPAYA,
            PASSION_FRUIT, PINEAPPLE, POMEGRANATE*/};

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
