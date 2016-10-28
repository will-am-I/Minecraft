package cherrymod.items;

import cherrymod.blocks.BlockCherryLeaves;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCherryLeaves extends ItemBlock
{
   private BlockCherryLeaves leaves;
   
   public ItemCherryLeaves(Block block, BlockCherryLeaves leaves)
   {
      super(leaves);
      this.leaves = leaves;
   }
   
   public int getMetadata(int damage)
   {
      return 0;
   }
   
   @SideOnly(Side.CLIENT)
   public int getColorFromItemStack(ItemStack stack, int renderPass)
   {
      return this.leaves.getRenderColor(this.leaves.getStateFromMeta(stack.getMetadata()));
   }
   
   public String getUnlocalizedName(ItemStack stack)
   {
      return this.leaves.getUnlocalizedName();
   }
}