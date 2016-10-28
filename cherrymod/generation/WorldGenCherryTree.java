package cherrymod.generation;

import java.util.Random;
import cherrymod.blocks.CherryModBlocks;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCherryTree extends WorldGenerator
{
   int height;
   IBlockState wood = CherryModBlocks.cherry_log.getDefaultState();
   IBlockState leaf = CherryModBlocks.cherry_leaves.getDefaultState();
   
   public boolean generate(World world, Random rand, BlockPos pos)
   {
      while (world.isAirBlock(pos.down()) && pos.getY() > 55)
      {
         pos.subtract(new Vec3i(0, 1, 0));
      }
      
      if (world.getBlockState(pos).getBlock() != Blocks.air && world.getBlockState(pos).getBlock() != CherryModBlocks.cherry_sapling && world.getBlockState(pos).getBlock() != Blocks.tallgrass && world.getBlockState(pos).getBlock() != Blocks.red_flower && world.getBlockState(pos).getBlock() != Blocks.yellow_flower)
      {
      	  return false;
      }
      
      height = 2;
      
      for (int i = 0; i < height; i++)
      {
         world.setBlockState(pos.up(i), wood);
      }
      
      int top = 3;
      int left = 3;
      int right = 3;
      int front = 3;
      int back = 3;
      
      for (int i = 0; i < top; i++)
      {
         setBlock(world, pos.getX(), pos.getY() + i, pos.getZ(), wood);
         
         if (i > 0)
         {
            setBlock(world, pos.getX() + 1, pos.getY() + i + 1, pos.getZ(), leaf);
            setBlock(world, pos.getX() - 1, pos.getY() + i + 1, pos.getZ(), leaf);
            setBlock(world, pos.getX(), pos.getY() + i + 1, pos.getZ() + 1, leaf);
            setBlock(world, pos.getX(), pos.getY() + i + 1, pos.getZ() - 1, leaf);
            setBlock(world, pos.getX(), pos.getY() + i + 1, pos.getZ(), leaf);
            
            if (i == top - 1)
            {
               setBlock(world, pos.getX() + 1, pos.getY() + i, pos.getZ() + 1, leaf);
               setBlock(world, pos.getX() + 1, pos.getY() + i, pos.getZ() - 1, leaf);
               setBlock(world, pos.getX() - 1, pos.getY() + i, pos.getZ() + 1, leaf);
               setBlock(world, pos.getX() - 1, pos.getY() + i, pos.getZ() - 1, leaf);
            }
         }
      }
      
      for (int i = 0; i < left; i++)
      {
         if (i > 0)
         {
            if (i == 1)
            {
               setBlock(world, pos.getX() + i, pos.getY() + 1, pos.getZ(), wood.withProperty(BlockLog.LOG_AXIS, EnumAxis.X));
            }
            else
            {
               setBlock(world, pos.getX() + i, pos.getY() + 1, pos.getZ(), leaf);
            }
            setBlock(world, pos.getX() + i, pos.getY(), pos.getZ(), leaf);
            setBlock(world, pos.getX() + i, pos.getY(), pos.getZ() + 1, leaf);
            setBlock(world, pos.getX() + i, pos.getY(), pos.getZ() - 1, leaf);
            setBlock(world, pos.getX() + i, pos.getY() + 1, pos.getZ() + 1, leaf);
            setBlock(world, pos.getX() + i, pos.getY() + 1, pos.getZ() - 1, leaf);
            
            if (i == left - 1)
            {
               setBlock(world, pos.getX() + i, pos.getY() + 2, pos.getZ(), leaf);
            }
         }
      }
      
      for (int i = 0; i < right; i++)
      {
         if (i > 0)
         {
            if (i == 1)
            {
               setBlock(world, pos.getX() - i, pos.getY() + 1, pos.getZ(), wood.withProperty(BlockLog.LOG_AXIS, EnumAxis.X));
            }
            else
            {
               setBlock(world, pos.getX() - i, pos.getY() + 1, pos.getZ(), leaf);
            }
            setBlock(world, pos.getX() - i, pos.getY(), pos.getZ(), leaf);
            setBlock(world, pos.getX() - i, pos.getY(), pos.getZ() + 1, leaf);
            setBlock(world, pos.getX() - i, pos.getY(), pos.getZ() - 1, leaf);
            setBlock(world, pos.getX() - i, pos.getY() + 1, pos.getZ() + 1, leaf);
            setBlock(world, pos.getX() - i, pos.getY() + 1, pos.getZ() - 1, leaf);
            
            if (i == right - 1)
            {
               setBlock(world, pos.getX() - i, pos.getY() + 2, pos.getZ(), leaf);
            }
         }
      }
      
      for (int i = 0; i < front; i++)
      {
         if (i > 0)
         {
            if (i == 1)
            {
               setBlock(world, pos.getX(), pos.getY() + 1, pos.getZ() + i, wood.withProperty(BlockLog.LOG_AXIS, EnumAxis.Z));
            }
            else
            {
               setBlock(world, pos.getX(), pos.getY() + 1, pos.getZ() + i, leaf);
            }
            setBlock(world, pos.getX(), pos.getY(), pos.getZ() + i, leaf);
            setBlock(world, pos.getX() + 1, pos.getY(), pos.getZ() + i, leaf);
            setBlock(world, pos.getX() - 1, pos.getY(), pos.getZ() + i, leaf);
            setBlock(world, pos.getX() + 1, pos.getY() + 1, pos.getZ() + i, leaf);
            setBlock(world, pos.getX() - 1, pos.getY() + 1, pos.getZ() + i, leaf);
            
            if (i == front - 1)
            {
               setBlock(world, pos.getX(), pos.getY() + 2, pos.getZ() + i, leaf);
            }
         }
      }
      
      for (int i = 0; i < back; i++)
      {
         if (i > 0)
         {
            if (i == 1)
            {
               setBlock(world, pos.getX(), pos.getY() + 1, pos.getZ() - i, wood.withProperty(BlockLog.LOG_AXIS, EnumAxis.Z));
            }
            else
            {
               setBlock(world, pos.getX(), pos.getY() + 1, pos.getZ() - i, leaf);
            }
            setBlock(world, pos.getX(), pos.getY(), pos.getZ() - i, leaf);
            setBlock(world, pos.getX() + 1, pos.getY(), pos.getZ() - i, leaf);
            setBlock(world, pos.getX() - 1, pos.getY(), pos.getZ() - i, leaf);
            setBlock(world, pos.getX() + 1, pos.getY() + 1, pos.getZ() - i, leaf);
            setBlock(world, pos.getX() - 1, pos.getY() + 1, pos.getZ() - i, leaf);
            
            if (i == back - 1)
            {
               setBlock(world, pos.getX(), pos.getY() + 2, pos.getZ() - i, leaf);
            }
         }
      }
      
      return true;
   }

   private void setBlock(World world, int x, int y, int z, IBlockState block)
   {
      world.setBlockState(new BlockPos(x, y + height, z), block);
   }
}