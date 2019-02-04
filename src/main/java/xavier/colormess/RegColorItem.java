package xavier.colormess;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.colormess.blocks.BlockJelly;

/**
 * Created by Mary on 2/3/2019.
 */
@SideOnly(Side.CLIENT)
public class RegColorItem implements IItemColor {


    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        return EnumDyeColor.values()[stack.getItemDamage()].getColorValue();
    }
}
