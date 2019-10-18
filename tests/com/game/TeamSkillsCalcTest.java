package com.game;

import org.junit.Assert;
import org.junit.Test;

import com.game.TeamSkillsCalc;
import com.player.Player;
import com.player.Skill;
import com.player.SkillValue;
import com.team.TeamList;

public class TeamSkillsCalcTest extends TeamSkillsCalc {

	@Test
	public void eqTeamSkillsValueEqTest() {

		TeamList team = new TeamList();
		team.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 0.5), new SkillValue(Skill.GOALTENDING, 1.0)));
		team.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 1.0)));
		team.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0)));


		TeamSkillsCalc tsc = new TeamSkillsCalc();
		Double d =  tsc.calc(team).get(Skill.GOALTENDING);
		Assert.assertEquals(1,  Double.compare(2.0, d));
	}
	
	@Test
	public void eqTeamSkillsValueEq2Test() {

		TeamList team = new TeamList();
		team.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 0.5)));
		team.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 1.0)));
		team.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0)));

		TeamSkillsCalc tsc = new TeamSkillsCalc();
		Double d =  tsc.calc(team).get(Skill.GOALTENDING);
		Assert.assertEquals(1,  Double.compare(1.5, d));
	}
	
	@Test
	public void isTeamSizeNotBiggerThanElevenTest() {

		TeamList team = new TeamList();
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

	}
	
	@Test(expected = RuntimeException.class)
	public void teamToBigTest() {

		TeamList team = new TeamList();
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
		// add one more
		team.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 0.0), new SkillValue(Skill.OFFENCE, 0.0)));

		Assert.fail();
	}

}
