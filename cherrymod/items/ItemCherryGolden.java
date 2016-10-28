package cherrymod.items;

import cherrymod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemCherryGolden extends ItemFood
{
   private String name;
   
   public ItemCherryGolden(int food, float saturation, boolean wolfFood, String name)
   {
      super(food, saturation, wolfFood);
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setCreativeTab(CreativeTabs.tabFood);
      setPotionEffect(Potion.absorption.id, 30, 0, 1f);
      setAlwaysEdible();
   }
   
   public String getName()
   {
      return this.name;
   }
}