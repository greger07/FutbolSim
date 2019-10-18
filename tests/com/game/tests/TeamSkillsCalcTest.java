package com.game.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.game.MatchSimulator;
import com.game.TeamSkillsCalc;
import com.player.Player;
import com.player.Skill;
import com.player.SkillValue;
import com.team.Team;

public class TeamSkillsCalcTest extends TeamSkillsCalc {

	@Test
	public void eqTeamSkillsValueEqTest() {

		Map<Skill, Double> teamSkills = new HashMap<>();


		ArrayList<Player> team = new ArrayList<>();
		team.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 1.0)));
		team.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 1.0), new SkillValue(Skill.OFFENCE, 1.0)));
		team.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 0.0), new SkillValue(Skill.OFFENCE, 0.0)));

		
		
		
		//MatchSimulator ms = new MatchSimulator(() -> 50);
		TeamSkillsCalc tsc = new  TeamSkillsCalc();
		teamSkills = tsc.calc(team);
		double value = 0;
		for (Skill skill : teamSkills.keySet()) {
			if (Skill.GOALTENDING.equals(skill)) {
				value = teamSkills.get(skill);
			}
		}
		
		Assert.assertTrue(1.0 == value);
	}

}
