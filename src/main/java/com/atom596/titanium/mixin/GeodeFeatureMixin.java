package com.atom596.titanium.mixin;

import com.atom596.titanium.util.GeodeConfigInterface;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GeodeFeature.class)
public class GeodeFeatureMixin {
	@Inject(at = @At("RETURN"), method = "generate")
	private void gen_barrel(FeatureContext<GeodeFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
		if (((GeodeConfigInterface) context.getConfig()).getBarrelLootTable() != null) {
			StructureWorldAccess structureWorldAccess = context.getWorld();
			Random random = context.getRandom();
			int radius = context.getConfig().outerWallDistance.get(random);

			BlockPos barrelPos = context.getOrigin().add(radius, 0, radius);
			for(int i = 0; i < 2 * radius; i++) {
				if(!structureWorldAccess.isAir(barrelPos)) {
					barrelPos = barrelPos.add(0, 1, 0);
				}
			}

			structureWorldAccess.setBlockState(barrelPos, Blocks.BARREL.getDefaultState(), Block.NOTIFY_LISTENERS);
			LootableContainerBlockEntity.setLootTable(structureWorldAccess, random, barrelPos,
					((GeodeConfigInterface) context.getConfig()).getBarrelLootTable());
		}
	}
}
