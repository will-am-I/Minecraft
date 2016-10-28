package cherrymod.items;

import cherrymod.Reference;
import cherrymod.entity.EntityCherryBomb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCherryBomb extends Item
{
   private String name;
   
   public ItemCherryBomb(String name)
   {
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setCreativeTab(CreativeTabs.tabCombat);
   }
   
   @Override
   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
   {
      if (!player.capabilities.isCreativeMode)
      {
         --stack.stackSize;
      }
      
      if (!world.isRemote)
      {
         world.spawnEntityInWorld(new EntityCherryBomb(world, player));
      }
      
      return stack;
   }
   
   public String getName()
   {
      return this.name;
   }
}