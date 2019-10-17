package com.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.team.Team;

public class TeamTest {

	@Test
	public void isTeamNameSet() {

		Team t = new Team();
		t.setName("Spirit");
		assertEquals("Spirit", t.getName());
	}

}
