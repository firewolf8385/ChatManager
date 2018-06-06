package firewolf8385.chatmanager.commands;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.chatmanager.commands.subcommands.chat.Blacklist;
import firewolf8385.chatmanager.commands.subcommands.chat.Broadcast;
import firewolf8385.chatmanager.commands.subcommands.chat.Clear;
import firewolf8385.chatmanager.commands.subcommands.chat.Disable;
import firewolf8385.chatmanager.commands.subcommands.chat.Enable;
import firewolf8385.chatmanager.commands.subcommands.chat.Flood;
import firewolf8385.chatmanager.commands.subcommands.chat.Help;
import firewolf8385.chatmanager.commands.subcommands.chat.Infos;
import firewolf8385.chatmanager.commands.subcommands.chat.Reload;
import net.md_5.bungee.api.ChatColor;


public class Chat implements CommandExecutor{


    private Blacklist subA;
    private Broadcast subB;
    private Clear subC;
    private Disable subD;
    private Enable subE;
    private Flood subF;
    private Help subG;
    private Infos subH;
    private Reload subI;

    public Chat(){
        this.subA = new Blacklist();
        this.subB = new Broadcast();
        this.subC = new Clear();
        this.subD = new Disable();
        this.subE = new Enable();
        this.subF = new Flood();
        this.subG = new Help();
        this.subH = new Infos();
        this.subI = new Reload();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (args.length >= 1) { // Checks to make sure arguments were given

            switch (args[0].toLowerCase()) { // This can be described as a small version of an if/elseif/else statement
                case "blacklist":
                    this.subA.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "broadcast":
                    this.subB.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "alert":
                    this.subB.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "clear":
                    this.subC.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "disable":
                    this.subD.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "mute":
                    this.subD.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "off":
                    this.subD.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "enable":
                    this.subE.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "unmute":
                    this.subE.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "on":
                    this.subE.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "flood":
                    this.subF.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "help":
                    this.subG.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "info":
                    this.subH.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "reload":
                    this.subI.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
                    break;
                default:
                    this.subG.onCommand(sender, cmd, commandLabel, Arrays.copyOfRange(args, 1, args.length));
            }
        }

        else {

            // Displays help page if no arguments are given
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

        // I would recommend always setting this to true, as setting it to false prints the command in chat.
        return true;
    }

}
