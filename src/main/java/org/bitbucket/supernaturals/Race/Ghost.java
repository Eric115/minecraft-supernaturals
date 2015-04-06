package org.bitbucket.supernaturals.Race;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Ghost Class
 *
 * @author Eric
 */
public class Ghost extends Race {
  public final String raceName = "Ghost";

  public Ghost(Player player) {
    super(player);
    setAbilities();
    player.sendMessage("You are now a " + raceName);
  }

  private void setAbilities() {
    player.setAllowFlight(true);
    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));
    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 1));
  }
}
