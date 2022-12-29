package io.ashz.listener;

import io.ashz.ConstantEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class ListenerPlayerRespawnEvent implements Listener {
    private ConstantEffect plugin;
    private long giveEffectDelay = 5L;
    private List<PotionEffect> potionEffectList;

    public ListenerPlayerRespawnEvent(ConstantEffect p, List<PotionEffect> e) {
        this.plugin = p;
        this.potionEffectList = e;
    }

    @EventHandler
    public void LPlayerRespawnEvent(PlayerRespawnEvent e) {
        Player eventPlayer = e.getPlayer();

        Bukkit.getScheduler().runTaskLater(this.plugin, task -> {
            for(PotionEffect effectIndex : this.potionEffectList) {
                eventPlayer.addPotionEffect(effectIndex);
            }
        }, this.giveEffectDelay);
    }
}