package com.kmek.minecafe.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class DisplayCaseScreen extends CustomBaseScreen<DisplayCaseMenu> {
    public DisplayCaseScreen(DisplayCaseMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, "textures/gui/display_case_gui.png");
    }
}
