package org.bitbucket.supernaturals.Supernaturals;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Supernaturals class
 *
 * @author Eric Goodwin
 */
public final class Supernaturals extends JavaPlugin {
  @Override
  public void onEnable() {
    // Move setrace command logic to SupernaturalsCommandExecutor class.
    this.getCommand("setrace").setExecutor(new SupernaturalsCommandExecutor(this));
  }

  @Override
  public void onDisable() {
    // Logic for when disabled.
  }
}
