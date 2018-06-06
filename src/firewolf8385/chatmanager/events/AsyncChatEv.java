package firewolf8385.chatmanager.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import firewolf8385.chatmanager.SettingsManager;
import net.md_5.bungee.api.ChatColor;

public class AsyncChatEv implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(!(p.hasPermission("chat.bypass.mute")) && settings.getConfig().getBoolean("Muted") == true) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.ChatIsMuted")));
            e.setCancelled(true);
        }

        else {

            if(settings.getConfig().getBoolean("Blacklist")){

                if(!p.hasPermission("chat.bypass.filter")){

                    for(String word : e.getMessage().toLowerCase().split(" ")){

                        if(settings.getConfig().getStringList("blacklisted").contains(word)){
                            e.setCancelled(true);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.NotAllowedToSayThat")));
                        }

                    }

                }
            }
        }

        if(p.hasPermission("chat.notify")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError: ChatManager Config is outdated. The plugin will still work, but features that rely on new changes will give errors."));
        }
    }

}
