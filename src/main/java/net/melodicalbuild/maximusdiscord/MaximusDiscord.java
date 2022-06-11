package net.melodicalbuild.maximusdiscord;

import github.scarsz.discordsrv.DiscordSRV;
import net.melodicalbuild.maximuscore.MaximusCore;
import net.melodicalbuild.maximuscore.plugin.Available.DiscordPlugin;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaximusDiscord extends JavaPlugin implements Listener {

    private DiscordSRVListener discordsrvListener = new DiscordSRVListener(this);

    @Override
    public void onEnable() {
        DiscordSRV.api.subscribe(discordsrvListener);
        getServer().getPluginManager().registerEvents(this, this);

        MaximusCore.pluginManager.EnablePlugin(new DiscordPlugin("1.0.0", false));
    }

    @Override
    public void onDisable() {
        DiscordSRV.api.unsubscribe(discordsrvListener);
    }
}
