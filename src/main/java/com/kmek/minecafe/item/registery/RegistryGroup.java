package com.kmek.minecafe.item.registery;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RegistryGroup<E extends Enum<E>, T> {
//    protected DeferredRegister<T> REG;
    protected List<E> values;
    protected final Map<E, T> group = new HashMap<>();

    public RegistryGroup(DeferredRegister<T> register, List<E> asList) {
//        this.REG = register;
        this.values = asList;
    }

    public void skipInner(E toSkip) {
        this.values = values.stream().filter(val -> val != toSkip).toList();
    }

    public void overrideInner(E toOverride, T toSet) {
        skipInner(toOverride);
        group.put(toOverride, toSet);
    }

    public Map<E, T> build() {
        values.forEach(val -> buildItem(val));
        return group;
    }

    protected abstract void buildItem(E val);
}
