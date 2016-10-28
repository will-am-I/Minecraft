package cherrymod.blocks;

import cherrymod.Reference;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

public class BlockCherryFence extends BlockFence
{
   private String name;
   
   public BlockCherryFence(Material material, String name)
   {
      super(material);
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setHardness(2.0f);
      setResistance(5.0f);
      setStepSound(soundTypeWood);
   }
   
   public String getName()
   {
      return this.name;
   }
}