package cherrymod.blocks;

import java.util.Random;
import cherrymod.Reference;
import cherrymod.generation.WorldGenCherryTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockCherrySapling extends BlockBush implements IGrowable
{
   public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
   
   private String name;
   
   public BlockCherrySapling(String name)
   {
      float f = 0.4F;
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setTickRandomly(true);
      setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
      setCreativeTab(CreativeTabs.tabDecorations);
      setHardness(0.0F);
      setStepSound(soundTypeGrass);
      setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
   }
   
   public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
   {
      if (!world.isRemote)
      {
         super.updateTick(world, pos, state, rand);
         
         if (world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
         {
            this.grow(world, rand, pos, state);
         }
      }
   }

   @Override
   public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient)
   {
      return true;
   }

   @Override
   public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
   {
      return (double)world.rand.nextFloat() < 0.45D;
   }

   @Override
   public void grow(World world, Random rand, BlockPos pos, IBlockState state)
   {
      if (((Integer)state.getValue(STAGE)).intValue() == 0)
      {
         world.setBlockState(pos, state.cycleProperty(STAGE), 4);
      }
      else
      {
         this.generateTree(world, pos, state, rand);
      }
   }
   
   public void generateTree(World world, BlockPos pos, IBlockState state, Random rand)
   {
      if (!TerrainGen.saplingGrowTree(world, rand, pos))
      {
         return;
      }
      
      Object object = new WorldGenCherryTree();
      
      if (!((WorldGenerator)object).generate(world, rand, pos.add(0, 0, 0)))
      {
         world.setBlockState(pos, state, 4);
      }
   }
   
   @Override
   public boolean canPlaceBlockOn(Block block)
   {
      return block == Blocks.dirt || block == Blocks.grass;
   }
   
   @Override
   public IBlockState getStateFromMeta(int meta)
   {
      return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
   }
   
   @Override
   public int getMetaFromState(IBlockState state)
   {
      return ((Integer)state.getValue(STAGE)).intValue() << 3;
   }
   
   @Override
   protected BlockState createBlockState()
   {
      return new BlockState(this, new IProperty[] {STAGE}); 
   }
   
   public String getName()
   {
      return this.name;
   }
}