package com.github.talrey.createdeco;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CreateDecoMod.MOD_ID)
public class CreateDecoMod {
    public static final String MOD_ID = "createdeco";
    public static final String MOD_NAME = "Create Deco";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public CreateDecoMod(IEventBus eventBus) {
        onCtor(eventBus);
    }

    public static void onCtor(IEventBus eventBus) {
        REGISTRATE.registerEventListeners(eventBus);
        CreativeTabs.register(eventBus);
        ItemRegistry.init();
        BlockRegistry.init();
        eventBus.addListener(CreateDecoMod::init);
    }

    public static void init(final FMLCommonSetupEvent event) {
        LOGGER.info("{} initializing...", MOD_NAME);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
