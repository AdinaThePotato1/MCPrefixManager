package me.adinathepotato.commands;
import me.adinathepotato.tagmanager.TagManager;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChangePrefixDonatorConfigurated implements CommandExecutor {
    private final TagManager plugin;

    public ChangePrefixDonatorConfigurated(TagManager plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check if the command has the correct number of arguments
        if (args.length != 3) {
            sender.sendMessage("Wrong amount of arguments!");
            return false;
        }


        String permissionCommandString = args[2];
        String playerArg = args[1];
        Player player = Bukkit.getPlayer(playerArg);
        String rankCommandArgumentPrefix = args[0];

        RemovePrefix deletePrefix = new RemovePrefix(plugin);
        AddAndCheck givePrefix = new AddAndCheck(plugin);

        if (player == null) {
            sender.sendMessage("Not a player!");
        }

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);

            if (sender instanceof ConsoleCommandSender) {
                deletePrefix.removePrefixFromPlayer(user);
                player.sendMessage("Removed your previous prefix!");
                givePrefix.addAndCheckPrefix(user, player, rankCommandArgumentPrefix, permissionCommandString);
            }
            return true;
        }
}

