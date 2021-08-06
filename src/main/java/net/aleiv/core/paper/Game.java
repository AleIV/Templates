package net.aleiv.core.paper;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import net.aleiv.core.paper.events.GameTickEvent;

public class Game extends BukkitRunnable {
    Core instance;

    long gameTime = 0;
    long startTime = 0;

    public Game(Core instance) {
        this.instance = instance;
        this.startTime = System.currentTimeMillis();

    }

    @Override
    public void run() {

        var new_time = (int) (Math.floor((System.currentTimeMillis() - startTime) / 1000.0));

        gameTime = new_time;

        Bukkit.getPluginManager().callEvent(new GameTickEvent(new_time, true));
    }
}