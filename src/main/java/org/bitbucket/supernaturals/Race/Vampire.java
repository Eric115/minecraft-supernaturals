package org.bitbucket.supernaturals.Race;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Vampire class
 *
 * @author Eric
 */
public class Vampire extends Race {
  public String raceName = "Vampire";

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

  }
}
