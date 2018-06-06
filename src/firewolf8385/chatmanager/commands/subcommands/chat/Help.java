package firewolf8385.chatmanager.commands.subcommands.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import firewolf8385.chatmanager.SettingsManager;

public class Help {
    SettingsManager settings = SettingsManager.getInstance();

    public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] copyOfRange) {

        if(sender.hasPermission("chat.help")){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l----------&6&lChat Help&8&l----------"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat blacklist &8- &rAdd/Remove Words From The Blacklist"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat broadcast &8- &rBroadcast A Message To Everyone"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat clear &8- &rClear the chat"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat disable &8- &rDisable Chat"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat enable &8- &rEnable Chat"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat flood &8- &rFlood Chat With A Message"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat help &8- &rShows The Help Page"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat info &8- &rShows Info About The Plugin"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/chat reload &8- &rReloads The Config"));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NoPermission")));
        }

    }

}
