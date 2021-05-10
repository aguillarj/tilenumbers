package net.runelite.client.plugins.tilenumber;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Tile Number Overlay"
)
public class tile_number_plugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private tile_number_config config;

    @Override
    protected void startUp() throws Exception
    {
        log.info("tilenumber started!");
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("tilenumber stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "tilenumber says " + config.greeting(), null);
        }
    }

    @Provides
    tile_number_config provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(tile_number_config.class);
    }
}
