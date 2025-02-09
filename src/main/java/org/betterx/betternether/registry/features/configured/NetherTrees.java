package org.betterx.betternether.registry.features.configured;

import org.betterx.bclib.api.v2.levelgen.features.config.PillarFeatureConfig;
import org.betterx.bclib.api.v2.levelgen.features.config.TemplateFeatureConfig;
import org.betterx.bclib.api.v2.levelgen.features.features.TemplateFeature;
import org.betterx.bclib.api.v2.levelgen.structures.StructurePlacementType;
import org.betterx.bclib.api.v3.levelgen.features.BCLConfigureFeature;
import org.betterx.bclib.api.v3.levelgen.features.BCLFeatureBuilder;
import org.betterx.betternether.BN;
import org.betterx.betternether.registry.NetherBlocks;
import org.betterx.betternether.registry.features.NetherFeatures;
import org.betterx.betternether.world.features.MushroomFirFeature;
import org.betterx.betternether.world.features.configs.NaturalTreeConfiguration;

import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class NetherTrees {
    public static final BCLConfigureFeature<TemplateFeature<TemplateFeatureConfig>, TemplateFeatureConfig> CRIMSON_GLOWING_TREE = BCLFeatureBuilder
            .startWithTemplates(BN.id("tree_crimson_glowing"))
            .add(BN.id("trees/crimson_glow_tree_01"), 0, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_glow_tree_02"), 0, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_glow_tree_03"), 0, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_glow_tree_04"), 0, StructurePlacementType.FLOOR, 1.0f)
            .buildAndRegister();


    public static final BCLConfigureFeature<TemplateFeature<TemplateFeatureConfig>, TemplateFeatureConfig> CRIMSON_PINE = BCLFeatureBuilder
            .startWithTemplates(BN.id("tree_crimson_pine"))
            .add(BN.id("trees/crimson_pine_01"), -1, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_pine_02"), -1, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_pine_03"), -1, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_pine_04"), 0, StructurePlacementType.FLOOR, 1.0f)
            .add(BN.id("trees/crimson_pine_05"), 0, StructurePlacementType.FLOOR, 1.0f)
            .buildAndRegister();

    public static final BCLConfigureFeature<TemplateFeature<TemplateFeatureConfig>, TemplateFeatureConfig> RUBEUS_TREE = BCLFeatureBuilder
            .start(BN.id("tree_rubeus"), NetherFeatures.RUBEUS_TREE)
            .configuration(NaturalTreeConfiguration.natural())
            .buildAndRegister();

    public static final BCLConfigureFeature<MushroomFirFeature, NoneFeatureConfiguration> MUSHROOM_FIR = BCLFeatureBuilder
            .start(BN.id("tree_mushroom_fir"), NetherFeatures.MUSHROOM_FIR)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_STALAGNATE = BCLFeatureBuilder
            .startPillar(BN.id("temp_stalagnate"), PillarFeatureConfig.KnownTransformers.TRIPLE_SHAPE_FILL)
            .direction(Direction.UP)
            .blockState(NetherBlocks.MAT_STALAGNATE.getTrunk())
            .minHeight(3)
            .maxHeight(64)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_stalagnate"))
            .tries(30)
            .spreadXZ(6)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_GIANT_MOLD = BCLFeatureBuilder
            .startColumn(BN.id("temp_giant_mold"))
            .direction(Direction.UP)
            .addTripleShape(NetherBlocks.GIANT_MOLD.defaultBlockState(), ClampedNormalInt.of(5, 1.3f, 3, 8))
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_giant_mold"))
            .tries(30)
            .spreadXZ(6)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_BIG_RED_MUSHROOM = BCLFeatureBuilder
            .startColumn(BN.id("temp_big_red_mushroom"))
            .direction(Direction.UP)
            .addTripleShape(NetherBlocks.RED_LARGE_MUSHROOM.defaultBlockState(), ClampedNormalInt.of(6, 2.1f, 3, 9))
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_big_red_mushroom"))
            .tries(30)
            .spreadXZ(6)
            .buildAndRegister();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> PATCH_BIG_BROWN_MUSHROOM = BCLFeatureBuilder
            .start(BN.id("temp_big_brown_mushroom"), NetherFeatures.BIG_BROWN_MUSHROOM)
            .inlinePlace()
            .isEmptyAndOnNetherGround()
            .inRandomPatch(BN.id("patch_big_brown_mushroom"))
            .likeDefaultNetherVegetation()
            .tries(30)
            .spreadXZ(7)
            .buildAndRegister();

    public static void ensureStaticInitialization() {
    }
}
