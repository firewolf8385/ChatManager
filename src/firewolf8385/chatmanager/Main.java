package firewolf8385.chatmanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import firewolf8385.chatmanager.commands.Chat;
import firewolf8385.chatmanager.commands.Colors;
import firewolf8385.chatmanager.commands.PCC;
import firewolf8385.chatmanager.commands.CC;
import firewolf8385.chatmanager.events.AsyncChatEv;
import firewolf8385.chatmanager.events.PlayerDeathEv;
import firewolf8385.chatmanager.events.PlayerJoinEv;
import firewolf8385.chatmanager.events.PlayerQuitEv;

public class Main extends JavaPlugin{

    SettingsManager settings = SettingsManager.getInstance();

    public void onEnable(){

        settings.setup(this);

        if(settings.getConfig().getInt("ConfigVersion") != 3) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "[ChatManager] Outdated Config! The plugin will still work, but features relying on new additions to the config will give errors.");
        }

        getCommand("chat").setExecutor(new Chat());
        getCommand("colors").setExecutor(new Colors());
        getCommand("pcc").setExecutor(new PCC());
        getCommand("cc").setExecutor(new CC());

        getServer().getPluginManager().registerEvents(new AsyncChatEv(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEv(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEv(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEv(), this);
    }

}