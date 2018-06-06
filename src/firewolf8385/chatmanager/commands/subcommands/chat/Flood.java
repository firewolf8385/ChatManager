package firewolf8385.chatmanager.commands.subcommands.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import firewolf8385.chatmanager.SettingsManager;

public class Flood {

    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

        if(sender.hasPermission("chat.flood")){
            if(args.length > 0){
                String message = " ";

                for(int i = 0; i < args.length; i++){
                    message += args[i] + " ";
                }

                for(int i = 0; i < 100; i++) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Broadcast") + message));
                }

            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /chat flood [message]"));
            }
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NoPermission")));
        }

        return true;
    }
}
