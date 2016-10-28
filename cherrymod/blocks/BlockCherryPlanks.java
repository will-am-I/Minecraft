package cherrymod.blocks;

import cherrymod.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCherryPlanks extends Block
{
   String name;
   
   public BlockCherryPlanks(Material material, String name)
   {
      super(material);
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setCreativeTab(CreativeTabs.tabBlock);
      
      setHardness(2.0F);
      setResistance(5.0F);
      setStepSound(soundTypeWood);
   }
   
   public String getName()
   {
      return this.name;
   }
}