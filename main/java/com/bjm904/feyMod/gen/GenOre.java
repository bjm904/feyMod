package com.bjm904.feyMod.gen; //Change to your package's name

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.bjm904.feyMod.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class GenOre implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
		IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//Do different things to generate / not generate in the overworld, the nether and the end
		switch(world.provider.dimensionId) {
		case -1 :
			generateInNether(world, random, chunkX*16, chunkZ*16);
			break;
		case 0 :
			generateInOverworld(world, random, chunkX*16, chunkZ*16);
			break;
		case 1 :
			generateInEnd(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}

	public void generateInEnd(World world, Random random, int x, int y) {
		//Since we don't want it in the end, this is empty
	}

	public void generateInOverworld(World world, Random random, int x, int z) {
		for(int i=0; i<16; i++) { //How many veins spawn per chunk
			int xcoord = x + random.nextInt(16); //Sets random coords for the x axis
			int ycoord =  random.nextInt(256); //Sets random coords for the y axis
			int zcoord = z + random.nextInt(16); //Sets random coords for the z axis 
			new WorldGenMinable(ModBlocks.lectrossOre, 5).generate(world, random, xcoord, ycoord, zcoord); //Generates it (the number is the max amount of blocks in each vein).
		}
	}

	public void generateInNether(World world, Random random, int x, int y) {
		//Since we don't want it in the nether, this is empty
	}
}