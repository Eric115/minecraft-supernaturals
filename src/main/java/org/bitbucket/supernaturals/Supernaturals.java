package org.bitbucket.supernaturals;

import org.bitbucket.supernaturals.Race.Race;
import org.bitbucket.supernaturals.SupernaturalsCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import org.bukkit.entity.Player;

/**
 * Supernaturals class
 *
 * @author Eric
 */
public final class Supernaturals extends JavaPlugin {
  protected Map<String, Race> pluginData;

  @Override
  public void onEnable() {
    // Move setrace command logic to SupernaturalsCommandExecutor class.
    this.getCommand("setrace").setExecutor(new SupernaturalsCommandExecutor(this));
  }

  @Override
  public void onDisable() {
    // Logic for when disabled.
  }

  public Race getRaceInstance(Player player) throws IllegalArgumentException {
    String playerName = player.getName();

    if (pluginData.containsKey(playerName)) {
      return pluginData.get(player.getName());
    } else {
      throw new IllegalArgumentException(playerName + " has no race!");
    }
  }
}
