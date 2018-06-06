package firewolf8385.chatmanager.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import firewolf8385.chatmanager.SettingsManager;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoinEv implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if(settings.getConfig().getBoolean("JoinMessages") == true) {

            if(settings.getConfig().getBoolean("CustomJoinMessage") == true) {
                String joinMessage = settings.getConfig().getString("JoinMessage");
                String newJoinMessage = joinMessage.replace("%player%", p.getName()).replace("%displayname%", p.getDisplayName());

                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', newJoinMessage));
            }
        }
        else {
            e.setJoinMessage(null);
        }

        if(p.hasPermission("chat.notify")) {
            if(settings.getConfig().getInt("ConfigVersion") != 3) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lChatManager &8&l- &cConfig is outdated. The plugin will still work, but features relying on the updated config will give errors."));
            }
        }

    }
}
