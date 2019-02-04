package xavier.colormess.blocks;

import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xavier.colormess.ColorMess;

public class BlockJelly extends BlockColored {
    protected String name;

    public BlockJelly(Material material, String name) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
        entityIn.addVelocity(entityIn.motionX*-1, entityIn.motionY*-1, entityIn.motionZ*-1 );
    }

    public void registerItemModel(Item itemBlock) {
        for (int i = 0; i < 16; i++) {
            ColorMess.proxy.registerItemRenderer(itemBlock, i, name, "color=".concat(EnumDyeColor.byMetadata(i).getName()));
        }
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName()).setHasSubtypes(true);
    }

}
