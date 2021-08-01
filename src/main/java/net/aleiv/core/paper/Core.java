package net.aleiv.core.paper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import co.aikar.commands.PaperCommandManager;
import co.aikar.taskchain.TaskChainFactory;
import lombok.Getter;
import lombok.Setter;
import net.aleiv.core.paper.commands.GlobalCMD;
import net.aleiv.core.paper.listeners.GlobalListener;


public class Core extends JavaPlugin{

    private static @Getter Core instance;
    private static @Getter @Setter TaskChainFactory taskChainFactory;
    private @Getter Game game;
    private @Getter PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;

        game = new Game(this);
        game.runTaskTimerAsynchronously(this, 0L, 20L);

        Bukkit.getPluginManager().registerEvents(new GlobalListener(this), this);

        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new GlobalCMD(this));

    }

    @Override
    public void onDisable() {

    }
    
}