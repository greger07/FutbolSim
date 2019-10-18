package com.game;

import java.util.Random;

public class RandomNumberProviderImpl implements RandomNumberProvider {
	private static final int MAX_RANDOM_VALUE = 100;
	private Random random = new Random();

	public int calcPropability() {
		return random.nextInt(MAX_RANDOM_VALUE) + 1;
	}
}
