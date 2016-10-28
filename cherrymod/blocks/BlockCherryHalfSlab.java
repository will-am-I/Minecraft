package cherrymod.blocks;

import cherrymod.Reference;

public class BlockCherryHalfSlab extends BlockCherrySlab
{
   String name;
   
   public BlockCherryHalfSlab(String name)
   {
      super();
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
   }
   
   @Override
   public boolean isDouble()
   {
      return false;
   }
   
   public String getName()
   {
      return this.name;
   }
}