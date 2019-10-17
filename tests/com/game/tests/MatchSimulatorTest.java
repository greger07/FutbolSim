package com.game.tests;

import org.junit.Assert;
import org.junit.Test;

import com.game.MatchSimulator;
import com.game.RandomNumberProvider;

public class MatchSimulatorTest {

	private MatchSimulator ms = new MatchSimulator(new RandomNumberProvider());

	@Test
	public void isChanceToWinValuePositiveOrZero() {
		Assert.assertEquals(44, ms.chanceToWin(-1.1));
	}
	
	@Test
	public void isChanceToScorePositiveOrZero() {
		Assert.assertEquals(44, ms.chanceToScore(-1.1));
	}
	
	@Test
	public void isChanceToDefendPositiveOrZero() {
		Assert.assertEquals(44, ms.chanceToDefend(-1.1));
	}
	

}
