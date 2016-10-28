package cherrymod;

import cherrymod.blocks.CherryModBlocks;
import cherrymod.entity.CherryModEntities;
import cherrymod.handler.RecipeHandler;
import cherrymod.handler.WorldGenHandler;
import cherrymod.items.CherryModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class CherryMod
{
   private WorldGenHandler handler;
   
   @EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
      CherryModBlocks.preInit(event);
      CherryModItems.preInit(event);
      CherryModEntities.preInit(event);
      
      handler = new WorldGenHandler();
      GameRegistry.registerWorldGenerator(handler, 0);
   }
   
   @EventHandler
   public void init(FMLInitializationEvent event)
   {
	   RecipeHandler.init(event);
   }
   
   @EventHandler
   public void postInit(FMLPostInitializationEvent event)
   {
      if (event.getSide() == Side.CLIENT)
      {
         CherryModBlocks.postInit(event);
         CherryModItems.postInit(event);
      }
   }
}