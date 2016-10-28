package cherrymod.generation;

import java.util.Random;
import cherrymod.blocks.CherryModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTree extends WorldGenerator
{
   @Override
   public boolean generate(World world, Random rand, BlockPos pos)
   {
      boolean generated = false;
      
      if (world.getChunkFromBlockCoords(pos).getBiome(pos, world.getWorldChunkManager()).biomeName == "Plains")
      {
         for (int i = 0; i < 64; i++)
         {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            
            if (CherryModBlocks.cherry_sapling.canPlaceBlockAt(world, blockpos) && world.getBlockState(blockpos.down()).getBlock() == Blocks.grass && world.getBlockState(blockpos.up()).getBlock() == Blocks.air && world.getBlockState(blockpos.up(2)).getBlock() == Blocks.air && !generated)
            {
               generated = new WorldGenCherryTree().generate(world, rand, blockpos);
            }
         }
         
         return true;
      }
      else
      {
         return false;
      }
   }
}