package io.ashz;

import io.ashz.utility.Message;
import io.ashz.listener.ListenerPlayerRespawnEvent;
import io.ashz.listener.ListenerPlayerJoinEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ConstantEffect extends JavaPlugin {
    private String pluginName = "ConstantEffect";
    private List<PotionEffect> potionEffectList = new ArrayList<PotionEffect>();
    private void readConfigFile() {
        FileConfiguration fileData;
        List<Map<?,?>> configList;
        String effect;
        int duration;

        this.saveDefaultConfig(); // copy config.yml if file does not exists

        fileData = this.getConfig();
        configList = fileData.getMapList("effects");

        for(Map<?,?> effectIndex : configList) {
            try {
                effect = (String)effectIndex.get("effects");
                duration = (Integer)effectIndex.get("duration");
                PotionEffect indexEffect;
                PotionEffectType effectType;

                effectType = PotionEffectType.getByName(effect);
                if(effectType == null) {
                    continue;
                }

                if(duration < 0) {
                    duration = Integer.MAX_VALUE-1;
                }

                indexEffect = new PotionEffect(
                        effectType,
                        duration,
                        (Integer)effectIndex.get("amplifier"),
                        (Boolean)effectIndex.get("ambient"),
                        (Boolean)effectIndex.get("particles"));

                if(indexEffect != null) {
                    potionEffectList.add(indexEffect);
                }
            } catch (ClassCastException e) {
                Message.sendConsoleMessage(this, "error handling this config ["+effectIndex.toString()+"]");
            }
        }
    }

    @Override
    public void onEnable() {
        // configuration file
        readConfigFile();

        this.getServer().getPluginManager().registerEvents(new ListenerPlayerJoinEvent(this, potionEffectList), this);
        this.getServer().getPluginManager().registerEvents(new ListenerPlayerRespawnEvent(this, potionEffectList), this);
        Message.sendConsoleMessage(this, Message.notification + "starting plugin: " + this.pluginName);
    }

    @Override
    public void onDisable() {
        Message.sendConsoleMessage(this, Message.warning + "ending plugin: " + this.pluginName);
    }
}
