package org.bitbucket.supernaturals;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;

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
    Player player = event.getPlayer();
    ItemStack rabbit_egg = new ItemStack(Material.MONSTER_EGG, 1, (short) 101);

    if (event.getMaterial().equals(Material.MONSTER_EGG)) {
      Location loc = event.getClickedBlock().getLocation();
      for (int i = 0; i < 100; i++) {
        loc.add(0, 0, 10);
        player.getWorld().spawnEntity(loc, EntityType.RABBIT);
      }
    } else {
      System.out.println("item not an egg!");
    }
  }

}
