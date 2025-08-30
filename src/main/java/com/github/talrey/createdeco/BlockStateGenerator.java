package com.github.talrey.createdeco;

import com.github.talrey.createdeco.blocks.DecalBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedPillarBlock;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;

import java.util.Locale;

public class BlockStateGenerator {
    public static void bar (
            String base, String post, ResourceLocation barTexture, ResourceLocation postTexture,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void barItem (
            String base, String suf, ResourceLocation bartex,
            DataGenContext<Item, ?> ctx, RegistrateItemModelProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.getExistingFile(prov.modLoc(ctx.getName())));
    }

    public static void fence (
            String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void cageLamp (
            ResourceLocation cage, ResourceLocation lampOn, ResourceLocation lampOff,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        prov.getVariantBuilder(ctx.get()).forAllStates(state -> {
            return ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                    ctx.getName() + (state.getValue(BlockStateProperties.LIT) ? "" : "_off")
            ))).build();
        });
    }

    public static void catwalk (
            CreateRegistrate reg, String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void catwalkItem (
            String metal, DataGenContext<Item, ?> ctx, RegistrateItemModelProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.getExistingFile(prov.modLoc(ctx.getName())));
    }

    public static void catwalkStair (
            String texture, DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void catwalkRailing (
            CreateRegistrate reg, String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void catwalkRailingItem (
            CreateRegistrate reg, String metal,
            DataGenContext<Item, ?> ctx, RegistrateItemModelProvider prov
    ) {
        prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + ctx.getName()));
    }

    public static void door (
            CreateRegistrate reg, String metal, boolean locked,
            DataGenContext<Block, DoorBlock> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void doorItem (
            CreateRegistrate reg, String metal,
            DataGenContext<Item, ?> ctx, RegistrateItemModelProvider prov
    ) {
        prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + ctx.getName()));
    }

    public static void hull (
            CreateRegistrate reg, String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void support (
            CreateRegistrate reg, String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }


    public static void supportWedge (
            CreateRegistrate reg, String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void trapdoorItem (
            CreateRegistrate reg, String metal,
            DataGenContext<Item, ?> ctx, RegistrateItemModelProvider prov
    ) {
        prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + ctx.getName()));
    }

    public static void placard (
            CreateRegistrate reg, DyeColor color,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void shippingContainer (
            CreateRegistrate reg, DyeColor color,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void coinstackBlock (
            ResourceLocation side, ResourceLocation bottom, ResourceLocation top,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void brick (
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov, String color
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void brickStair (
            DataGenContext<Block, StairBlock> ctx, RegistrateBlockstateProvider prov, String color
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void brickSlab (
            DataGenContext<Block, SlabBlock> ctx, RegistrateBlockstateProvider prov, String color
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void brickWall(
            DataGenContext<Block, WallBlock> ctx, RegistrateBlockstateProvider prov, String color
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void window (
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov,
            NonNullFunction<String, ResourceLocation> sideTexture,
            NonNullFunction<String, ResourceLocation> endTexture
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static NonNullBiConsumer<DataGenContext<Block, ConnectedGlassPaneBlock>, RegistrateBlockstateProvider> windowPane(
            String CGPparents, String prefix, ResourceLocation sideTexture, ResourceLocation topTexture
    ) {
        return (ctx, prov) -> BlockStateGenerator.window(
                ctx, prov,
                s -> ResourceLocation.fromNamespaceAndPath(sideTexture.getNamespace(), sideTexture.getPath().replace("{prefix}", prefix)),
                s -> ResourceLocation.fromNamespaceAndPath(topTexture.getNamespace(), topTexture.getPath().replace("{prefix}", prefix))
        );
    }

    public static void ladder (
            DataGenContext<Block,?> ctx, RegistrateBlockstateProvider prov, String regName
    ) {
        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(prov.modLoc(
                ctx.getName()
        )));
    }

    public static void decal(
            CreateRegistrate reg, String type,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {
        String texture = reg.getModid() + ":block/palettes/decals/decal_" + type;

        prov.getVariantBuilder(ctx.get()).forAllStates(state -> {
            int y = 69;
            int x = 69;
            Direction direction = state.getValue(DecalBlock.FACING);
            switch (state.getValue(DecalBlock.FACE)) {
                case FLOOR -> {
                    switch (direction) {
                        case EAST -> {
                            y = 90;
                            x = 90;
                        }
                        case WEST -> {
                            y = 270;
                            x = 90;
                        }
                        case SOUTH -> {
                            y = 180;
                            x = 90;
                        }
                        case NORTH -> {
                            y = 0;
                            x = 90;
                        }
                        case UP, DOWN -> {
                            y = 0;
                            x = 0;
                        }
                    }
                }
                case WALL -> {
                    switch (direction) {
                        case EAST -> {
                            y = 270;
                            x = 0;
                        }
                        case WEST -> {
                            y = 90;
                            x = 0;
                        }
                        case SOUTH -> {
                            y = 0;
                            x = 0;
                        }
                        case NORTH, UP, DOWN -> {
                            y = 180;
                            x = 0;
                        }
                    }
                }
                case CEILING -> {
                    switch (direction) {
                        case EAST -> {
                            y = 90;
                            x = 270;
                        }
                        case WEST -> {
                            y = 270;
                            x = 270;
                        }
                        case SOUTH -> {
                            y = 180;
                            x = 270;
                        }
                        case NORTH -> {
                            y = 0;
                            x = 270;
                        }
                        case UP, DOWN -> {
                            y = 0;
                            x = 0;
                        }
                    }
                }
            }

            return ConfiguredModel.builder().modelFile(prov.models()
                    .withExistingParent(ctx.getName(), prov.modLoc("block/decal"))
                    .texture("0", reg.getModid() + ":block/palettes/decals/decal_back")
                    .texture("1", texture)
                    .texture("particle", texture)
            ).rotationX(x).rotationY(y).build();
        });
    }

    public static void brickWallItem(
            DataGenContext<Item, BlockItem> ctx, RegistrateItemModelProvider prov, String color
    ) {
        String block = ctx.getName().replaceAll("_wall", "s");
        ResourceLocation texture = prov.modLoc(
                "block/palettes/bricks/" + color + "/" + block
        );
        prov.wallInventory(ctx.getName(), texture);
    }

    public static void facade(
            CreateRegistrate reg, String metal1,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov
    ) {

        var metal = metal1.toLowerCase(Locale.ROOT).replaceAll(" ", "_");
        ResourceLocation catwalkTexture = prov.modLoc("block/palettes/catwalks/" + metal + "_catwalk");

        BlockModelBuilder facade = prov.models()
                .withExistingParent(metal + "_facade", prov.modLoc("block/facade"))
                .texture("2", catwalkTexture)
                .texture("particle", catwalkTexture);

        prov.getMultipartBuilder(ctx.get()).part().modelFile(facade).rotationY(0).addModel()
                .condition(BlockStateProperties.NORTH, true).end();
        prov.getMultipartBuilder(ctx.get()).part().modelFile(facade).rotationY(180).addModel()
                .condition(BlockStateProperties.SOUTH, true).end();
        prov.getMultipartBuilder(ctx.get()).part().modelFile(facade).rotationY(90).addModel()
                .condition(BlockStateProperties.EAST, true).end();
        prov.getMultipartBuilder(ctx.get()).part().modelFile(facade).rotationY(-90).addModel()
                .condition(BlockStateProperties.WEST, true).end();
        prov.getMultipartBuilder(ctx.get()).part().modelFile(facade).rotationX(-90).addModel()
                .condition(BlockStateProperties.UP, true).end();
        prov.getMultipartBuilder(ctx.get()).part().modelFile(facade).rotationX(90).addModel()
                .condition(BlockStateProperties.DOWN, true).end();

    }

    public static void sheetMetal(
            String metal,
            DataGenContext<Block, ?> ctx, RegistrateBlockstateProvider prov) {
        var name = metal.toLowerCase().replace(" ", "_") + "_sheet_metal";
        var side = CreateDecoMod.asResource("block/palettes/sheet_metal/" + name);
        var end = CreateDecoMod.asResource("block/palettes/sheet_metal/" + name + "_top");
        prov.getVariantBuilder(ctx.getEntry())
                .forAllStatesExcept(state -> {
                            Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                            if (axis == Direction.Axis.Y)
                                return ConfiguredModel.builder()
                                        .modelFile(prov.models()
                                                .cubeColumn(ctx.getName(), side, end))
                                        .uvLock(false)
                                        .build();
                            return ConfiguredModel.builder()
                                    .modelFile(prov.models()
                                            .cubeColumnHorizontal(ctx.getName() + "_horizontal", side, end))
                                    .uvLock(false)
                                    .rotationX(90)
                                    .rotationY(axis == Direction.Axis.X ? 90 : 0)
                                    .build();
                        }, BlockStateProperties.WATERLOGGED, ConnectedPillarBlock.NORTH, ConnectedPillarBlock.SOUTH,
                        ConnectedPillarBlock.EAST, ConnectedPillarBlock.WEST);
    }
}
