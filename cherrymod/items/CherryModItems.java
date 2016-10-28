package cherrymod.items;

import cherrymod.Reference;
import cherrymod.blocks.CherryModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CherryModItems
{
   public static Item cherry;
   public static Item cherry_golden;
   public static Item cherry_door_item;
   public static Item cherry_bomb;
   public static Item potion_confusion;
   public static Item potion_resistance;
   
   public static void preInit(FMLPreInitializationEvent event)
   {
      cherry = new ItemCherry(2, 0.2F, false, "cherry");
      cherry_golden = new ItemCherryGolden(3, 0.6F, false, "cherry_golden");
      cherry_door_item = new ItemCherryDoor(CherryModBlocks.cherry_door_block, "cherry_door_item");
      cherry_bomb = new ItemCherryBomb("cherry_bomb");
      potion_confusion = new ItemPotionConfusion("confusion");
      potion_resistance = new ItemPotionResistance("resistance");
      
      GameRegistry.registerItem(cherry, "cherry");
      GameRegistry.registerItem(cherry_golden, "cherry_golden");
      GameRegistry.registerItem(cherry_door_item, "cherry_door_item");
      GameRegistry.registerItem(cherry_bomb, "cherry_bomb");
   }
   
   public static void postInit(FMLPostInitializationEvent event)
   {
      RenderItem render = Minecraft.getMinecraft().getRenderItem();
      
      render.getItemModelMesher().register(cherry, 0, new ModelResourceLocation(Reference.MODID + ":" + ((ItemCherry)cherry).getName(), "inventory"));
      render.getItemModelMesher().register(cherry_golden, 0, new ModelResourceLocation(Reference.MODID + ":" + ((ItemCherryGolden)cherry_golden).getName(), "inventory"));
      render.getItemModelMesher().register(cherry_door_item, 0, new ModelResourceLocation(Reference.MODID + ":" + ((ItemCherryDoor)cherry_door_item).getName(), "inventory"));
      render.getItemModelMesher().register(cherry_bomb, 0, new ModelResourceLocation(Reference.MODID + ":" + ((ItemCherryBomb)cherry_bomb).getName(), "inventory"));
   }
}