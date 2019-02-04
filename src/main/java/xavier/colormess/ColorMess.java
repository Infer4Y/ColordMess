package xavier.colormess;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.core.Logger;
import xavier.colormess.blocks.ModBlocks;
import xavier.colormess.items.ModItems;
import xavier.colormess.proxy.CommonProxy;

@Mod(modid = ColorMess.MODID, name = ColorMess.NAME, version = ColorMess.VERSION)
public class ColorMess
{
    public static final String MODID = "colormess";
    public static final String NAME = "Color Mess";
    public static final String VERSION = "1.0";
    @SidedProxy(serverSide = "xavier.colormess.proxy.CommonProxy", clientSide = "xavier.colormess.proxy.ClientProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @Mod.Instance(MODID)
    public static ColorMess instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModBlocks.registerItemBlocks(event.getRegistry());
            ModItems.register(event.getRegistry());

        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModBlocks.registerModels();
            ModItems.registerModels();
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public void onColorHandlerItem(ColorHandlerEvent.Item event) {
            event.getItemColors().registerItemColorHandler(new RegColorItem(), Item.getItemFromBlock(ModBlocks.jelly));
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void onColorHandler(ColorHandlerEvent.Block event) {
            event.getBlockColors().registerBlockColorHandler(new RegColorsBlock(), ModBlocks.jelly);
        }

    }
}