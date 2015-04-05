package org.bitbucket.supernaturals.Race;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Abstract Race class for base of supernatural races.
 *
 * @author Eric
 */
public abstract class Race {
  public String raceName;
  protected Player player;

  public void moveEvent(PlayerMoveEvent event) {
    return;
  };
}
