package io.ashz.listener;

import io.ashz.ConstantEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ListenerPlayerRespawnEvent implements Listener {
    private ConstantEffect plugin;
    private long giveEffectDelay = 5L;

    public ListenerPlayerRespawnEvent(ConstantEffect p) {
        this.plugin = p;
    }

    @EventHandler
    public void LPlayerRespawnEvent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        PotionEffect pe = new PotionEffect(PotionEffectType.CONDUIT_POWER, Integer.MAX_VALUE-1, 0, false, false);

        Bukkit.getScheduler().runTaskLater(this.plugin, task -> {
            p.addPotionEffect(pe);
        }, this.giveEffectDelay);
    }
}
