package firewolf8385.chatmanager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {

    private SettingsManager() { }

    static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance() {
        return instance;
    }

    Plugin pl;
    FileConfiguration config;
    File configFile;


    // Creates the config file if it does not exist
    public void setup(Plugin pl) {

        config = pl.getConfig();
        config.options().copyDefaults(true);
        configFile = new File(pl.getDataFolder(), "config.yml");
        pl.saveDefaultConfig();

    }


    public FileConfiguration getConfig() {
        return config; // Allows us to get data from config.yml
    }

    public void saveConfig() { // Attempts to save config.yml
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() { // Allows us to reload the config in game
        config = YamlConfiguration.loadConfiguration(configFile);
    }

}
