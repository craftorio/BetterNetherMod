package org.betterx.betternether.world.structures.bones;

import org.betterx.bclib.api.v2.levelgen.structures.StructureNBT;
import org.betterx.betternether.BlocksHelper;
import org.betterx.betternether.world.structures.IStructure;
import org.betterx.betternether.world.structures.NetherStructureNBT;
import org.betterx.betternether.world.structures.StructureGeneratorThreadContext;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;

public class StructureBoneReef implements IStructure {
    private static final StructureNBT[] BONES = new StructureNBT[]{
            NetherStructureNBT.create("bone_01"),
            NetherStructureNBT.create("bone_02"),
            NetherStructureNBT.create("bone_03")
    };

    @Override
    public void generate(
            ServerLevelAccessor world,
            BlockPos pos,
            RandomSource random,
            final int MAX_HEIGHT,
            StructureGeneratorThreadContext context
    ) {
        if (BlocksHelper.isNetherGround(world.getBlockState(pos.below())) && world.isEmptyBlock(pos.above(2)) && world.isEmptyBlock(
                pos.above(4))) {
            StructureNBT bone = BONES[random.nextInt(BONES.length)];
            bone.generateCentered(
                    world,
                    pos.below(random.nextInt(4)),
                    StructureNBT.getRandomRotation(random),
                    StructureNBT.getRandomMirror(random)
            );
        }
    }
}
