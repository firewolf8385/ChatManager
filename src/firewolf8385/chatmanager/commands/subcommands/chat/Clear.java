package firewolf8385.chatmanager.commands.subcommands.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import firewolf8385.chatmanager.SettingsManager;
import net.md_5.bungee.api.ChatColor;

public class Clear implements CommandExecutor{

    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null) {
                for(int i = 0; i < 100; i++) {
                    target.sendMessage("");

                    String message1 = settings.getConfig().getString("ChatClearedOther");
                    String message2 = message1.replace("%player%", args[0]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message2));
                }
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError: That player is not online!"));
            }
        }
        else {
            if(sender.hasPermission("chat.clear")) {
                for(int i = 0; i < 100; i++) {
                    Bukkit.broadcastMessage("");
                }
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NoPermission")));
            }
        }


        return true;
    }

}
