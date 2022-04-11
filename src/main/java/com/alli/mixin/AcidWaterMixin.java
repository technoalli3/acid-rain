package com.alli.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.alli.acidrain.AcidRainMain.ACID_PROTECTION;
import static net.minecraft.enchantment.Enchantments.UNBREAKING;
import static net.minecraft.entity.EntityType.BOAT;
import static net.minecraft.entity.EntityType.PLAYER;

@Mixin(LivingEntity.class)
public abstract class AcidWaterMixin extends Entity {
    @Shadow
    public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow
    public abstract boolean canFreeze();

    Random r = new Random();
    int timerRain = 0;
    int timerInAcid = 0;

    public AcidWaterMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void CheckWaterAcid(CallbackInfo ci) {
        /** Touching water */
        if (!this.world.isClient) {
            if (((Entity) (Object) this).isTouchingWaterOrRain()) {
                if (((Entity) (Object) this).isTouchingWater()) {//is in water
                    if (((Entity) (Object) this).isPlayer()) {//is a player
                        PlayerAbilities checker = (((PlayerEntity) (Object) this).getAbilities());
                        if (!checker.creativeMode) {//not creative mode
                            if (((PlayerEntity) (Object) this).hasStackEquipped(EquipmentSlot.CHEST)) {//has chest armour
                                ItemStack stack = (((PlayerEntity) (Object) this).getEquippedStack(EquipmentSlot.CHEST));

                                if (EnchantmentHelper.getLevel(ACID_PROTECTION, stack) > 0) {//is enchanted
                                    if (timerRain >= 10) {//tick timer
                                        double random = r.nextDouble();
                                        if (random < .7) {//chance of damage
                                            random = r.nextDouble();
                                            if(EnchantmentHelper.getLevel(UNBREAKING,stack) == 1) {//unbreaking I
                                                if(random < .33) {
                                                    stack.setDamage(stack.getDamage() + 1);
                                                }
                                            }else if(EnchantmentHelper.getLevel(UNBREAKING,stack) == 2) {//unbreaking 2
                                                if(random < .2) {
                                                    stack.setDamage(stack.getDamage() + 1);
                                                }
                                            }else if(EnchantmentHelper.getLevel(UNBREAKING,stack) == 3) {//unbreaking 3
                                                if(random < .1) {
                                                    stack.setDamage(stack.getDamage() + 1);
                                                }
                                            }else {//no unbreaking
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }
                                        timerRain = 0;
                                    } else {//add to timer
                                        timerRain++;
                                    }
                                    if (stack.getDamage() >= stack.getMaxDamage()) {//check if out of durability
                                        stack.setCount(0);
                                    }
                                } else {//not enchanted chest armour
                                    ((Entity) (Object) this).playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 1F, 1F);
                                    ((Entity) (Object) this).damage(DamageSource.DROWN, Integer.MAX_VALUE);
                                }
                            } else {//no chest armour
                                ((Entity) (Object) this).playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 1F, 1F);
                                ((Entity) (Object) this).damage(DamageSource.DROWN, Integer.MAX_VALUE);
                            }
                        }//not creative mode
                    } else {//just entity
                        String name = String.valueOf(((Entity) (Object) this).getName());
                        if (!(((Entity) (Object) this).getType() == BOAT)) {//not a boat
                            ((Entity) (Object) this).damage(DamageSource.DROWN, Integer.MAX_VALUE);
                        }
                    }


                    /** Touching rain */
                } else {//is in rain
                    if (((Entity) (Object) this).isPlayer()) {//is a player
                        PlayerAbilities checker = ((PlayerEntity) (Object) this).getAbilities();
                        if (!checker.creativeMode) {//not creative mode
                            if (((PlayerEntity) (Object) this).hasStackEquipped(EquipmentSlot.HEAD)) {//has helmet
                                ItemStack stack = ((PlayerEntity) (Object) this).getEquippedStack(EquipmentSlot.HEAD);
                                int damage = stack.getDamage();
                                if (timerInAcid >= 10) {//tick timer
                                    double random = r.nextDouble();
                                    if (random < .7) {//chance of damage
                                        random = r.nextDouble();
                                        if(EnchantmentHelper.getLevel(UNBREAKING,stack) == 1) {//unbreaking I
                                            if(random < .33) {
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else if(EnchantmentHelper.getLevel(UNBREAKING,stack) == 2) {//unbreaking 2
                                            if(random < .2) {
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else if(EnchantmentHelper.getLevel(UNBREAKING,stack) == 3) {//unbreaking 3
                                            if(random < .1) {
                                                stack.setDamage(stack.getDamage() + 1);
                                            }
                                        }else {//no unbreaking
                                            stack.setDamage(stack.getDamage() + 1);
                                        }
                                    }
                                    timerInAcid = 0;
                                } else {//add to timer
                                    timerInAcid++;
                                }
                                if (damage >= stack.getMaxDamage()) {//check if out of durability
                                    stack.setCount(0);
                                }
                            } else {//no helmet
                                ((Entity) (Object) this).damage(DamageSource.ON_FIRE, 1F);
                            }
                        }//end not-creative statement
                    } else {//just entity
                        if (!(((Entity) (Object) this).getType() == BOAT)) {//not a boat
                            ((Entity) (Object) this).damage(DamageSource.ON_FIRE, 1F);
                        }
                    }
                }
            }


            if (((Entity) (Object) this).getType() == PLAYER) {//is player
                int posX = ((Entity) (Object) this).getBlockX();
                int posY = ((Entity) (Object) this).getBlockY();
                int posZ = ((Entity) (Object) this).getBlockZ();
                BlockPos pos = new BlockPos(posX, posY, posZ);
                BlockState bstate = ((Entity) (Object) this).getEntityWorld().getBlockState(pos);//get blockstate
                String state = String.valueOf(bstate);
                if(state.contains("minecraft:water_cauldron")) {
                    PlayerAbilities checker = (((PlayerEntity) (Object) this).getAbilities());
                    if (!checker.creativeMode) {//not creative mode
                        if (((PlayerEntity) (Object) this).hasStackEquipped(EquipmentSlot.CHEST)) {//has chest armour
                            ItemStack stack = (((PlayerEntity) (Object) this).getEquippedStack(EquipmentSlot.CHEST));

                            if (EnchantmentHelper.getLevel(ACID_PROTECTION, stack) > 0) {//is enchanted
                                if (timerRain >= 10) {//tick timer
                                    double random = r.nextDouble();
                                    if (random < .7) {//chance of damage
                                        stack.setDamage(stack.getDamage() + 1);
                                    }
                                    timerRain = 0;
                                } else {//add to timer
                                    timerRain++;
                                }
                                if (stack.getDamage() >= stack.getMaxDamage()) {//check if out of durability
                                    stack.setCount(0);
                                }
                            } else {//not enchanted chest armour
                                ((Entity) (Object) this).playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 1F, 1F);
                                ((Entity) (Object) this).damage(DamageSource.DROWN, Integer.MAX_VALUE);
                            }
                        } else {//no chest armour
                            ((Entity) (Object) this).playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 1F, 1F);
                            ((Entity) (Object) this).damage(DamageSource.DROWN, Integer.MAX_VALUE);
                        }
                    }
                }
            }
        }
    }
}

