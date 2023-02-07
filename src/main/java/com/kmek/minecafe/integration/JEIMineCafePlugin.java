package com.kmek.minecafe.integration;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.recipe.EspressoMachineRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIMineCafePlugin implements IModPlugin {
    public static RecipeType<EspressoMachineRecipe> ESPRESSO_TYPE = new RecipeType<>(EspressoMachineRecipeCategory.UID, EspressoMachineRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MineCafeMod.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new EspressoMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        // Espresso Machine
        List<EspressoMachineRecipe> recipesInfusing = rm.getAllRecipesFor(EspressoMachineRecipe.Type.INSTANCE);
        registration.addRecipes(ESPRESSO_TYPE, recipesInfusing);
        // Etc.
//        // Espresso Machine
//        List<EspressoMachineRecipe> recipesInfusing = rm.getAllRecipesFor(EspressoMachineRecipe.Type.INSTANCE);
//        registration.addRecipes(ESPRESSO_TYPE, recipesInfusing);
    }
}
