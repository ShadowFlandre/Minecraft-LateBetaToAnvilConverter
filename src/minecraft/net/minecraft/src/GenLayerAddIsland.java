package net.minecraft.src;

public class GenLayerAddIsland extends GenLayer
{
    public GenLayerAddIsland(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        this.parent = par3GenLayer;
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
                int k2 = ai[j2 + 0 + (i2 + 0) * k1];
                int l2 = ai[j2 + 2 + (i2 + 0) * k1];
                int i3 = ai[j2 + 0 + (i2 + 2) * k1];
                int j3 = ai[j2 + 2 + (i2 + 2) * k1];
                int k3 = ai[j2 + 1 + (i2 + 1) * k1];
                this.initChunkSeed(j2 + i, i2 + j);
                if(k3 == 0 && (k2 != 0 || l2 != 0 || i3 != 0 || j3 != 0))
                {
                    ai1[j2 + i2 * k] = 0 + this.nextInt(3) / 2;
                    continue;
                }
                if(k3 == 1 && (k2 != 1 || l2 != 1 || i3 != 1 || j3 != 1))
                {
                    ai1[j2 + i2 * k] = 1 - this.nextInt(5) / 4;
                } else
                {
                    ai1[j2 + i2 * k] = k3;
                }
            }

        }

        return ai1;

        /**
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
                int var13 = var9[var12 + 0 + (var11 + 0) * var7];
                int var14 = var9[var12 + 2 + (var11 + 0) * var7];
                int var15 = var9[var12 + 0 + (var11 + 2) * var7];
                int var16 = var9[var12 + 2 + (var11 + 2) * var7];
                int var17 = var9[var12 + 1 + (var11 + 1) * var7];
                this.initChunkSeed((long)(var12 + par1), (long)(var11 + par2));

                if (var17 == 0 && (var13 != 0 || var14 != 0 || var15 != 0 || var16 != 0))
                {
                    int var18 = 1;
                    int var19 = 1;

                    if (var13 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var13;
                    }

                    if (var14 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var14;
                    }

                    if (var15 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var15;
                    }

                    if (var16 != 0 && this.nextInt(var18++) == 0)
                    {
                        var19 = var16;
                    }

                    if (this.nextInt(3) == 0)
                    {
                        var10[var12 + var11 * par3] = var19;
                    }
                    else
                    {
                        var10[var12 + var11 * par3] = 0;
                    }
                }
                else if (var17 > 0 && (var13 == 0 || var14 == 0 || var15 == 0 || var16 == 0))
                {
                    if (this.nextInt(5) == 0)
                    {
                            var10[var12 + var11 * par3] = 0;
                    }
                    else
                    {
                        var10[var12 + var11 * par3] = var17;
                    }
                }
                else
                {
                    var10[var12 + var11 * par3] = var17;
                }
            }
        }


        return var10;
         */
    }
}
