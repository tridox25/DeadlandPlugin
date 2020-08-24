package me.tridox25.DeadlandPlugin.commands.SubCommands;

import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
    private Main plugin = Main.getInstance();

    public CommandManager(){}

    public String main = "dpl";
    public String info = "info";
    public String version = "version";
    public String item = "item";
    public String wither = "wither";

    public void setup(){
        plugin.getCommand(main).setExecutor(this);

        this.commands.add(new InfoCommand());
        this.commands.add(new Version());
        this.commands.add(new Item());
        this.commands.add(new Wither());

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Solo los jugadores pueden usar este commando");
            return true;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase(main)){
            if(args.length == 0){
                player.sendMessage(ChatColor.RED + "¡Commando incompleto! Usa /dpl info para saber más");
                return true;
            }
            SubCommand target = this.get(args[0]);

            if(target == null){
                player.sendMessage(ChatColor.RED + "¡Este Commando no existe! Usa /dpl info para más información");
                return true;
            }

            ArrayList<String> arrayList = new ArrayList<String>();

            arrayList.addAll(Arrays.asList(args));
            arrayList.remove(0);

            try{
                target.onCommand(player, args);
            }catch (Exception e){
                player.sendMessage(ChatColor.RED + "Un error a ocurrido");

                e.printStackTrace();
            }
        }
        return true;
    }
    private SubCommand get(String name){
        Iterator<SubCommand> subCommands = this.commands.iterator();

        while (subCommands.hasNext()) {
            SubCommand sc = (SubCommand) subCommands.next();

            if(sc.name().equalsIgnoreCase(name)){
                return sc;
            }

            String[] aliases;
            int length = (aliases = sc.aliases()).length;

            for (int var5 = 0; var5 < length; ++var5) {
                String alias = aliases[var5];
                if(name.equalsIgnoreCase(alias)){
                    return sc;
                }

            }

        }
        return null;
    }

}
