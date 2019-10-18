package com.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.player.Player;
import com.player.Skill;

public class TeamSkillsCalc {

	public static final int TEAMSIZE = 11;

	public Map<Skill, Double> calc(List<Player> players) {

		if (players.size() > TEAMSIZE) {
			throw new RuntimeException("Team size " + players.size());
		}

		Map<Skill, Double> teamSkills = new HashMap<>();
		for (Skill skill : Skill.values()) {
			teamSkills.put(skill, calcTeamSkillFromTeam(skill, players));
		}

		teamSkills.put(Skill.TEAMSIZE, 1.0 * players.size() / TEAMSIZE);

		return teamSkills;

	}

	private Double calcTeamSkillFromTeam(Skill skill, List<Player> players) {

		Double sum = 0.0;
		for (Player player : players) {
			sum += player.getSkills().getOrDefault(skill, 0.0);

		}

		return sum / players.size();
	}

}
