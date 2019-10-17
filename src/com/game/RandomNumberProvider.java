package com.game;

import java.util.Random;

public class RandomNumberProvider {
	private static final int MAX_RANDOM_VALUE = 100;
	private Random random = new Random();

	public int rnd() {

		// return random.nextInt(MAX_RANDOM_VALUE)+1;

		return random.nextInt(MAX_RANDOM_VALUE)+1;
	}
}
