package cherrymod.blocks;

import cherrymod.Reference;
import cherrymod.items.ItemCherryLeaves;
import cherrymod.items.ItemCherrySlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CherryModBlocks
{
   public static Block cherry_sapling;
   public static Block cherry_planks;
   public static Block cherry_stairs;
   public static Block cherry_half_slab;
   public static Block cherry_double_slab;
   public static Block cherry_log;
   public static Block cherry_leaves;
   public static BlockFence cherry_fence;
   public static Block cherry_fence_gate;
   public static Block cherry_door_block;
   
   public static void preInit(FMLPreInitializationEvent event)
   {
      cherry_sapling = new BlockCherrySapling("cherry_sapling");
      cherry_log = new BlockCherryLog("cherry_log");
      cherry_leaves = new BlockCherryLeaves("cherry_leaves");
      cherry_planks = new BlockCherryPlanks(Material.wood, "cherry_planks");
      cherry_stairs = new BlockCherryStairs(Material.wood, "cherry_stairs");
      cherry_half_slab = new BlockCherryHalfSlab("cherry_half_slab");
      cherry_double_slab = new BlockCherryDoubleSlab("cherry_double_slab");
      cherry_fence = new BlockCherryFence(Material.wood, "cherry_fence");
      cherry_fence_gate = new BlockCherryFenceGate("cherry_fence_gate");
      cherry_door_block = new BlockCherryDoor(Material.wood, "cherry_door_item");
      
      GameRegistry.registerBlock(cherry_sapling, "cherry_sapling");
      GameRegistry.registerBlock(cherry_log, "cherry_log");
      GameRegistry.registerBlock(cherry_leaves, ItemCherryLeaves.class, "cherry_leaves", cherry_leaves);
      GameRegistry.registerBlock(cherry_planks, "cherry_planks");
      GameRegistry.registerBlock(cherry_stairs, "cherry_stairs");
      GameRegistry.registerBlock(cherry_half_slab, ItemCherrySlab.class, "cherry_half_slab", cherry_half_slab, cherry_double_slab);
      GameRegistry.registerBlock(cherry_double_slab, ItemCherrySlab.class, "cherry_double_slab", cherry_half_slab, cherry_double_slab);
      GameRegistry.registerBlock(cherry_fence, "cherry_fence");
      GameRegistry.registerBlock(cherry_fence_gate, "cherry_fence_gate");
      GameRegistry.registerBlock(cherry_door_block, "cherry_door_block");
   }
   
   public static void postInit(FMLPostInitializationEvent event)
   {
      RenderItem render = Minecraft.getMinecraft().getRenderItem();
      
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_sapling), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherrySapling)cherry_sapling).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_log), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryLog)cherry_log).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_planks), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryPlanks)cherry_planks).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_half_slab), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryHalfSlab)cherry_half_slab).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_double_slab), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryDoubleSlab)cherry_double_slab).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_stairs), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryStairs)cherry_stairs).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_leaves), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryLeaves)cherry_leaves).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_fence), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryFence)cherry_fence).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_fence_gate), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryFenceGate)cherry_fence_gate).getName(), "inventory"));
      render.getItemModelMesher().register(Item.getItemFromBlock(cherry_door_block), 0, new ModelResourceLocation(Reference.MODID + ":" + ((BlockCherryDoor)cherry_door_block).getName(), "inventory"));
   }
}