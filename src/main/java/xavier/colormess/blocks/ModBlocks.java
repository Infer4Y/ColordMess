package xavier.colormess.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    public static BlockJelly jelly = new BlockJelly(Material.GROUND,"jelly");
    public static void register(IForgeRegistry<Block> registry) {
        registry.register(jelly);

    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.register(jelly.createItemBlock());

    }

    public static void registerModels() {
        jelly.registerItemModel(Item.getItemFromBlock(jelly));

    }
}
