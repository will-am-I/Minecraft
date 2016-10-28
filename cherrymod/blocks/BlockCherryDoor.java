package cherrymod.blocks;

import cherrymod.Reference;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;

public class BlockCherryDoor extends BlockDoor
{
   private String name;
   
   public BlockCherryDoor(Material material, String name)
   {
      super(material);
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setHardness(3.0f);
      setStepSound(soundTypeWood);
   }
   
   public String getName()
   {
      return this.name;
   }
}