package cherrymod.blocks;

import cherrymod.Reference;

public class BlockCherryDoubleSlab extends BlockCherrySlab
{
   String name;
   
   public BlockCherryDoubleSlab(String name)
   {
      super();
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
   }
   
   @Override
   public boolean isDouble()
   {
      return true;
   }
   
   public String getName()
   {
      return this.name;
   }
}