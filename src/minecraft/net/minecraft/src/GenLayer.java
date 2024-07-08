package net.minecraft.src;

public abstract class GenLayer
{
    /** seed from World#getWorldSeed that is used in the LCG prng */
    private long worldGenSeed;

    /** parent GenLayer that was provided via the constructor */
    protected GenLayer parent;

    /**
     * final part of the LCG prng that uses the chunk X, Z coords along with the other two seeds to generate
     * pseudorandom numbers
     */
    private long chunkSeed;

    /** base seed to the LCG prng provided via the constructor */
    private long baseSeed;

    /**
     * the first array item is a linked list of the bioms, the second is the zoom function, the third is the same as the
     * first.
     */
    public static GenLayer[] initializeAllBiomeGenerators(long par0, WorldType par2WorldType)
    {
        /**GenLayerIsland var3 = new GenLayerIsland(1L);
        GenLayerFuzzyZoom var9 = new GenLayerFuzzyZoom(2000L, var3);
        GenLayerAddIsland var10 = new GenLayerAddIsland(1L, var9);
        GenLayerZoom var11 = new GenLayerZoom(2001L, var10);
        var10 = new GenLayerAddIsland(2L, var11);
        GenLayerAddSnow var12 = new GenLayerAddSnow(2L, var10);
        var11 = new GenLayerZoom(2002L, var12);
        var10 = new GenLayerAddIsland(3L, var11);
        var11 = new GenLayerZoom(2003L, var10);
        var10 = new GenLayerAddIsland(4L, var11);
        GenLayerAddMushroomIsland var15 = new GenLayerAddMushroomIsland(5L, var10);
         GenLayer var5 = GenLayerZoom.func_75915_a(1000L, var15, 0);
         GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var5);
         var5 = GenLayerZoom.func_75915_a(1000L, var13, var4 + 2);
         GenLayerRiver var14 = new GenLayerRiver(1L, var5);
         GenLayerSmooth var16 = new GenLayerSmooth(1000L, var14);
         GenLayer var6 = GenLayerZoom.func_75915_a(1000L, var15, 0);
         GenLayerBiome var17 = new GenLayerBiome(200L, var6, par2WorldType);
         var6 = GenLayerZoom.func_75915_a(1000L, var17, 2);
         Object var18 = new GenLayerHills(1000L, var6);
         obj2 = new GenLayerVillageLandscape(200L, ((GenLayer) (obj2)));
         obj2 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj2)), 2);
         GenLayer obj3 = new GenLayerTemperature(((GenLayer) (obj2)));
         GenLayer obj4 = new GenLayerDownfall(((GenLayer) (obj2)));
         for (int var7 = 0; var7 < var4; ++var7)
         {
         var18 = new GenLayerZoom((long)(1000 + var7), (GenLayer)var18);

         if (var7 == 0)
         {
         var18 = new GenLayerAddIsland(3L, (GenLayer)var18);
         }
         }

         GenLayerSmooth var19 = new GenLayerSmooth(1000L, (GenLayer)var18);
         GenLayerRiverMix var20 = new GenLayerRiverMix(100L, var19, var16);
         GenLayerVoronoiZoom var8 = new GenLayerVoronoiZoom(10L, var20);
         var20.initWorldGenSeed(par0);
         var8.initWorldGenSeed(par0);
         return new GenLayer[] {var20, var8, var20};
         GenLayerSmooth var19 = new GenLayerSmooth(1000L, (GenLayer)obj2);
         GenLayerRiverMix var20 = new GenLayerRiverMix(100L, ((GenLayer) (obj2)), ((GenLayer) (obj1)));
         GenLayerVoronoiZoom var8 = new GenLayerVoronoiZoom(10L, var20);
         var20.initWorldGenSeed(par0);
         var8.initWorldGenSeed(par0);
         return new GenLayer[] {var20, var8, var20};
         */
        GenLayer obj = new GenLayerIsland(1L);
        obj = new GenLayerFuzzyZoom(2000L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(1L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2001L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(2L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2002L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(3L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2003L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(3L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2004L, ((GenLayer) (obj)));
        obj = new GenLayerAddIsland(3L, ((GenLayer) (obj)));
        byte var4 = 4;
        if (par2WorldType == WorldType.LARGE_BIOMES)
        {
            var4 = 6;
        }
        GenLayer obj1 = obj;
        obj1 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj1)), 0);
        obj1 = new GenLayerRiverInit(100L, ((GenLayer) (obj1)));
        obj1 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj1)), var4 + 2);
        obj1 = new GenLayerRiver(1L, ((GenLayer) (obj1)));
        obj1 = new GenLayerSmooth(1000L, ((GenLayer) (obj1)));
        GenLayer obj2 = obj;
        obj2 = GenLayerZoom.func_75915_a(1000L, ((GenLayer) (obj2)), 0);
        GenLayerBiome var17 = new GenLayerBiome(200L, obj2, par2WorldType);
        obj2 = GenLayerZoom.func_75915_a(1000L, var17, 2);
        GenLayer obj3 = new GenLayerTemperature(((GenLayer) (obj2)));
        GenLayer obj4 = new GenLayerDownfall(((GenLayer) (obj2)));
        for (int var7 = 0; var7 < var4; ++var7)
        {
            obj2 = new GenLayerZoom((long)(1000 + var7), (GenLayer)obj2);

            if (var7 == 0)
            {
                obj2 = new GenLayerAddIsland(3L, (GenLayer)obj2);
            }
            obj3 = new GenLayerSmoothZoom(1000 + var7, ((GenLayer) (obj3)));
            obj3 = new GenLayerTemperatureMix(((GenLayer) (obj3)), ((GenLayer) (obj2)), var7);
            obj4 = new GenLayerSmoothZoom(1000 + var7, ((GenLayer) (obj4)));
            obj4 = new GenLayerDownfallMix(((GenLayer) (obj4)), ((GenLayer) (obj2)), var7);
        }
        obj2 = new GenLayerSmooth(1000L, ((GenLayer) (obj2)));
        obj2 = new GenLayerRiverMix(100L, ((GenLayer) (obj2)), ((GenLayer) (obj1)));
        obj3 = GenLayerSmoothZoom.func_35517_a(1000L, ((GenLayer) (obj3)), 2);
        obj4 = GenLayerSmoothZoom.func_35517_a(1000L, ((GenLayer) (obj4)), 2);
        GenLayerVoronoiZoom genlayervoronizoom = new GenLayerVoronoiZoom(10L, ((GenLayer) (obj2)));
        ((GenLayer) (obj2)).initWorldGenSeed(par0);
        ((GenLayer) (obj3)).initWorldGenSeed(par0);
        ((GenLayer) (obj4)).initWorldGenSeed(par0);
        genlayervoronizoom.initWorldGenSeed(par0);
        return (new GenLayer[] {
                obj2, genlayervoronizoom, obj3, obj4
        });
    }

    public GenLayer(long par1)
    {
        this.baseSeed = par1;
        this.baseSeed *= this.baseSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.baseSeed += par1;
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    public void initWorldGenSeed(long par1)
    {
        this.worldGenSeed = par1;

        if (this.parent != null)
        {
            this.parent.initWorldGenSeed(par1);
        }

        this.worldGenSeed *= this.worldGenSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.worldGenSeed += this.baseSeed;
    }

    /**
     * Initialize layer's current chunkSeed based on the local worldGenSeed and the (x,z) chunk coordinates.
     */
    public void initChunkSeed(long par1, long par3)
    {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.chunkSeed += par3;
        this.chunkSeed *= this.chunkSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.chunkSeed += par3;
    }

    /**
     * returns a LCG pseudo random number from [0, x). Args: int x
     */
    protected int nextInt(int par1)
    {
        int var2 = (int)((this.chunkSeed >> 24) % (long)par1);

        if (var2 < 0)
        {
            var2 += par1;
        }

        this.chunkSeed *= this.chunkSeed * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        this.chunkSeed += this.worldGenSeed;
        return var2;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public abstract int[] getInts(int var1, int var2, int var3, int var4);

}
