package cherrymod.items;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemPotionResistance extends ItemPotion
{
   private String name;
   
   public ItemPotionResistance(String name)
   {
      this.name = name;
      
      setHasSubtypes(false);
   }
   
   @Override
   public List getEffects(ItemStack stack)
   {
      ArrayList list = Lists.newArrayList();
      PotionEffect potioneffect = new PotionEffect(Potion.resistance.id, 50, 0);
      
      list.add(potioneffect);
      
      return list;
   }
   
   @Override
   public List getEffects(int meta)
   {
      ArrayList list = Lists.newArrayList();
      PotionEffect potioneffect = new PotionEffect(Potion.resistance.id, 50, 0);
      
      list.add(potioneffect);
      
      return list;
   }
   
   public String getName()
   {
      return this.name;
   }
}