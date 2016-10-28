package cherrymod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCherryBomb extends EntityThrowable
{
   public EntityCherryBomb(World world)
   {
      super(world);
   }
   
   public EntityCherryBomb(World world, EntityLivingBase player)
   {
      super(world, player);
   }
   
   public EntityCherryBomb(World world, double x, double y, double z)
   {
      super(world, x, y, z);
   }
   
   @Override
   protected void onImpact(MovingObjectPosition position)
   {
      if (!this.worldObj.isRemote)
      {
         this.worldObj.newExplosion(this, posX, posY, posZ, 2, true, true);
         
         this.setDead();
      }
   }
   
   @Override
   protected float getGravityVelocity()
   {
      return 0.04f;
   }
   
   @Override
   protected float getVelocity()
   {
      return 0.9f;
   }
}