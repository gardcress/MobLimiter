package tropaeo.com.moblimiter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import tropaeo.com.moblimiter.MobLimiter;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mlreload")) {
            reloadConfig(); // NEEEEEEEEEDS TO BE PLACED IN THE CORRECT PLACE
            if (sender instanceof ConsoleCommandSender) {
                ConsoleCommandSender console = (ConsoleCommandSender) sender;
                sender.sendMessage("MobLimiter reloaded.");
            }
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("moblimiter.reload")) {
                    player.sendMessage("MobLimiter reloaded.");
                } else {
                    player.sendMessage("No permission");
                }
            }
        }
        return true;
    }

    private void reloadConfig() {
        MobLimiter.instance.reloadConfig();
        MobLimiter.disabledMobList = MobLimiter.instance.getConfig().getStringList("disabled-mobs");
        for(String str : MobLimiter.disabledMobList){
            System.out.println(str);
        }
    }
}
