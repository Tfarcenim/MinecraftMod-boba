package com.kmek.bobamod.screen;

import com.kmek.bobamod.BobaMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BobaMod.MODID);

    public static final RegistryObject<MenuType<WaffleIronMenu>> WAFFLE_IRON_MENU =
            registerMenuType(WaffleIronMenu::new, "waffle_iron_menu");

    public static final RegistryObject<MenuType<DisplayCaseMenu>> DISPLAY_CASE_MENU =
            registerMenuType(DisplayCaseMenu::new, "display_case_menu");
    public static final RegistryObject<MenuType<CakeStandMenu>> CAKE_STAND_MENU =
            registerMenuType(CakeStandMenu::new, "cake_stand_menu");

    /**
     * Setup for menu registering
     */

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>>
        registerMenuType(IContainerFactory<T> factory, String name) {
            return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
