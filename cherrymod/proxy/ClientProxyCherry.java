package cherrymod.proxy;

import cherrymod.entity.EntityCherryBomb;
import cherrymod.items.CherryModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxyCherry extends CommonProxyCherry
{
   @Override
   public void registerItemRenders()
   {
      RenderingRegistry.registerEntityRenderingHandler(EntityCherryBomb.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), CherryModItems.cherry_bomb, Minecraft.getMinecraft().getRenderItem()));
   }
}