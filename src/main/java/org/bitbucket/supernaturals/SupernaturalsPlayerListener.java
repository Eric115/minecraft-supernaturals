package org.bitbucket.supernaturals;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Listen for player events.
 *
 * @author Eric
 */
public class SupernaturalsPlayerListener implements Listener {
  private final Supernaturals plugin;

  public SupernaturalsPlayerListener(Supernaturals instance) {
    plugin = instance;
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    // Dispatch move event to that player's Race instance.
    plugin.getRaceInstance(event.getPlayer()).moveEvent(event);
  }
}
