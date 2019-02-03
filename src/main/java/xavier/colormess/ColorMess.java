package xavier.colormess;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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

    }
}