package net.runelite.client.plugins.tilenumber;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface tile_number_config extends Config
{
    @ConfigItem(
            keyName = "greeting",
            name = "Welcome Greeting",
            description = "The message to show to the user when they login"
    )
    default String greeting()
    {
        return "Hello";
    }

    @ConfigItem(
            position = 1,
            keyName = "ShowTile",
            name = " Show Tile",
            description = "would you like to ... show tile"
    )
    default boolean ShowTile(){return true;}
}
