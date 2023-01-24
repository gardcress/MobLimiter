package tropaeo.com.moblimiter.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import tropaeo.com.moblimiter.MobLimiter;

public class MobSpawnListener  implements Listener {


    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event){
//        System.out.println(event.getEntity().getType().name());
        for(String str : MobLimiter.disabledMobList){
            String mobTarget = event.getEntity().getType().name().toUpperCase();
            if(str.equalsIgnoreCase(mobTarget)){
//                System.out.println(mobTarget + " TRIED TO SPAWN, REFUSED IT");
                event.setCancelled(true);
            }

        }


    }

}
