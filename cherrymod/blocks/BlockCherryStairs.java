package cherrymod.blocks;

import cherrymod.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;

public class BlockCherryStairs extends BlockStairs
{
   String name;
   
   public BlockCherryStairs(Material material, String name)
   {
      super(CherryModBlocks.cherry_planks.getDefaultState());
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      useNeighborBrightness = true;
   }
   
   public String getName()
   {
      return this.name;
   }
}