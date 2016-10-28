package cherrymod.handler;

import java.util.Random;
import cherrymod.generation.WorldGenTree;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator
{
   @Override
   public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
   {
      switch (world.provider.getDimensionId())
      {
         case -1:
            generateNether(world, rand, chunkX * 16, chunkZ * 16);
            break;
         case 0:
            generateSurface(world, rand, chunkX * 16, chunkZ * 16);
            break;
         case 1:
            generateEnd(world, rand, chunkX * 16, chunkZ * 16);
      }
   }
   
   private void generateNether(World world, Random rand, int x, int z)
   {
      
   }
   
   private void generateSurface(World world, Random rand, int x, int z)
   {
      int posX = x + rand.nextInt(16);
      int posY = 50 + rand.nextInt(35);
      int posZ = z + rand.nextInt(16);
      
      new WorldGenTree().generate(world, rand, new BlockPos(posX, posY, posZ));
   }
   
   private void generateEnd(World world, Random rand, int x, int z)
   {
      
   }
}