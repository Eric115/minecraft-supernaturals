package org.bitbucket.supernaturals.Race;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Race class for base of supernatural races.
 *
 * @author Eric
 */
public class Race {
  public String raceName;
  protected final Player player;

  public Race(Player player) {
    this.player = player;
  }

  public void moveEvent(PlayerMoveEvent event) {};
}

// for the respawn event later.
//plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
//public void run() {
//    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 18000, 2));
//    }
//    }, 20);
