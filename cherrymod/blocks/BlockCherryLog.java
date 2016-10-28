package cherrymod.blocks;

import cherrymod.Reference;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockCherryLog extends BlockLog
{
   String name;

   public BlockCherryLog(String name)
   {
      super();
      this.name = name;
      
      setUnlocalizedName(Reference.MODID + "_" + name);
      setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
   }

   public IBlockState getStateFromMeta(int meta)
   {
      IBlockState state = this.getDefaultState();
      
      switch (meta & 12)
      {
         case 0 :
            state = state.withProperty(LOG_AXIS, EnumAxis.Y);
            break;
         case 4 :
            state = state.withProperty(LOG_AXIS, EnumAxis.X);
            break;
         case 8 :
            state = state.withProperty(LOG_AXIS, EnumAxis.Z);
            break;
         default :
            state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
      }
      
      return state;
   }

   public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		
		switch (SwitchEnumAxis.AXIS_LOOKUP[((EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
		{
		   case 1:
		      i |= 4;
		      break;
		   case 2:
		      i |= 8;
		      break;
		   case 3:
		      i |= 12;
		      break;
		}
		
		return i;
	}
   
   protected BlockState createBlockState()
   {
      return new BlockState(this, new IProperty[] {LOG_AXIS});
   }
   
   protected ItemStack createStackedBlock(IBlockState state)
   {
      return new ItemStack(Item.getItemFromBlock(this), 1);
   }
   
   public int damageDropped(IBlockState state)
   {
      return 0;
   }

   public String getName()
   {
      return this.name;
   }
   
   static final class SwitchEnumAxis
   {
      static final int[] AXIS_LOOKUP = new int[EnumAxis.values().length];
      
      static
      {
         try
         {
            AXIS_LOOKUP[EnumAxis.X.ordinal()] = 1;
         }
         catch (NoSuchFieldError e)
         {
            ;
         }
         
         try
         {
            AXIS_LOOKUP[EnumAxis.Z.ordinal()] = 2;
         }
         catch (NoSuchFieldError e)
         {
            ;
         }
         
         try
         {
            AXIS_LOOKUP[EnumAxis.NONE.ordinal()] = 3;
         }
         catch (NoSuchFieldError e)
         {
            ;
         }
      }
   }
}