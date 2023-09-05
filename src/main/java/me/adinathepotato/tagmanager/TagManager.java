package me.adinathepotato.tagmanager;

import me.adinathepotato.commands.ChangePrefixDonatorConfigurated;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class TagManager extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[TagManager] Started TagManager version 1.0!");
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();

        }

        saveDefaultConfig();
        getCommand("changeprefixconfig").setExecutor(new ChangePrefixDonatorConfigurated(this));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[TagManager] Stopped TagManager version 1.0!");
    }
}
