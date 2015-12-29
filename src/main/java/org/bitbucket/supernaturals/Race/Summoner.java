package org.bitbucket.supernaturals.Race;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * Summoner class
 *
 * @author Eric
 */
public class Summoner extends Race {
  public final String raceName = "Summoner";

  public Summoner(Player player) {
    super(player);
    giveItems();
    player.sendMessage("You are now a Summoner.");
  }

  protected void giveItems() {
    // Rabbit egg
    player.getInventory().addItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 101));
    // Creeper Egg
    player.getInventory().addItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 50));
    // Horse Egg
    player.getInventory().addItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 100));
    // Wolf Egg
    player.getInventory().addItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 95));
  }

  public void useEvent(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    switch (event.getMaterial()) {
      case MONSTER_EGG: {
        ItemStack rabbit_egg, used_item;
        used_item = event.getItem();
        // Bit hacky. Need to fix the amount in stack.
        rabbit_egg = new ItemStack(Material.MONSTER_EGG, used_item.getAmount(), (short) 101);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1));

        if (used_item.equals(rabbit_egg)) {
          Location loc = event.getClickedBlock().getLocation().add(0, 3, 0);

          for (int i = 0; i < 50; i++) {
            player.getWorld().spawnEntity(loc, EntityType.RABBIT);
          }

          new BukkitRunnable() {
            @Override
            public void run() {
              player.getInventory().addItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 101));
            }
          }.runTaskLater(this.plugin, 30);
        }

        break;
      }
    }
  }

}
