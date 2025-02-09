package org.betterx.betternether.registry.features.configured;

import org.betterx.bclib.api.v3.levelgen.features.BCLConfigureFeature;
import org.betterx.bclib.api.v3.levelgen.features.BCLFeatureBuilder;
import org.betterx.bclib.api.v3.levelgen.features.BlockPredicates;
import org.betterx.betternether.BN;
import org.betterx.betternether.blocks.*;
import org.betterx.betternether.registry.NetherBlocks;
import org.betterx.betternether.registry.features.NetherFeatures;

import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.levelgen.feature.NetherForestVegetationFeature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class NetherVegetation {
    public static final BCLConfigureFeature<SimpleBlockFeature, SimpleBlockConfiguration> DEBUG = BCLFeatureBuilder
            .start(BN.id("debug"), Blocks.YELLOW_CONCRETE)
            .buildAndRegister();

    public static final BCLConfigureFeature<NetherForestVegetationFeature, NetherForestVegetationConfig> VEGETATION_BONE_REEF = BCLFeatureBuilder
            .startNetherVegetation(BN.id("vegetation_bone_reef"))
            .add(NetherBlocks.BONE_GRASS, 180)
            .addAllStatesFor(BlockFeatherFern.AGE, NetherBlocks.FEATHER_FERN, 20)
            .buildAndRegister();

    public static final BCLConfigureFeature<NetherForestVegetationFeature, NetherForestVegetationConfig> VEGETATION_SULFURIC_BONE_REEF = BCLFeatureBuilder
            .startNetherVegetation(BN.id("vegetation_sulfuric_bone_reef"))
            .add(NetherBlocks.SEPIA_BONE_GRASS, 180)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> VEGETATION_MAGMA_LAND = BCLFeatureBuilder
            .startWeighted(BN.id("temp_vegetation_magma_land"))
            .add(NetherBlocks.GEYSER, 40)
            .addAllStatesFor(BlockMagmaFlower.AGE, NetherBlocks.MAGMA_FLOWER, 120)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("vegetation_magma_land"))
            .buildAndRegister();

    public static final BCLConfigureFeature<NetherForestVegetationFeature, NetherForestVegetationConfig> VEGETATION_CRIMSON_GLOWING_WOODS = BCLFeatureBuilder
            .startNetherVegetation(BN.id("vegetation_crimson_glowing_woods"))
            .add(Blocks.CRIMSON_ROOTS, 120)
            .add(Blocks.CRIMSON_FUNGUS, 80)
            .add(NetherBlocks.MAT_WART.getSeed(), 80)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> VEGETATION_GRASSLANDS = BCLFeatureBuilder
            .startWeighted(BN.id("temp_vegetation_nether_grasslands"))
            .addAllStatesFor(BlockMagmaFlower.AGE, NetherBlocks.MAGMA_FLOWER, 30)
            .addAllStatesFor(BlockInkBush.AGE, NetherBlocks.INK_BUSH, 80)
            .addAllStatesFor(NetherWartBlock.AGE, Blocks.NETHER_WART, 40)
            .add(NetherBlocks.NETHER_GRASS, 200)
            .addAllStatesFor(BlockBlackApple.AGE, NetherBlocks.BLACK_APPLE, 50)
            .add(NetherBlocks.MAT_WART.getSeed(), 60)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("vegetation_nether_grasslands"))
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> VEGETATION_GRAVEL_DESERT = BCLFeatureBuilder
            .startWeighted(BN.id("temp_vegetation_nether_gravel_desert"))
            .addAllStatesFor(BlockAgave.AGE, NetherBlocks.AGAVE, 80)
            .addAllStatesFor(BlockBarrelCactus.AGE, NetherBlocks.BARREL_CACTUS, 20)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("vegetation_nether_gravel_desert"))
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> VEGETATION_JUNGLE = BCLFeatureBuilder
            .startWeighted(BN.id("temp_vegetation_nether_jungle"))
            .addAllStatesFor(BlockEggPlant.AGE, NetherBlocks.EGG_PLANT, 80)
            .add(NetherBlocks.JUNGLE_PLANT, 80)
            .addAllStatesFor(BlockMagmaFlower.AGE, NetherBlocks.MAGMA_FLOWER, 30)
            .addAllStatesFor(BlockFeatherFern.AGE, NetherBlocks.FEATHER_FERN, 20)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("vegetation_nether_jungle"))
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> VEGETATION_MUSHROOM_FORREST = BCLFeatureBuilder
            .startWeighted(BN.id("temp_vegetation_mushroom_forrest"))
            .add(Blocks.RED_MUSHROOM, 60)
            .add(Blocks.CRIMSON_FUNGUS, 80)
            .add(Blocks.WARPED_FUNGUS, 80)
            .add(Blocks.BROWN_MUSHROOM, 60)
            .addAllStatesFor(BlockCommonPlant.AGE, NetherBlocks.ORANGE_MUSHROOM, 100)
            .add(NetherBlocks.RED_MOLD, 120)
            .add(NetherBlocks.GRAY_MOLD, 120)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("vegetation_mushroom_forrest"))
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_JELLYFISH_MUSHROOM = BCLFeatureBuilder
            .start(BN.id("temp_jellyfish_mushroom"), NetherFeatures.JELLYFISH_MUSHROOM)
            .inlinePlace()
            .findSolidFloor(4)
            .isEmptyAndOnNylium()
            .inRandomPatch(BN.id("patch_jellyfish_mushroom"))
            .tries(6)
            .spreadXZ(6)
            .spreadY(4)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_BLACK_BUSH = BCLFeatureBuilder
            .start(BN.id("temp_black_bush"), NetherBlocks.BLACK_BUSH)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_back_bush"))
            .likeDefaultNetherVegetation()
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_WART_BUSH = BCLFeatureBuilder
            .start(BN.id("temp_wart_bush"), NetherFeatures.WART_BUSH)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_wart_bush"))
            .likeDefaultNetherVegetation()
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_RUBEUS_BUSH = BCLFeatureBuilder
            .start(BN.id("temp_rubeus_bush"), NetherFeatures.RUBEUS_BUSH)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_rubeus_bush"))
            .likeDefaultNetherVegetation()
            .buildAndRegister();
    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_WALL_MUSHROOM_RED_WITH_MOSS = BCLFeatureBuilder
            .startFacing(BN.id("temp_wall_mushroom_red_with_moss"))
            .add(NetherBlocks.WALL_MUSHROOM_RED, 40)
            .add(NetherBlocks.WALL_MOSS, 20)
            .allHorizontal()
            .inlinePlace()
            .inRandomPatch(BN.id("patch_wall_mushroom_red_with_moss"))
            .tries(120)
            .spreadXZ(4)
            .spreadY(7)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_WALL_MUSHROOMS_WITH_MOSS = BCLFeatureBuilder
            .startFacing(BN.id("temp_wall_mushrooms_with_moss"))
            .add(NetherBlocks.WALL_MUSHROOM_RED, 40)
            .add(NetherBlocks.WALL_MUSHROOM_BROWN, 35)
            .add(NetherBlocks.WALL_MOSS, 20)
            .allHorizontal()
            .inlinePlace()
            .isEmpty()
            .inRandomPatch(BN.id("patch_wall_mushrooms_with_moss"))
            .tries(120)
            .spreadXZ(4)
            .spreadY(7)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_WALL_MUSHROOMS = BCLFeatureBuilder
            .startFacing(BN.id("temp_wall_mushrooms"))
            .add(NetherBlocks.WALL_MUSHROOM_RED, 20)
            .add(NetherBlocks.WALL_MUSHROOM_BROWN, 15)
            .allHorizontal()
            .inlinePlace()
            .isEmpty()
            .inRandomPatch(BN.id("patch_wall_mushrooms"))
            .tries(120)
            .spreadXZ(4)
            .spreadY(7)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_WALL_JUNGLE = BCLFeatureBuilder
            .startFacing(BN.id("temp_wall_jungle"))
            .add(NetherBlocks.WALL_MUSHROOM_RED, 20)
            .add(NetherBlocks.WALL_MUSHROOM_BROWN, 15)
            .add(NetherBlocks.JUNGLE_MOSS, 40)
            .add(NetherBlocks.WALL_MOSS, 40)
            .allHorizontal()
            .inlinePlace()
            .isEmpty()
            .inRandomPatch(BN.id("patch_wall_jungle"))
            .tries(120)
            .spreadXZ(4)
            .spreadY(7)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_WALL_LUCIS = BCLFeatureBuilder
            .start(BN.id("temp_lucis"), NetherFeatures.LUCIS)
            .inlinePlace()
            .isEmpty()
            .inRandomPatch(BN.id("patch_lucis"))
            .tries(120)
            .spreadXZ(12)
            .spreadY(10)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_NETHER_REED = BCLFeatureBuilder
            .startColumn(BN.id("temp_patch_nether_reed"))
            .direction(Direction.UP)
            .prioritizeTip()
            .addTopShape(NetherBlocks.MAT_REED.getStem().defaultBlockState(), BiasedToBottomInt.of(0, 3))
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .belowIsNextTo(BlockPredicates.ONLY_LAVA)
            .inRandomPatch(BN.id("patch_nether_reed"))
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_NETHER_CACTUS = BCLFeatureBuilder
            .startColumn(BN.id("temp_patch_nether_cactus"))
            .direction(Direction.UP)
            .prioritizeTip()
            .addTopShape(NetherBlocks.NETHER_CACTUS.defaultBlockState(), BiasedToBottomInt.of(1, 4))
            .inlinePlace()
            .isEmptyAndOn(BlockPredicates.ONLY_GRAVEL_OR_SAND)
            .inRandomPatch(BN.id("patch_nether_cactus"))
            .tries(16)
            .buildAndRegister();

    public static void ensureStaticInitialization() {
    }
}
