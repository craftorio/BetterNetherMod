package org.betterx.betternether.blocks.complex;

import org.betterx.bclib.complexmaterials.entry.BlockEntry;
import org.betterx.betternether.blocks.BlockWartRoots;
import org.betterx.betternether.blocks.BlockWartSeed;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class WartMaterial extends RoofMaterial {
    public final static String BLOCK_SEED = BLOCK_OPTIONAL_SEED;
    public final static String BLOCK_ROOTS = BLOCK_OPTIONAL_ROOT;

    public WartMaterial(String name, MaterialColor woodColor, MaterialColor planksColor) {
        super(name, woodColor, planksColor);
    }

    @Override
    public WartMaterial init() {
        return (WartMaterial) super.init();
    }

    @Override
    protected void initDefault(FabricBlockSettings blockSettings, FabricItemSettings itemSettings) {
        super.initDefault(blockSettings, itemSettings);
        addBlockEntry(new BlockEntry(BLOCK_SEED, (complexMaterial, settings) -> {
            return new BlockWartSeed();
        }).setBlockTags(BlockTags.SAPLINGS).setItemTags(ItemTags.SAPLINGS));

        addBlockEntry(new BlockEntry(BLOCK_ROOTS, false, (complexMaterial, settings) -> {
            return new BlockWartRoots();
        }));
    }

    public Block getRoot() {
        return getBlock(BLOCK_ROOTS);
    }

    public Block getSeed() {
        return getBlock(BLOCK_SEED);
    }
}
