 package cherrymod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import cherrymod.Reference;
import cherrymod.items.CherryModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCherryLeaves extends BlockLeaves
{
   String name;
   
   public BlockCherryLeaves(String name)
   {
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public int getBlockColor()
   {
      return 14725585;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public int getRenderColor(IBlockState state)
   {
      return 14725585;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public int colorMultiplier(IBlockAccess world, BlockPos pos, int renderPass)
   {
      return 14725585;
   }
   
   @Override
   public Item getItemDropped(IBlockState state, Random rand, int fortune)
   {
      return Item.getItemFromBlock(CherryModBlocks.cherry_sapling);
   }
   
   protected void dropApple(World world, BlockPos pos, IBlockState state, int chance)
   {
      if (world.rand.nextInt(chance) == 0)
      {
         spawnAsEntity(world, pos, new ItemStack(CherryModItems.cherry, 1, 0));
      }
   }
   
   @Override
   public boolean isOpaqueCube()
   {
      return Blocks.leaves.isOpaqueCube();
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public EnumWorldBlockLayer getBlockLayer()
   {
      return Blocks.leaves.getBlockLayer();
   }
   
   @Override
   public int damageDropped(IBlockState state)
   {
      return 0;
   }
   
   public int getDamageValue(World world, BlockPos pos)
   {
      return 0;
   }
   
   protected ItemStack createStackedBlock(IBlockState state)
   {
      return new ItemStack(Item.getItemFromBlock(this), 1);
   }
   
   @Override
   protected int getSaplingDropChance(IBlockState state)
   {
      return 15;
   }
   
   @Override
   public IBlockState getStateFromMeta(int meta)
   {
      return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
   }
   
   @Override
   public int getMetaFromState(IBlockState state)
   {
      int i = 0;
      
      if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
      {
         i |= 4;
      }
      
      if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
      {
         i |= 8;
      }
      
      return i;
   }

   @Override
   public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
   {
      return new ArrayList(java.util.Arrays.asList(new ItemStack(this, 1)));
   }

   @Override
   public EnumType getWoodType(int meta)
   {
      return null;
   }
   
   protected BlockState createBlockState()
   {
      return new BlockState(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
   }
   
   public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile)
   {
      if (!world.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.shears)
      {
          player.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
      }
      else
      {
          super.harvestBlock(world, player, pos, state, tile);
      }
   }
   
   @Override
   public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
   {
      List<ItemStack> ret = new ArrayList<ItemStack>();
      Random rand = world instanceof World ? ((World)world).rand : new Random();
      int chance = this.getSaplingDropChance(state);
      
      if (fortune > 0)
      {
         chance -= 2 << fortune;
         
         if (chance < 10)
         {
            chance = 10;
         }
      }
      
      if (rand.nextInt(chance) == 0)
      {
         ret.add(new ItemStack(this.getItemDropped(state, rand, fortune), 1, this.damageDropped(state)));
      }
      
      chance = 200;
      
      if (fortune > 0)
      {
         chance -= 10 << fortune;
         
         if (chance < 40)
         {
            chance = 40;
         }
      }
      
      this.captureDrops(true);
      
      if (world instanceof World)
      {
         this.dropApple((World)world, pos, state, chance);
      }
      
      ret.addAll(this.captureDrops(false));
      
      return ret;
   }
   
   public String getName()
   {
      return this.name;
   }
}