// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerDownfallMix extends GenLayer
{

    public GenLayerDownfallMix(GenLayer genlayer, GenLayer genlayer1, int i)
    {
        super(0L);
        parent = genlayer1;
        field_35507_b = genlayer;
        field_35508_c = i;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = parent.getInts(i, j, k, l);
        int ai1[] = field_35507_b.getInts(i, j, k, l);
        int ai2[] = IntCache.getIntCache(k * l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            ai2[i1] = ai1[i1] + (BiomeGenBase.biomeList[ai[i1]].getIntRainfall() - ai1[i1]) / (field_35508_c + 1);
        }

        return ai2;
    }

    private GenLayer field_35507_b;
    private int field_35508_c;

    @Override
    public int[] getInts(int var1, int var2, int var3, int var4) {
        return new int[0];
    }
}
