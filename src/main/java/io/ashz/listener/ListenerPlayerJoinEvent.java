package io.ashz.listener;

import io.ashz.ConstantEffect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ListenerPlayerJoinEvent implements Listener {
    private ConstantEffect plugin;
    public ListenerPlayerJoinEvent(ConstantEffect p) {
        this.plugin = p;
    }
    @EventHandler
    public void LPlayerJoinEvent(PlayerJoinEvent e) {
        PotionEffect p = new PotionEffect(PotionEffectType.CONDUIT_POWER, Integer.MAX_VALUE-1, 0, false, false);
        e.getPlayer().addPotionEffect(p);
    }
}
