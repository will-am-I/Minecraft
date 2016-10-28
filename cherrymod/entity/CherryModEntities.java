package cherrymod.entity;

import cherrymod.CherryMod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CherryModEntities
{
   public static void preInit(FMLPreInitializationEvent event)
   {
      EntityRegistry.registerModEntity(EntityCherryBomb.class, "cherry_bomb", 1, CherryMod.class, 80, 3, true);
   }
}