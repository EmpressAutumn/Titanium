package com.atom596.titanium.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBullet.class)
public abstract class ShulkerBulletMixin extends Entity {
    public ShulkerBulletMixin(EntityType<? extends ShulkerBullet> $$0, Level $$1) { super($$0, $$1); }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/ShulkerBullet;destroy()V"), method = "hurt")
    public void hurt(DamageSource source, float $$1, CallbackInfoReturnable<Boolean> cir) {
        if (source.getEntity() instanceof Player) {
            LootTable lootTable = this.level().getServer().reloadableRegistries().getLootTable(this.getType().getDefaultLootTable());
            LootParams.Builder lpBuilder = new LootParams.Builder((ServerLevel) this.level())
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .withParameter(LootContextParams.ORIGIN, this.position())
                    .withParameter(LootContextParams.DAMAGE_SOURCE, source)
                    .withOptionalParameter(LootContextParams.ATTACKING_ENTITY, source.getEntity())
                    .withOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY, source.getDirectEntity());
            if (source.getEntity() != null) {
                lpBuilder = lpBuilder.withParameter(LootContextParams.LAST_DAMAGE_PLAYER, (Player) source.getEntity()).withLuck(((Player) source.getEntity()).getLuck());
            }
            LootParams lootParams = lpBuilder.create(LootContextParamSets.ENTITY);
            lootTable.getRandomItems(lootParams, 0L, this::spawnAtLocation);
        }
    }
}
