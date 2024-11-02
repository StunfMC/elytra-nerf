package net.stunf.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@ModifyExpressionValue(method = "tickGliding", at = @At(value = "CONSTANT", args = "intValue=2"))
	private int injected(int original) {
		int ticks = 0;
		if (ticks == 0){
			return 2;
		}
		return ticks * 2;
	}

	@ModifyArg(method = "tickGliding", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V"), index = 0)
	private int dontDamageElytra(int damage) {
		int ticks = 0;
		return ticks == 0 ? 0 : 1;
	}
}
