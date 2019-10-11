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
	private static final int MAX_RANDOM_VALUE = 100;

	public MatchResult playMatch(Team t1, Team t2, Map<Circumstances, Double> circ) {

		// team skills values
		Map<Skill, Double> team1 = calc(t1);
		Map<Skill, Double> team2 = calc(t2);

		int chanceToWinCoefficientTeam1 = chanceToWin(
				calcSkillsValues(team1, (skill) -> !skill.equals(Skill.GOALTENDING))
						- calcSkillsValues(team2, (skill) -> !skill.equals(Skill.GOALTENDING)));
		int chanceToWinCoefficientTeam2 = 100 - chanceToWinCoefficientTeam1;

		int chanceToScoreCoefficientTeam1 = chanceToScore(calcSkillsValues(team1,
				(skill) -> skill.equals(Skill.GOALTENDING) || skill.equals(Skill.OFFENCE))
				- calcSkillsValues(team2, (skill) -> skill.equals(Skill.GOALTENDING) || skill.equals(Skill.OFFENCE)));
		int chanceToScoreCoefficientTeam2 = 100 - chanceToScoreCoefficientTeam1;

		//
		int chanceToDefendCoefficientTeam1 = chanceToDefend(
				calcSkillsValues(team1, (skill) -> skill.equals(Skill.DEFENCE))
						- calcSkillsValues(team2, (skill) -> skill.equals(Skill.DEFENCE)));
		int chanceToDefendCoefficientTeam2 = 100 - chanceToDefendCoefficientTeam1;

		int[] matchScore = simulateMatch(chanceToWinCoefficientTeam1, chanceToWinCoefficientTeam2,
				chanceToScoreCoefficientTeam1, chanceToScoreCoefficientTeam2, chanceToDefendCoefficientTeam1,
				chanceToDefendCoefficientTeam2);

		MatchResult mResult = new MatchResult();
		mResult.setTeam1Goals(matchScore[0]);
		mResult.setTeam2Goals(matchScore[1]);

		return mResult;

	}

	private int[] simulateMatch(int chanceToWinCoefficientTeam1, int chanceToWinCoefficientTeam2,
			int chanceToScoreCoefficientTeam1, int chanceToScoreCoefficientTeam2, int chanceToDefendCoefficientTeam1,
			int chanceToDefendCoefficientTeam2) {

		int[] matchResult = new int[2];

		for (int i = 0; i < 90; i++) {
			if (doAttack(chanceToWinCoefficientTeam1)) {
				if (tryToScoreGoal(chanceToScoreCoefficientTeam1)) {
					if (isShotSuccess(chanceToDefendCoefficientTeam2/4)) {
						matchResult[0] += 1;
					}
				}
			} else {
				
				if (tryToScoreGoal(chanceToScoreCoefficientTeam2)) {
					if (isShotSuccess(chanceToDefendCoefficientTeam1/4)) {
						matchResult[1] += 1;
					}
				}
			}
		}
		matchResult[0] = matchResult[0];
		matchResult[1] = matchResult[1];
		return matchResult;
	}

	private Boolean isShotSuccess(int chanceToDefendCoefficientTeam) {
		if (getRandomNum() <= chanceToDefendCoefficientTeam) {
			return true;
		}
		return false;
	}

	private Boolean tryToScoreGoal(int chanceToScoreCoefficientTeam) {

		if (getRandomNum() <= chanceToScoreCoefficientTeam) {
			return true;
		}
		return false;
	}

	private Boolean doAttack(int chanceToWinCoefficientTeam) {

		if (getRandomNum() <= chanceToWinCoefficientTeam) {
			return true;
		}
		return false;
	}

	private int getRandomNum() {
		return new Random().nextInt(MAX_RANDOM_VALUE);
	}

	private int chanceToWin(double d) {
		int value = 0;
		if (d < 0) {
			value = (int) (COEFFICIENT - (d * 5));
		} else {
			value = (int) (COEFFICIENT + (d * 5));
		}
		return value;
	}

	private int chanceToScore(double d) {
		int value = 0;
		if (d < 0) {
			value = (int) (COEFFICIENT - (d * 5));
		} else {
			value = (int) (COEFFICIENT + (d * 5));
		}
		return value;
	}
	private int chanceToDefend(double d) {
		int value = 0;
		if (d < 0) {
			value = (int) (COEFFICIENT - (d * 5));
		} else {
			value = (int) (COEFFICIENT + (d * 5));
		}
		return value;
	}

//	private int chanceToDefend(double d) {
//		return (int) (COEFFICIENT + (d * (d < 0 ? -5 : 5)));
//	}

	// team skillas gynyba
	private Double calcSkillsValues(Map<Skill, Double> team, Predicate<Skill> condition) {

		Double value = 0.0;
		for (Skill skill : team.keySet()) {
			if (condition.test(skill)) {
				value += team.get(skill);
			}
		}

		return value;
	}

	private Map<Skill, Double> calc(Team t) {

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
