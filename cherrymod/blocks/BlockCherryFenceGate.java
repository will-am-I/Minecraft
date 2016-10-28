package cherrymod.blocks;

import cherrymod.Reference;
import net.minecraft.block.BlockFenceGate;

public class BlockCherryFenceGate extends BlockFenceGate
{
   private String name;
   
   public BlockCherryFenceGate(String name)
   {
      super();
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