// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerDownfall extends GenLayer
{

    public GenLayerDownfall(GenLayer genlayer)
    {
        super(0L);
        parent = genlayer;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = parent.getInts(i, j, k, l);
        int ai1[] = IntCache.getIntCache(k * l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            ai1[i1] = BiomeGenBase.biomeList[ai[i1]].getIntRainfall();
        }

        return ai1;
    }

    @Override
    public int[] getInts(int var1, int var2, int var3, int var4) {
        return new int[0];
    }
}
