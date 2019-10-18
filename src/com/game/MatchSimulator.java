package com.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

import com.player.Circumstances;
import com.player.MatchResult;
import com.player.Player;
import com.player.Skill;
import com.team.Team;

public class MatchSimulator {

	private static final int COEFFICIENT = 50;

	private static final int MATCH_CYCLE = 15;

	private RandomNumberProvider rnd;

	public MatchSimulator(RandomNumberProvider rnd) {
		this.rnd = rnd;
	}

	public MatchResult playMatch(Team t1, Team t2, Map<Circumstances, Double> circ) {

		Map<Skill, Double> team1 = calc(t1);
		Map<Skill, Double> team2 = calc(t2);

		ChanceTo ts1 = new ChanceTo();

		ts1.setWin(chanceToWin(calcSkillsSubstract(team1, team2,
				(skill) -> skill.equals(Skill.DEFENCE) || skill.equals(Skill.PLAYMAKING))));

		ts1.setScore(chanceToScore(calcSkillsSubstract(team1, team2,
				(skill) -> skill.equals(Skill.GOALTENDING) || skill.equals(Skill.OFFENCE))));

		ts1.setDefend(chanceToDefend(calcSkillsSubstract(team1, team2, (skill) -> skill.equals(Skill.DEFENCE))));

		return simulateMatch(ts1, new ChanceTo(ts1));

	}

	private double calcSkillsSubstract(Map<Skill, Double> team1, Map<Skill, Double> team2, Predicate<Skill> condition) {
		return calcSkillsValues(team1, condition) - calcSkillsValues(team2, condition);
	}

	private MatchResult simulateMatch(ChanceTo ts1, ChanceTo ts2) {

		MatchResult m = new MatchResult();

		for (int i = 0; i < MATCH_CYCLE; i++) {

			if (isGoalScored(ts1, ts2))
				m.setTeam1Goals(m.getTeam1Goals() + 1);
			if (isGoalScored(ts2, ts1))
				m.setTeam2Goals(m.getTeam1Goals() + 1);
		}
		return m;
	}

	private boolean isGoalScored(ChanceTo attacking, ChanceTo defending) {
		return (rnd() <= attacking.getWin()) && (rnd() <= attacking.getScore()) && (rnd() > defending.getDefend());
	}

	private int rnd() {
		return rnd.rnd();
	}

	private int chanceToWin(double d) {

		return (int) (COEFFICIENT + (d * 5));
	}

	private int chanceToScore(double d) {

		return (int) (COEFFICIENT + (d * 5));
	}

	private int chanceToDefend(double d) {

		return (int) (COEFFICIENT + (d * 5));
	}

	private Double calcSkillsValues(Map<Skill, Double> team, Predicate<Skill> condition) {

		Double value = 0.0;
		for (Skill skill : team.keySet()) {
			if (condition.test(skill)) {
				value += team.get(skill);
			}
		}
		return value;
	}

	public Map<Skill, Double> calc(Team t) {

		Map<Skill, Double> teamSkills = new HashMap<>();
		for (Skill skill : Skill.values()) {
			teamSkills.put(skill, calcTeamSkillFromTeam(skill, t.getPlayers()));
		}
		return teamSkills;
	}

	private Double calcTeamSkillFromTeam(Skill skill, List<Player> players) {
		Double sum = 0.0;
		for (Player player : players) {
			sum += player.getSkills().getOrDefault(skill, 0.0);
		}
		return sum;
	}
}
