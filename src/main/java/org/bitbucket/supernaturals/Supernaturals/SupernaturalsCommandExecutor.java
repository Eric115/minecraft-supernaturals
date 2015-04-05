package org.bitbucket.supernaturals.Supernaturals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Eric on 5/04/15.
 */
public class SupernaturalsCommandExecutor implements CommandExecutor {
  private final Supernaturals plugin;

  public SupernaturalsCommandExecutor(Supernaturals plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    // if sender instanceof Player
    // check args length.
    // Check if the player is online.
    if (cmd.getName().equalsIgnoreCase("setrace")) {
      return true;
    }

    return false;
  }
}
