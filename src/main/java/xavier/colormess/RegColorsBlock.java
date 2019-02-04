package xavier.colormess;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.colormess.blocks.BlockJelly;

@SideOnly(Side.CLIENT)
public class RegColorsBlock implements IBlockColor {
    @Override
    public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
        if (tintIndex == 0) {
            EnumDyeColor m = (EnumDyeColor) state.getValue(BlockJelly.COLOR);
            return m.getColorValue();
        } else {
            return 0xffffff;
        }
    }


}
