package cherrymod.items;

import cherrymod.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDoor;

public class ItemCherryDoor extends ItemDoor
{
   private String name;
   
   public ItemCherryDoor(Block block, String name)
   {
      super(block);
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setCreativeTab(CreativeTabs.tabRedstone);
   }
   
   public String getName()
   {
      return this.name;
   }
}