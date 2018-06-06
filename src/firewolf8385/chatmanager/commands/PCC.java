package firewolf8385.chatmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PCC implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        for(int i = 0; i < 100; i++) {
            sender.sendMessage("");
        }

        return true;
    }

}
