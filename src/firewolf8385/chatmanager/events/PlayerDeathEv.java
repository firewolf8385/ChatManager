package firewolf8385.chatmanager.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import firewolf8385.chatmanager.SettingsManager;

public class PlayerDeathEv implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(PlayerDeathEvent e) {
        if(settings.getConfig().getBoolean("DeathMessages") == false) {
            e.setDeathMessage(null);
        }
    }

}
