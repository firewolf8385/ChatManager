package firewolf8385.chatmanager.commands.subcommands.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.chatmanager.SettingsManager;

public class Reload implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        SettingsManager settings = SettingsManager.getInstance();

        if(sender.hasPermission("chat.reload")) {
            settings.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.PluginReloaded")));
        }

        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NoPermission")));
        }

        return true;
    }

}
