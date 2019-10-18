package com.game;

public class MatchSimulatorFactory {

	public static IMatchSimulator createInstance() {

		// ...

		return new MatchSimulatorImpl(new RandomNumberProviderImpl());

	}

	public static IMatchSimulator createInstance(RandomNumberProvider rndProv) {

		// ...

		return new MatchSimulatorImpl(rndProv);

	}
}
