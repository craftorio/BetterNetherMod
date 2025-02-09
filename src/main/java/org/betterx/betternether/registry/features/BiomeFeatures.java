package org.betterx.betternether.registry.features;

import org.betterx.bclib.api.v2.levelgen.features.BCLFeature;
import org.betterx.bclib.api.v2.levelgen.features.BCLFeatureBuilder;
import org.betterx.bclib.api.v2.levelgen.features.config.PlaceFacingBlockConfig;
import org.betterx.bclib.api.v2.levelgen.features.placement.FindSolidInDirection;
import org.betterx.bclib.api.v2.levelgen.features.placement.OnEveryLayer;
import org.betterx.bclib.api.v2.levelgen.features.placement.UnderEveryLayer;
import org.betterx.betternether.BetterNether;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class BiomeFeatures {

    public static final List<PlacementModifier> defaultCeilModifiers = List.of(
            CountPlacement.of(16),
            InSquarePlacement.spread(),
            UnderEveryLayer.min4(),
            BiomeFilter.biome()
    );

    public static final List<PlacementModifier> defaultDenseCeilModifiers = List.of(
            CountPlacement.of(48),
            InSquarePlacement.spread(),
            UnderEveryLayer.min4(),
            BiomeFilter.biome()
    );
    public static final List<PlacementModifier> defaultFloorModifiers = List.of(
            CountPlacement.of(16),
            InSquarePlacement.spread(),
            OnEveryLayer.min4(),
            BiomeFilter.biome()
    );

    public static final List<PlacementModifier> defaultDenseFloorModifiers = List.of(
            CountPlacement.of(64),
            InSquarePlacement.spread(),
            OnEveryLayer.min4(),
            BiomeFilter.biome()
    );

    public static final List<PlacementModifier> defaultWallModifiers = List.of(
            CountPlacement.of(128),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_4_4,
            new FindSolidInDirection(PlaceFacingBlockConfig.HORIZONTAL, 12, false),
            BiomeFilter.biome()
    );

    public static final BCLFeature SOUL_PLAIN_FLOOR = floorFromWeighted("soul_plain", List.of(
            new WeightedPlacedFeature(VineLikeFeatures.SOUL_VEIN.getPlacedFeature(), 0.3f),
            new WeightedPlacedFeature(FloorFeatures.SOUL_GRASS_PATCH.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(FloorFeatures.BLACK_BUSH_PATCH.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_BASALT_CLUSTER.getPlacedFeature(), 0.01f)
    ), 0);

    public static final BCLFeature SOUL_PLAIN_CEIL = ceilFromChanced("soul_plain", List.of(
            new WeightedPlacedFeature(VineLikeFeatures.STALACTITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.01f)
    ), 0);

    public static final BCLFeature CRIMSON_GLOWING_WOODS_WALL = wallFromWeighted("crimson_glowing_woods", List.of(
            new WeightedPlacedFeature(WallFeatures.WALL_MOSS.getPlacedFeature(), 0.4f),
            new WeightedPlacedFeature(WallFeatures.WALL_MUSHROOM_RED.getPlacedFeature(), 0.6f)
    ), 1);


    public static final BCLFeature NETHER_GRASSLANDS_WALL = wallFromWeighted("nether_ggrasslands", List.of(
            new WeightedPlacedFeature(WallFeatures.WALL_MOSS.getPlacedFeature(), 0.5f),
            new WeightedPlacedFeature(WallFeatures.WALL_MUSHROOM_RED.getPlacedFeature(), 0.25f),
            new WeightedPlacedFeature(WallFeatures.WALL_MUSHROOM_BROWN.getPlacedFeature(), 0.25f)
    ), 1);

    public static final BCLFeature MUSHROOM_FORREST_EDGE_FLOOR = floorFromChanced("mushroom_forrest_edge", List.of(
            new WeightedPlacedFeature(FloorFeatures.ORANGE_MUSHROOM.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(FloorFeatures.VANILLA_MUSHROOM.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(FloorFeatures.RED_MOLD.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(FloorFeatures.GRAY_MOLD.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.01f)
    ), 0);

    public static final BCLFeature POOR_GRASSLAND_FLOOR = floorFromChanced("poor_grassland", List.of(
            new WeightedPlacedFeature(FloorFeatures.NETHER_WART.getPlacedFeature(), 0.005f),
            new WeightedPlacedFeature(VineLikeFeatures.SMOKER.getPlacedFeature(), 0.005f),
            new WeightedPlacedFeature(FloorFeatures.MAGMA_FLOWER.getPlacedFeature(), 0.005f),
            new WeightedPlacedFeature(FloorFeatures.BLACK_BUSH_PATCH.getPlacedFeature(), 0.001f),
            new WeightedPlacedFeature(VineLikeFeatures.NETHER_REED.getPlacedFeature(), 0.002f),
            new WeightedPlacedFeature(FloorFeatures.INK_BUSH.getPlacedFeature(), 0.001f),
            new WeightedPlacedFeature(FloorFeatures.BLACK_APPLE.getPlacedFeature(), 0.001f),
            new WeightedPlacedFeature(FloorFeatures.WART_SEED_PATCH.getPlacedFeature(), 0.002f),
            new WeightedPlacedFeature(FloorFeatures.NETHER_GRASS_PATCH.getPlacedFeature(), 0.04f)
    ), 0);


    public static final BCLFeature NETHER_SWAMPLAND_FLOOR = denseFloorFromWeighted("nether_swampland", List.of(
            new WeightedPlacedFeature(TreeFeatures.WILLOW.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(FloorFeatures.WILLOW_BUSH_PATCH.getPlacedFeature(), 0.10f),
            new WeightedPlacedFeature(FloorFeatures.JELLYFISH_MUSHROOM.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(FloorFeatures.SWAMP_GRASS.getPlacedFeature(), 0.4f),
            new WeightedPlacedFeature(VineLikeFeatures.SMOKER.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(VineLikeFeatures.SOUL_VEIN.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(FloorFeatures.FEATHER_FERN_PATCH.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(FloorFeatures.BLACK_BUSH_PATCH.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(VineLikeFeatures.NETHER_REED.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 1);
    public static final BCLFeature NETHER_SWAMPLAND_WALL = NETHER_GRASSLANDS_WALL;

    public static final BCLFeature NETHER_SWAMPLAND_CEIL = ceilFromChanced("nether_swampland", List.of(
            new WeightedPlacedFeature(VineLikeFeatures.BLACK_VINE.getPlacedFeature(), 0.4f),
            new WeightedPlacedFeature(VineLikeFeatures.BLOOMING_VINE.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(VineLikeFeatures.STALACTITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 0);

    public static final BCLFeature NETHER_WART_FORREST_FLOOR = denseFloorFromWeighted("nether_wart_forrest", List.of(
            new WeightedPlacedFeature(FloorFeatures.BLACK_BUSH_PATCH.getPlacedFeature(), 0.01f),
            new WeightedPlacedFeature(TreeFeatures.WART_DEADWOOD.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(TreeFeatures.WART.getPlacedFeature(), 0.3f),
            new WeightedPlacedFeature(FloorFeatures.NETHER_WART.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(FloorFeatures.WART_SEED_PATCH.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(TreeFeatures.SOUL_LILY.getPlacedFeature(), 0.4f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 0);

    public static final BCLFeature NETHER_WART_FORREST_CEIL = SOUL_PLAIN_CEIL;

    public static final BCLFeature NETHER_WART_FORREST_EDGE_FLOOR = floorFromWeighted(
            "nether_wart_forrest",
            List.of(
                    new WeightedPlacedFeature(FloorFeatures.BLACK_BUSH_PATCH.getPlacedFeature(), 0.01f),
                    new WeightedPlacedFeature(FloorFeatures.NETHER_WART.getPlacedFeature(), 0.2f),
                    new WeightedPlacedFeature(FloorFeatures.WART_SEED_PATCH.getPlacedFeature(), 0.05f),
                    new WeightedPlacedFeature(FloorFeatures.SOUL_GRASS_PATCH.getPlacedFeature(), 0.1f),
                    new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
            ),
            0
    );

    public static final BCLFeature OLD_FUNGIWOODS_FLOOR = denseFloorFromWeighted("old_fungiwoods", List.of(
            new WeightedPlacedFeature(TreeFeatures.OLD_RED_MUSHROOM_CLUSTER.getPlacedFeature(), 0.12f),
            new WeightedPlacedFeature(TreeFeatures.OLD_BROWN_MUSHROOM_CLUSTER.getPlacedFeature(), 0.12f),
            new WeightedPlacedFeature(TreeFeatures.BIG_RED_MUSHROOM_CLUSTER.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(TreeFeatures.BIG_BROWN_MUSHROOM_CLUSTER.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(FloorFeatures.VANILLA_MUSHROOM.getPlacedFeature(), 0.5f),
            new WeightedPlacedFeature(FloorFeatures.RED_MOLD.getPlacedFeature(), 0.9f),
            new WeightedPlacedFeature(FloorFeatures.GRAY_MOLD.getPlacedFeature(), 0.9f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 0);

    public static final BCLFeature OLD_FUNGIWOODS_CEIL = SOUL_PLAIN_CEIL;

    public static final BCLFeature OLD_FUNGIWOODS_WALL = CRIMSON_GLOWING_WOODS_WALL;

    public static final BCLFeature OLD_SWAMPLAND_SCULK = BCLFeatureBuilder
            .start(BetterNether.makeID("old_swampland_sculk"), Feature.RANDOM_SELECTOR)
            .decoration(GenerationStep.Decoration.LOCAL_MODIFICATIONS)
            .count(32)
            .squarePlacement()
            .modifier(OnEveryLayer.min4())
            .onlyInBiome()
            .buildAndRegister(new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(FloorFeatures.SCULK_CATALYST.getPlacedFeature(), 0.5f),
                    new WeightedPlacedFeature(FloorFeatures.SCULK_SHRIEKER.getPlacedFeature(), 0.01f)
            ), FloorFeatures.SCULK_CATALYST.getPlacedFeature()));

    public static final BCLFeature OLD_SWAMPLAND_FLOOR = denseFloorFromWeighted("old_swampland", List.of(
            new WeightedPlacedFeature(TreeFeatures.OLD_WILLOW.getPlacedFeature(), 0.02f),
            new WeightedPlacedFeature(TreeFeatures.WILLOW.getPlacedFeature(), 0.02f),
            new WeightedPlacedFeature(FloorFeatures.WILLOW_BUSH_PATCH.getPlacedFeature(), 0.10f),
            new WeightedPlacedFeature(FloorFeatures.JELLYFISH_MUSHROOM.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(FloorFeatures.SWAMP_GRASS.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(VineLikeFeatures.SMOKER.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(VineLikeFeatures.SOUL_VEIN.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(FloorFeatures.FEATHER_FERN_PATCH.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(FloorFeatures.BLACK_BUSH_PATCH.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(FloorFeatures.SCULK_VEIN.getPlacedFeature(), 0.3f),
            new WeightedPlacedFeature(VineLikeFeatures.NETHER_REED.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 1);
    public static final BCLFeature OLD_SWAMPLAND_WALL = NETHER_GRASSLANDS_WALL;

    public static final BCLFeature OLD_SWAMPLAND_CEIL = NETHER_SWAMPLAND_CEIL;

    public static final BCLFeature OLD_WARPED_WOOD_FLOOR = denseFloorFromWeighted("old_warped_wood", List.of(
            new WeightedPlacedFeature(TreeFeatures.BIG_WARPED_TREE_CLUSTER.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(FloorFeatures.VANILLA_WARPED_FUNGUS.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(FloorFeatures.VANILLA_WARPED_ROOTS.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 0);

    public static final BCLFeature OLD_WARPED_WOOD_CEIL = ceilFromChanced("old_warped_wood", List.of(
            new WeightedPlacedFeature(VineLikeFeatures.BLACK_VINE.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(VineLikeFeatures.TWISTED_VINES.getPlacedFeature(), 0.2f),
            new WeightedPlacedFeature(VineLikeFeatures.STALACTITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 0);

    public static final BCLFeature UPSIDE_DOWN_FORREST_FLOOR = denseFloorFromWeighted("upside_down_forrest", List.of(
            new WeightedPlacedFeature(FloorFeatures.NETHER_SAKURA_BUSH_PATCH.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(FloorFeatures.MOSS_COVER.getPlacedFeature(), 0.6f),
            new WeightedPlacedFeature(FloorFeatures.FORREST_LITTER.getPlacedFeature(), 0.01f),
            new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
    ), 0);

    public static final BCLFeature UPSIDE_DOWN_FORREST_WALL = wallFromWeighted("upside_down_forrest", List.of(
            new WeightedPlacedFeature(WallFeatures.JUNGLE_MOSS_COVER.getPlacedFeature(), 0.4f),
            new WeightedPlacedFeature(WallFeatures.WALL_MUSHROOM_BROWN.getPlacedFeature(), 0.4f),
            new WeightedPlacedFeature(WallFeatures.WALL_MUSHROOM_RED.getPlacedFeature(), 0.4f)
    ), 0);

    public static final BCLFeature UPSIDE_DOWN_FORREST_CEIL = ceilFromWeighted("upside_down_forrest", List.of(
            new WeightedPlacedFeature(TreeFeatures.ANCHOR_TREE.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(TreeFeatures.ANCHOR_TREE_BRANCH.getPlacedFeature(), 0.05f),
            new WeightedPlacedFeature(TreeFeatures.ANCHOR_TREE_ROOT.getPlacedFeature(), 0.03f),
            new WeightedPlacedFeature(TreeFeatures.NETHER_SAKURA.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(VineLikeFeatures.NEON_EQUISETUM.getPlacedFeature(), 0.1f),
            new WeightedPlacedFeature(FloorFeatures.HOOK_MUSHROOM.getPlacedFeature(), 0.06f),
            new WeightedPlacedFeature(VineLikeFeatures.WHISPERING_GOURD.getPlacedFeature(), 0.04f),
            new WeightedPlacedFeature(VineLikeFeatures.STALACTITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.01f)
    ), 0);

    public static final BCLFeature UPSIDE_DOWN_FORREST_CLEARED_FLOOR = denseFloorFromWeighted(
            "upside_down_forrest_cleared",
            List.of(
                    new WeightedPlacedFeature(FloorFeatures.MOSS_COVER.getPlacedFeature(), 0.6f),
                    new WeightedPlacedFeature(WallFeatures.JUNGLE_MOSS_COVER.getPlacedFeature(), 0.4f),
                    new WeightedPlacedFeature(FloorFeatures.FORREST_LITTER.getPlacedFeature(), 0.4f),
                    new WeightedPlacedFeature(VineLikeFeatures.STALAGMITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.05f)
            ),
            0
    );

    public static final BCLFeature UPSIDE_DOWN_FORREST_CLEARED_CEIL = denseCeilFromWeighted(
            "upside_down_forrest_cleared",
            List.of(
                    new WeightedPlacedFeature(VineLikeFeatures.NEON_EQUISETUM.getPlacedFeature(), 0.1f),
                    new WeightedPlacedFeature(FloorFeatures.HOOK_MUSHROOM.getPlacedFeature(), 0.06f),
                    new WeightedPlacedFeature(VineLikeFeatures.WHISPERING_GOURD.getPlacedFeature(), 0.04f),
                    new WeightedPlacedFeature(VineLikeFeatures.STALACTITE_NETHERRACK_CLUSTER.getPlacedFeature(), 0.01f)
            ),
            0
    );


    public static BCLFeature denseFloorFromWeighted(
            String name,
            List<WeightedPlacedFeature> features,
            int defaultIndex
    ) {
        return fromWeighted(name, features, defaultIndex, "floor", defaultDenseFloorModifiers);
    }

    public static BCLFeature floorFromWeighted(String name, List<WeightedPlacedFeature> features, int defaultIndex) {
        return fromWeighted(name, features, defaultIndex, "floor", defaultFloorModifiers);
    }

    public static BCLFeature denseCeilFromWeighted(
            String name,
            List<WeightedPlacedFeature> features,
            int defaultIndex
    ) {
        return fromWeighted(name, features, defaultIndex, "ceil", defaultDenseCeilModifiers);
    }

    public static BCLFeature ceilFromWeighted(String name, List<WeightedPlacedFeature> features, int defaultIndex) {
        return fromWeighted(name, features, defaultIndex, "ceil", defaultCeilModifiers);
    }

    public static BCLFeature wallFromWeighted(String name, List<WeightedPlacedFeature> features, int defaultIndex) {
        return fromWeighted(name, features, defaultIndex, "wall", defaultWallModifiers);
    }

    public static BCLFeature fromWeighted(
            String name,
            List<WeightedPlacedFeature> features,
            int defaultIndex,
            String postFix,
            List<PlacementModifier> modifiers
    ) {
        return BCLFeatureBuilder
                .start(BetterNether.makeID(name + "_" + postFix), BCLFeature.RANDOM_SELECTOR)
                .decoration(GenerationStep.Decoration.VEGETAL_DECORATION)
                .modifier(modifiers)
                .buildAndRegister(features.size() == 1
                        ? new RandomFeatureConfiguration(
                        List.of(),
                        features.get(0).feature
                )
                        : new RandomFeatureConfiguration(features, features.get(defaultIndex).feature));
    }

    public static BCLFeature floorFromChanced(String name, List<WeightedPlacedFeature> features, int defaultIndex) {
        return fromChanced(name, features, defaultIndex, "floor", defaultFloorModifiers);
    }

    public static BCLFeature ceilFromChanced(String name, List<WeightedPlacedFeature> features, int defaultIndex) {
        return fromChanced(name, features, defaultIndex, "ceil", defaultCeilModifiers);
    }

    public static BCLFeature wallFromChanced(String name, List<WeightedPlacedFeature> features, int defaultIndex) {
        return fromChanced(name, features, defaultIndex, "wall", defaultWallModifiers);
    }

    public static BCLFeature fromChanced(
            String name,
            List<WeightedPlacedFeature> features,
            int defaultIndex,
            String postFix,
            List<PlacementModifier> modifiers
    ) {
        return BCLFeatureBuilder
                .start(BetterNether.makeID(name + "_" + postFix), Feature.RANDOM_SELECTOR)
                .decoration(GenerationStep.Decoration.VEGETAL_DECORATION)
                .modifier(modifiers)
                .buildAndRegister(new RandomFeatureConfiguration(features, features.get(defaultIndex).feature));
    }

    public static void ensureStaticInitialization() {
    }
}
