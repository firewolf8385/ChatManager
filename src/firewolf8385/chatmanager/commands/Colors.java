package firewolf8385.chatmanager.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Colors implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        /*
         * This class is also fairly useless,
         * it just gives the sender a lit of color codes.
         */

        sender.sendMessage(ChatColor.translateAlternateColorCodes('*', "*8*l----------*6*lColors*8*l----------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('*', "*0◼*r *8-*f &0   *4◼*r *8-*f &4   *8◼*r *8-*f &8   *c◼*r *8-*f &c"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('*', "*1◼*r *8-*f &1   *5◼*r *8-*f &5   *9◼*r *8-*f &9   *d◼*r *8-*f &d"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('*', "*2◼*r *8-*f &2   *6◼*r *8-*f &6   *a◼*r *8-*f &a   *e◼*r *8-*f &e"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('*', "*3◼*r *8-*f &3   *7◼*r *8-*f &7   *b◼*r *8-*f &b   *f◼*r *8-*f &f"));


        // I would recommend always setting this to true, as setting it to false prints the command in chat.
        return true;
    }

}