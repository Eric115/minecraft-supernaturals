package org.bitbucket.supernaturals;

import org.bitbucket.supernaturals.Race.*;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Command executor.
 *
 * @author Eric
 */
public class SupernaturalsCommandExecutor implements CommandExecutor {
  private final Supernaturals plugin;

  public SupernaturalsCommandExecutor(Supernaturals plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player && cmd.getName().equalsIgnoreCase("setrace")) {
      Player player = (Player) sender;
      Race newRace = null;

      switch (args[0]) {
        case "vampire":
          newRace = new Vampire(player);
        case "merman":
          newRace = new Merman(player);
        case "ghost":
          newRace = new Ghost(player);
      }

      if (newRace != null) {
        plugin.pluginData.put(player.getName(), newRace);
        return true;
      } else {
        return false;
      }
    }

    return false;
  }
}
