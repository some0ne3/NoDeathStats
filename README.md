# NoDeathStats Minecraft 1.19.3 plugin

This plugin adds permission which disables death counting in player statistics and server scoreboards(`/minecraft:scoreboard`).
Created in order to prevent players in specific worlds gaining deaths on server scoreboard - this was achieved using the plugin with addition of LuckPerms permission context feature.

## Permissions

`nodeathstats.bypass` - Allows the player to count deaths (bypasses the `nodeathstats.enable` permission)

`nodeathstats.enable` - Prevents the player from counting deaths, can be used with permission context to disable counting in specific worlds

## Compatibility

This plugin is compatible with Paper 1.19.3.