package firewolf8385.chatmanager.commands.subcommands.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Infos implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l----------&6&lChatManager&8&l----------"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Version &8- &r2.0.0"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Config Version &8- &r2"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Author &8- &rFireWolf"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Spigot &8- &rhttps://www.spigotmc.org/resources/chatmanager.25066/"));
        }

        return true;
    }

}
