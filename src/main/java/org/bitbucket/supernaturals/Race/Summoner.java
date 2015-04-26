package org.bitbucket.supernaturals.Race;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
//import java.security.Timestamp;

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
}
