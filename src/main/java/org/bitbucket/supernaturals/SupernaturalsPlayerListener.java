package org.bitbucket.supernaturals;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
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
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerMove(PlayerMoveEvent event) {
    String playerName = event.getPlayer().getName();
    // Only dispatch if they have a race.
    if (plugin.hasRace(playerName)) {
      plugin.getRaceInstance(event.getPlayer().getName()).moveEvent(event);
    }
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerUse(PlayerInteractEvent event) {
    String playerName = event.getPlayer().getName();
    // Only dispatch if they have a race.
    if (plugin.hasRace(playerName)) {
      plugin.getRaceInstance(event.getPlayer().getName()).useEvent(event);
    }
  }

}
