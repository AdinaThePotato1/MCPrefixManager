package me.adinathepotato.commands;

import me.adinathepotato.tagmanager.TagManager;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.PrefixNode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class AddAndCheck {
    private final TagManager plugin;

    public AddAndCheck(TagManager plugin) {
        this.plugin = plugin;
    }

    public void addAndCheckPrefix(User user, Player player, String rankCommandArgumentPrefix, String permissionCommandString) {

        List<String> prefixes = (List<String>) plugin.getConfig().getList("prefixes");

        List<String> permissions = (List<String>) plugin.getConfig().getList("permissions");

        if (permissions == null || prefixes == null) {
            Bukkit.getConsoleSender().sendMessage("Something went wrong in the config! This can be caused by an improperly typed entry within the list.");
        }


        if (player.hasPermission(permissionCommandString)) {
            for (String RankIterator : prefixes) {
                for (String PermIterator : permissions) {
                    if (rankCommandArgumentPrefix.equals(RankIterator) && player.hasPermission(PermIterator) == player.hasPermission(permissionCommandString)) {
                        user.data().add(PrefixNode.builder(rankCommandArgumentPrefix, 100).build());
                        LuckPermsProvider.get().getUserManager().saveUser(user);
                        player.sendMessage("Changed your prefix to the " + rankCommandArgumentPrefix + " prefix!");
                        break;
                    }
                }

            }
        }
        else {
            player.sendMessage("Insufficient permissions!");
        }
    }
}