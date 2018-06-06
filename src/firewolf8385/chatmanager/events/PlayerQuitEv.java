package firewolf8385.chatmanager.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import firewolf8385.chatmanager.SettingsManager;

public class PlayerQuitEv implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent e) {

        if(settings.getConfig().getBoolean("QuitMessages") == true) {

            if(settings.getConfig().getBoolean("CustomQuitMessage") == true) {
                Player p = e.getPlayer();

                String quitMessage = settings.getConfig().getString("QuitMessage");
                String newQuitMessage = quitMessage.replace("%player%", p.getName()).replace("%displayname%", p.getDisplayName());

                e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', newQuitMessage));
            }
        }
        else {
            e.setQuitMessage(null);
        }

    }
}