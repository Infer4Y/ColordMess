package xavier.colormess.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.colormess.ColorMess;

@SideOnly(Side.CLIENT)
public class ClientProxy  extends CommonProxy{
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ColorMess.MODID + ":" + id, "inventory"));
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id, String type) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ColorMess.MODID + ":" + id, type));
    }
}
