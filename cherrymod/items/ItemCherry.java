package cherrymod.items;

import cherrymod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemCherry extends ItemFood
{
   String name;
   
   public ItemCherry(int amount, float saturation, boolean isWolfFood, String name)
   {
      super(amount, saturation, isWolfFood);
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + "cherry");
      setCreativeTab(CreativeTabs.tabFood);
   }
   
   public String getName()
   {
      return this.name;
   }
}