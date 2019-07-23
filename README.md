# Sindastra's BukkitOPPrefix (also for Spigot)
Simple Bukkit/Spigot plugin to display a prefix to OPs and people with the opprefix.show permission.

By default, just drop the plugin (jar) into your plugins folder and every OP will get an OP prefix.

# Configuration:

## Prefix

Using the config.yml you can customize the prefix, by default:

    prefix: "§a[OP] §r"

Color codes are accepted.

## Permissions

The prefix will be shown for everyone that has the following permission:

    opprefix.show

This way you can use a permission system instead of having to give everyone OP.

## Hide OP

If you don't want to show the prefix for everyone that has the OP permission/status, update the config to use this:

    show-for-op: false
