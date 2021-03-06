package firewolf8385.chatmanager.commands.subcommands.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.chatmanager.SettingsManager;
import net.md_5.bungee.api.ChatColor;

public class Enable implements CommandExecutor{

    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("chat.enable")) {
            String message = settings.getConfig().getString("Messages.ChatEnable");
            String message2 = message.replace("%player%", sender.getName());

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message2));
            settings.getConfig().set("Muted", false);
            settings.saveConfig();
        }
        else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NoPermission")));
        }

        return true;
    }

}
