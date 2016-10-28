package cherrymod.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockCherrySlab extends BlockSlab
{
   private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");
   
   public BlockCherrySlab()
   {
      super(Material.wood);
      
      IBlockState state = this.blockState.getBaseState();
      state = state.withProperty(VARIANT_PROPERTY, false);
      
      if (!this.isDouble())
      {
         state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
         setCreativeTab(CreativeTabs.tabBlock);
      }
      
      setDefaultState(state);
      setHardness(2.0f);
      setResistance(5.0f);
      setStepSound(soundTypeWood);
      
      useNeighborBrightness = !this.isDouble();
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side)
   {
      if (this.isDouble())
      {
         return side == EnumFacing.DOWN && this.minY > 0.0D ? true : (side == EnumFacing.UP && this.maxY < 1.0D ? true : (side == EnumFacing.NORTH && this.minZ > 0.0D ? true : (side == EnumFacing.SOUTH && this.maxZ < 1.0D ? true : (side == EnumFacing.WEST && this.minX > 0.0D ? true : (side == EnumFacing.EAST && this.maxX < 1.0D ? true : !world.getBlockState(pos).getBlock().isOpaqueCube())))));
      }
      else if (side != EnumFacing.UP && side != EnumFacing.DOWN && !(side == EnumFacing.DOWN && this.minY > 0.0D ? true : (side == EnumFacing.UP && this.maxY < 1.0D ? true : (side == EnumFacing.NORTH && this.minZ > 0.0D ? true : (side == EnumFacing.SOUTH && this.maxZ < 1.0D ? true : (side == EnumFacing.WEST && this.minX > 0.0D ? true : (side == EnumFacing.EAST && this.maxX < 1.0D ? true : !world.getBlockState(pos).getBlock().isOpaqueCube())))))))
      {
         return false;
      }
      else
      {
         BlockPos blockpos = pos.offset(side.getOpposite());
         IBlockState state1 = world.getBlockState(pos);
         IBlockState state2 = world.getBlockState(blockpos);
         boolean flag1 = isSlab(state1.getBlock()) && state1.getValue(HALF) == EnumBlockHalf.TOP;
         boolean flag2 = isSlab(state2.getBlock()) && state2.getValue(HALF) == EnumBlockHalf.TOP;
         
         return flag2 ? (side == EnumFacing.DOWN ? true : (side == EnumFacing.UP && side == EnumFacing.DOWN && this.minY > 0.0D ? true : (side == EnumFacing.UP && this.maxY < 1.0D ? true : (side == EnumFacing.NORTH && this.minZ > 0.0D ? true : (side == EnumFacing.SOUTH && this.maxZ < 1.0D ? true : (side == EnumFacing.WEST && this.minX > 0.0D ? true : (side == EnumFacing.EAST && this.maxX < 1.0D ? true : !world.getBlockState(pos).getBlock().isOpaqueCube()))))) ? true : !isSlab(state1.getBlock()) || !flag1)) : (side == EnumFacing.UP ? true : (side == EnumFacing.DOWN && super.shouldSideBeRendered(world, blockpos, side) ? true : !isSlab(state1.getBlock()) || flag1));
      }
   }
   
   protected static boolean isSlab(Block block)
   {
      return block == Blocks.stone_slab || block == Blocks.stone_slab2 || block == Blocks.wooden_slab || block == CherryModBlocks.cherry_half_slab;
   }

   @Override
   public Item getItemDropped(IBlockState state, Random rand, int fortune)
   {
      return Item.getItemFromBlock(CherryModBlocks.cherry_half_slab);
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public Item getItem(World world, BlockPos pos)
   {
      return Item.getItemFromBlock(CherryModBlocks.cherry_half_slab);
   }
   
   @Override
   public String getUnlocalizedName(int meta)
   {
      return this.getUnlocalizedName();
   }
   
   @Override
   protected BlockState createBlockState()
   {
      return this.isDouble() ? new BlockState(this, new IProperty[] {VARIANT_PROPERTY}) : new BlockState(this, new IProperty[] {VARIANT_PROPERTY, HALF});
   }
   
   @Override
   public IProperty getVariantProperty()
   {
      return VARIANT_PROPERTY;
   }
   
   @Override
   public Object getVariant(ItemStack stack)
   {
      return false;
   }
   
   @Override
   public IBlockState getStateFromMeta(int meta)
   {
      IBlockState state = this.getDefaultState().withProperty(VARIANT_PROPERTY, false);
      
      if (!this.isDouble())
      {
         state = state.withProperty(HALF, (meta & 8) == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
      }
      
      return state;
   }
   
   @Override
   public int getMetaFromState(IBlockState state)
   {
      if (this.isDouble())
      {
         return 0;
      }
      
      if ((EnumBlockHalf)state.getValue(HALF) == EnumBlockHalf.TOP)
      {
         return 8;
      }
      else
      {
         return 0;
      }
   }
   
   @Override
   public int damageDropped(IBlockState state)
   {
      return 0;
   }
}