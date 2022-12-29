package io.ashz.listener;

import io.ashz.ConstantEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class ListenerPlayerJoinEvent implements Listener {
    private ConstantEffect plugin;
    private List<PotionEffect> potionEffectList;
    public ListenerPlayerJoinEvent(ConstantEffect p, List<PotionEffect> e) {
        this.plugin = p;
        this.potionEffectList = e;
    }
    @EventHandler
    public void LPlayerJoinEvent(PlayerJoinEvent e) {
        Player eventPlayer = e.getPlayer();

        for(PotionEffect indexEffect : potionEffectList) {
            eventPlayer.addPotionEffect(indexEffect);
        }
    }
}