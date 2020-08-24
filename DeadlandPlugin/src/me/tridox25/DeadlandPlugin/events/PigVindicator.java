package me.tridox25.DeadlandPlugin.events;

import com.sun.istack.internal.NotNull;
import me.tridox25.DeadlandPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import javax.xml.stream.Location;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PigVindicator implements Listener {


    private Main a;

    public PigVindicator(Main main) {

    }


    //@EventHandler
    //public void EntitySpawn(EntitySpawnEvent e) {
       // int random = ThreadLocalRandom.current().nextInt(100);

        //if(random < 75) {
          //  if (e.getEntity() instanceof Pig) {
            //    e.setCancelled(true);

//                e.getEntity().getLocation().getWorld().spawnEntity(e.getLocation(), EntityType.RAVAGER);


  //          }
    //    }
    //}


    @EventHandler
    public void ChunkLoad(ChunkLoadEvent e) {
        if (e.getWorld().getLivingEntities().contains(Pig.class)) {
            e.getWorld().getLivingEntities().remove(Pig.class);
        }
    }

}
