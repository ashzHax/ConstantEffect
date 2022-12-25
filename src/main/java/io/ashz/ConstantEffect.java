package io.ashz;

import io.ashz.utility.Message;
import io.ashz.listener.ListenerPlayerRespawnEvent;
import io.ashz.listener.ListenerPlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ConstantEffect extends JavaPlugin {
    private String pluginName = "ConstantEffect";

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ListenerPlayerJoinEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new ListenerPlayerRespawnEvent(this), this);
        Message.sendConsoleMessage(this, Message.notification + "starting plugin: "+this.pluginName);
    }

    @Override
    public void onDisable() {
        Message.sendConsoleMessage(this, Message.warning + "ending plugin: "+this.pluginName);
    }
}
