package net.minecraft.src;

public class GenLayerRiver extends GenLayer
{
    public GenLayerRiver(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        super.parent = par3GenLayer;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int i, int j, int k, int l)
    {
        int i1 = i - 1;
        int j1 = j - 1;
        int k1 = k + 2;
        int l1 = l + 2;
        int ai[] = this.parent.getInts(i1, j1, k1, l1);
        int ai1[] = IntCache.getIntCache(k * l);
        for(int i2 = 0; i2 < l; i2++)
        {
            for(int j2 = 0; j2 < k; j2++)
            {
                int k2 = ai[j2 + 0 + (i2 + 1) * k1];
                int l2 = ai[j2 + 2 + (i2 + 1) * k1];
                int i3 = ai[j2 + 1 + (i2 + 0) * k1];
                int j3 = ai[j2 + 1 + (i2 + 2) * k1];
                int k3 = ai[j2 + 1 + (i2 + 1) * k1];
                if(k3 == 0 || k2 == 0 || l2 == 0 || i3 == 0 || j3 == 0)
                {
                    ai1[j2 + i2 * k] = BiomeGenBase.river.biomeID;
                    continue;
                }
                if(k3 != k2 || k3 != i3 || k3 != l2 || k3 != j3)
                {
                    ai1[j2 + i2 * k] = BiomeGenBase.river.biomeID;
                } else
                {
                    ai1[j2 + i2 * k] = -1;
                }
            }

        }

        return ai1;
    }


    /**
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int var5 = par1 - 1;
        int var6 = par2 - 1;
        int var7 = par3 + 2;
        int var8 = par4 + 2;
        int[] var9 = this.parent.getInts(var5, var6, var7, var8);
        int[] var10 = IntCache.getIntCache(par3 * par4);
        for (int var11 = 0; var11 < par4; ++var11)
        {

            for (int var12 = 0; var12 < par3; ++var12)
            {
                int var13 = var9[var12 + 0 + (var11 + 1) * var7];
                int var14 = var9[var12 + 2 + (var11 + 1) * var7];
                int var15 = var9[var12 + 1 + (var11 + 0) * var7];
                int var16 = var9[var12 + 1 + (var11 + 2) * var7];
                int var17 = var9[var12 + 1 + (var11 + 1) * var7];
                if(var17 == 0 || var13 == 0 || var14 == 0 || var15 == 0 || var16 == 0)
                {
                    var10[var12 + var11 * par3] = BiomeGenBase.river.biomeID;
                    continue;
                }
                if(var17 != var13 || var17 != var15 || var17 != var14 || var17 != var16)
                {
                    var10[var12 + var11 * par3] = BiomeGenBase.river.biomeID;
                } else
                {
                    var10[var12 + var11 * par3] = -1;
                }
            }
        }

        return var10;
    }
     */

}
