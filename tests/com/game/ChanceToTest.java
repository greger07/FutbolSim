package com.game;

import org.junit.Assert;
import org.junit.Test;

import com.game.ChanceTo;

public class ChanceToTest {

	@Test
	public void eqTeam1AndTeam2ChanceEqual() {
		
		ChanceTo ct1 = new ChanceTo();
		ct1.setDefend(50);
		ct1.setScore(50);
		ct1.setWin(50);
		ChanceTo ct2 = new ChanceTo(ct1);
		
		Assert.assertTrue(ct1.getDefend() == ct2.getDefend());
		Assert.assertTrue(ct1.getScore() == ct2.getScore());
		Assert.assertTrue(ct1.getWin() == ct2.getWin());
	}

}
