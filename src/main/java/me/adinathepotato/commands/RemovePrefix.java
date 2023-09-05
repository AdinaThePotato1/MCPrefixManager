package me.adinathepotato.commands;

import me.adinathepotato.tagmanager.TagManager;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.PrefixNode;

import java.util.List;


public class RemovePrefix {

    private final TagManager plugin;

    public RemovePrefix(TagManager plugin) {
        this.plugin = plugin;
    }

    public void removePrefixFromPlayer(User user) {

        List<String> prefixes = (List<String>) plugin.getConfig().getList("prefixes");

        assert prefixes != null;
        for (String prefixIterator : prefixes) {
            user.data().remove(PrefixNode.builder(prefixIterator, 100).build());
            LuckPermsProvider.get().getUserManager().saveUser(user);
        }
    }
}

