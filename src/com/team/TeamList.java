package com.team;

import java.util.ArrayList;

import com.game.TeamSkillsCalc;
import com.player.Player;

public class TeamList extends ArrayList<Player> {

	@Override
	public boolean add(Player e) {

		if (size() >= TeamSkillsCalc.TEAMSIZE) {
			throw new RuntimeException("To big... ");
		}

		return super.add(e);
	}
}
