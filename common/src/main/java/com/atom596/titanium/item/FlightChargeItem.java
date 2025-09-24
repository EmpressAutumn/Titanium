package com.atom596.titanium.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FlightChargeItem extends Item implements ProjectileItem {
    public FlightChargeItem() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.WIND_CHARGE_BURST.value(), SoundSource.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        ItemStack itemStack = user.getItemInHand(hand);

        // Change user trajectory
        if (user.getY() < world.getMinBuildHeight()) {
            user.getCooldowns().addCooldown(this, 35);
            user.setDeltaMovement(user.getDeltaMovement().add(new Vec3(0, 6, 0)));
        } else {
            user.getCooldowns().addCooldown(this, 20);
            user.setDeltaMovement(user.getDeltaMovement().add(new Vec3(0, 2, 0)));
        }
        if (user.getDeltaMovement().y < 0) {
            user.setDeltaMovement(new Vec3(0, 0, 0));
        }

        // Add or remove effects
        if (user.hasEffect(MobEffects.LEVITATION)) {
            user.removeEffect(MobEffects.LEVITATION);
        }
        if (user.hasEffect(MobEffects.SLOW_FALLING)) {
            if (user.getEffect(MobEffects.SLOW_FALLING).getDuration() < 50) {
                user.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 50));
            }
        } else {
            user.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 50));
        }

        // Change item stats
        user.increaseScore(Stats.ITEM_USED.getRegistry().getId(this));
        if (!user.isCreative()) {
            user.getItemInHand(hand).shrink(1);
        }
        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return null;
    }

    @Override
    public DispenseConfig createDispenseConfig() {
        return ProjectileItem.super.createDispenseConfig();
    }

    @Override
    public void shoot(Projectile $$0, double $$1, double $$2, double $$3, float $$4, float $$5) {
        ProjectileItem.super.shoot($$0, $$1, $$2, $$3, $$4, $$5);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return super.isEnabled($$0);
    }
}
