package org.bitbucket.supernaturals.Race;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

/**
 * Race class for base of supernatural races.
 *
 * @author Eric
 */
public class Race {
  protected final Player player;

  public Race(Player player) {
    this.player = player;
    clearAbilities();
  }

  public void moveEvent(PlayerMoveEvent event) {};

  public void clearAbilities() {
    ArrayList<PotionEffectType> potionEffects = getPotionEffectTypes();

    potionEffects.stream().forEach((effect) -> {
      player.removePotionEffect(effect);
    });
  }

  protected ArrayList<PotionEffectType> getPotionEffectTypes() {
    return new ArrayList<PotionEffectType>() {{
      add(PotionEffectType.ABSORPTION);
      add(PotionEffectType.BLINDNESS);
      add(PotionEffectType.CONFUSION);
      add(PotionEffectType.DAMAGE_RESISTANCE);
      add(PotionEffectType.FAST_DIGGING);
      add(PotionEffectType.FIRE_RESISTANCE);
      add(PotionEffectType.HARM);
      add(PotionEffectType.HEAL);
      add(PotionEffectType.HEALTH_BOOST);
      add(PotionEffectType.HUNGER);
      add(PotionEffectType.INCREASE_DAMAGE);
      add(PotionEffectType.INVISIBILITY);
      add(PotionEffectType.JUMP);
      add(PotionEffectType.NIGHT_VISION);
      add(PotionEffectType.POISON);
      add(PotionEffectType.REGENERATION);
      add(PotionEffectType.SATURATION);
      add(PotionEffectType.SLOW);
      add(PotionEffectType.SLOW_DIGGING);
      add(PotionEffectType.SPEED);
      add(PotionEffectType.WATER_BREATHING);
      add(PotionEffectType.WEAKNESS);
      add(PotionEffectType.WITHER);
    }};
  }
}

// for the respawn event later.
//plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
//public void run() {
//    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 18000, 2));
//    }
//    }, 20);
