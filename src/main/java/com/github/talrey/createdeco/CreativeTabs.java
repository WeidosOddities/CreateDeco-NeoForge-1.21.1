package com.github.talrey.createdeco;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTabs {
  public static final String PROPS_KEY = "props_tab";
  public static final String BRICKS_KEY = "bricks_tab";
    private static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateDecoMod.MOD_ID);

    private static final DeferredHolder<CreativeModeTab, CreativeModeTab> PROPS = TABS.register(
            CreativeTabs.PROPS_KEY, ()-> group(
                    CreativeTabs.PROPS_KEY, ()-> BlockRegistry.GREEN_CAGE_LAMPS.get("Brass").asStack()
            )
    );

    private static final DeferredHolder<CreativeModeTab, CreativeModeTab> BRICKS = TABS.register(
            CreativeTabs.BRICKS_KEY, ()-> group(
                    CreativeTabs.BRICKS_KEY, ()-> BlockRegistry.BRICKS.get(
                            DyeColor.LIGHT_BLUE
                    ).get("blue_bricks").asStack()
            )
    );

    public static void register (IEventBus eventBus) {
        TABS.register(eventBus);
    }


    public static CreativeModeTab props () {
        return PROPS.get();
    }

    private static CreativeModeTab group (String name, Supplier<ItemStack> item) {
        CreativeModeTab tab = CreativeModeTab.builder()
                .icon(item)
                .title(Component.translatableWithFallback(
                        "itemGroup." + CreateDecoMod.MOD_ID + "." + name, "Create Deco Props"
                ))
                .build();
        return tab;
    }

  public static CreativeModeTab bricks () { throw new AssertionError(); }
}
