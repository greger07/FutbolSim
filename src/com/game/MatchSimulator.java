package com.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.player.Circumstances;
import com.player.MatchResult;
import com.player.Player;
import com.player.Skill;
import com.team.Team;

public class MatchSimulator {

	public MatchResult playMatch(Team t1, Team t2, Map<Circumstances, Double> circ) {

		// prasukti team skilus
		Map<Skill, Double> team1 = calc(t1);
		Map<Skill, Double> team2 = calc(t2);

		Double team1SkillsValWithoutGK = 0.0;
		Double team2SkillsValWithoutGK = 0.0;

		team1SkillsValWithoutGK = calcSkillsValueWithoutGK(team1);
		team2SkillsValWithoutGK = calcSkillsValueWithoutGK(team2);

		Double gk = 0.0;
		Double def = 0.0;
		Double plm = 0.0;
		Double off = 0.0;

		// skills total
		gk = team1.getOrDefault(Skill.GOALTENDING, 0.0) - team2.getOrDefault(Skill.GOALTENDING, 0.0);		
		def = team1.getOrDefault(Skill.DEFENCE, 0.0) - team2.getOrDefault(Skill.DEFENCE, 0.0);
		plm = team1.getOrDefault(Skill.PLAYMAKING, 0.0) - team2.getOrDefault(Skill.PLAYMAKING, 0.0);
		off = team1.getOrDefault(Skill.OFFENCE, 0.0) - team2.getOrDefault(Skill.OFFENCE, 0.0);

		int chanceToWinTeam1 = 50;

		Double winCoeficient = def + plm + off;
		if (winCoeficient < 0) {
			chanceToWinTeam1 = (int) (chanceToWinTeam1 - winCoeficient * 5);
		} else {
			chanceToWinTeam1 = (int) (chanceToWinTeam1 + winCoeficient * 5);
		}
		int chanceToScoreTeam1 = 50;

		Double chanceToScoreCoeficinet = gk + off;
		if (chanceToScoreCoeficinet < 0) {
			chanceToScoreTeam1 = (int) (chanceToScoreTeam1 - chanceToScoreCoeficinet * 5);
		} else {
			chanceToScoreTeam1 = (int) (chanceToWinTeam1 + chanceToScoreCoeficinet * 5);
		}

		int chanceToDefendTeam1 = 50;

		Double defendCoeficient = def;
		if (winCoeficient < 0) {
			chanceToDefendTeam1 = (int) (chanceToDefendTeam1 - defendCoeficient * 5);
		} else {
			chanceToDefendTeam1 = (int) (chanceToDefendTeam1 + defendCoeficient * 5);
		}

		// MatchR
		MatchResult mResult = new MatchResult();
		mResult.setTeam1Goals(calcGoals(0));
		mResult.setTeam1Goals(calcGoals(0));
		return mResult;

	}

	private Double calcSkillsValueWithoutGK(Map<Skill, Double> team) {

		Double value = 0.0;
		for (Skill skill : team.keySet()) {
			if (!skill.equals(Skill.GOALTENDING)) {
				value += team.get(skill);
			}
		}

		return value;
	}

	private int chanceToWinTeam() {

		
		return 0;
	}

	private int calcGoals(Integer skillsTotalTeam) {
		// TODO Auto-generated method stub
		return 0;
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
