package org.bitbucket.supernaturals.Race;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Vampire class
 *
 * @author Eric
 */
public class Vampire extends Race {
  public String raceName = "Vampire";
  private boolean hasDarkAbilities = false;

  public Vampire(Player player) {
    super(player);
  }

  /**
   * Handles when the player moves.
   *
   * @param event
   */
  @Override
  public void moveEvent(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    World w = player.getWorld();

    if (!hasDarkAbilities && (w.hasStorm() || w.getBlockAt(player.getLocation()).getLightFromSky() < 12)) {
      setDarkAbilities();
    } else if (hasDarkAbilities) {
      setLightAbilities();
    }
  }

  private void setDarkAbilities() {
    // abilities need to be cleared before they are set here again.

    // Maybe these should be moved into a list and added with a loop?
    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 0));
    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 1));
    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 1));

    hasDarkAbilities = true;
  }

  private void setLightAbilities() {
    player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 250, 2));
    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 1));
    hasDarkAbilities = false;
  }
}
