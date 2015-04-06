package org.bitbucket.supernaturals.Race;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Material;

/**
 * Merman Class
 *
 * @author Eric
 */
public class Merman extends Race {
  public final String raceName = "Merman";
  private boolean hasWaterAbilities = false;

  public Merman(Player player) {
    super(player);
    setWaterAbilities();
    player.sendMessage("You are now a " + raceName);
  }

  public void moveEvent(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    World w = player.getWorld();
    Material currentBlock = w.getBlockAt(player.getLocation()).getType();
    boolean inWater = (currentBlock.equals(Material.WATER) || currentBlock.equals(Material.STATIONARY_WATER));

    if (!hasWaterAbilities && inWater) {
      setWaterAbilities();
    } else if (hasWaterAbilities && !inWater) {
      setLandAbilities();
    }
  }

  private void setWaterAbilities() {
    clearAbilities();
    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 0));
    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 1));
    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 1));
    player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 99999, 0));
    player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 99999, 5));
    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 99999, 1));

    player.setAllowFlight(true);
    player.setFlying(true);
    hasWaterAbilities = true;
  }

  private void setLandAbilities() {
    clearAbilities();
    player.setAllowFlight(false);
    player.setFlying(false);

    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 0));
    player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 99999, 0));
    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 0));
    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100, 1));

    hasWaterAbilities = false;
  }
}
