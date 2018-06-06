package firewolf8385.chatmanager.commands.subcommands.chat;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import firewolf8385.chatmanager.SettingsManager;


public class Blacklist {

    SettingsManager settings = SettingsManager.getInstance();

    public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(sender.hasPermission("chat.blacklist")){
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("add")){
                    if(args.length > 1) {
                        List<String> blacklist = settings.getConfig().getStringList("blacklisted");
                        blacklist.add(args[1]);
                        settings.getConfig().set("blacklisted", blacklist);
                        settings.saveConfig();

                        String message = settings.getConfig().getString("AddBlacklist");
                        String message2 = message.replace("%word%", args[1]);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message2));
                    }
                    else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /chat blacklist add [word]"));
                    }

                }
                else if(args[0].equalsIgnoreCase("remove")){
                    if(args.length > 1) {
                        List<String> blacklist = settings.getConfig().getStringList("blacklisted");
                        blacklist.remove(args[1]);
                        settings.getConfig().set("blacklisted", blacklist);
                        settings.saveConfig();

                        String message = settings.getConfig().getString("RemoveBlacklist");
                        String message2 = message.replace("%word%", args[1]);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message2));
                    }
                    else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /chat blacklist remove [word]"));
                    }

                }
                else if(args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8----------&6&lBlacklist&8----------"));
                    List<String> blacklist = settings.getConfig().getStringList("blacklisted");
                    if(blacklist.isEmpty()) {
                        sender.sendMessage("There are no words that are blacklisted");
                    }
                    else {
                        for(int i = 0; i < blacklist.size(); i++) {
                            sender.sendMessage(blacklist.get(i));
                        }
                    }
                }
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /chat blacklist [add/remove/list] (word)"));
            }

        }
        else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NoPermission")));
        }



    }

}
