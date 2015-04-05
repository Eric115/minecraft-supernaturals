package org.bitbucket.supernaturals.Supernaturals;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Abstract Race class for base of supernatural races.
 *
 * @author Eric Goodwin
 */
public abstract class Race {
  public String raceName;
  protected Player player;

  public abstract void moveEvent(PlayerMoveEvent event);
}
