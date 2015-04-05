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
  protected Player player;

  public Race(Player player) {
    this.player = player;
  }

  public void moveEvent(PlayerMoveEvent event) {};
}
