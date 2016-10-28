package cherrymod.items;

import cherrymod.blocks.BlockCherryDoubleSlab;
import cherrymod.blocks.BlockCherryHalfSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCherrySlab extends ItemBlock
{
   private BlockCherryHalfSlab singleSlab;
   private BlockCherryDoubleSlab doubleSlab;
   
   public ItemCherrySlab(Block block, BlockCherryHalfSlab singleSlab, BlockCherryDoubleSlab doubleSlab)
   {
      super(block);
      this.singleSlab = singleSlab;
      this.doubleSlab = doubleSlab;
   }
   
   @Override
   public int getMetadata(int damage)
   {
      return damage;
   }
   
   @Override
   public String getUnlocalizedName(ItemStack stack)
   {
      return this.singleSlab.getUnlocalizedName();
   }
   
   @Override
   public String getUnlocalizedName()
   {
      return this.singleSlab.getUnlocalizedName();
   }
   
   public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
   {
      if (stack.stackSize == 0)
      {
         return false;
      }
      else if (!player.canPlayerEdit(pos.offset(side), side, stack))
      {
         return false;
      }
      else
      {
         Object object = this.singleSlab;
         IBlockState blockstate = world.getBlockState(pos);
         
         if (blockstate.getBlock() == this.singleSlab)
         {
            EnumBlockHalf blockhalf = (EnumBlockHalf)blockstate.getValue(BlockSlab.HALF);
            
            if (side == EnumFacing.UP && blockhalf == EnumBlockHalf.BOTTOM || side == EnumFacing.DOWN && blockhalf == EnumBlockHalf.TOP)
            {
               IBlockState iblockstate = this.doubleSlab.getDefaultState();
               
               if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBox(world, pos, iblockstate)) && world.setBlockState(pos, iblockstate, 3))
               {
                  world.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), this.doubleSlab.stepSound.getPlaceSound(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getFrequency() * 0.8F);
                  --stack.stackSize;
               }
               
               return true;
            }
         }
         
         return this.tryPlace(stack, world, pos.offset(side), object) ? true : super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
      }
   }
   
   @SideOnly(Side.CLIENT)
   public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
   {
      BlockPos blockpos = pos;
      Object object = this.singleSlab;
      IBlockState blockstate = world.getBlockState(pos);
      
      if (blockstate.getBlock() == this.singleSlab)
      {
         boolean flag = blockstate.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
         
         if (side == EnumFacing.UP && !flag || side == EnumFacing.DOWN && flag)
         {
            return true;
         }
      }
      
      pos = pos.offset(side);
      IBlockState iblockstate = world.getBlockState(pos);
      
      return iblockstate.getBlock() == this.singleSlab ? true : super.canPlaceBlockOnSide(world, blockpos, side, player, stack);
   }
   
   private boolean tryPlace(ItemStack stack, World world, BlockPos pos, Object variantInStack)
   {
      IBlockState blockstate = world.getBlockState(pos);
      
      if (blockstate.getBlock() == this.singleSlab)
      {
         IBlockState iblockstate = this.doubleSlab.getDefaultState();
            
         if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBox(world, pos, iblockstate)) && world.setBlockState(pos, iblockstate, 3))
         {
            world.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), this.doubleSlab.stepSound.getPlaceSound(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getFrequency() * 0.8F);
            --stack.stackSize;
         }
         
         return true;
      }
      
      return false;
   }
}