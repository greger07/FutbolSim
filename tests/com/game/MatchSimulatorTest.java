package com.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.game.IMatchSimulator;
import com.game.MatchSimulatorFactory;
import com.game.MatchSimulatorImpl;
import com.game.RandomNumberProvider;
import com.player.MatchResult;
import com.player.Player;
import com.player.Skill;
import com.player.SkillValue;
import com.team.Team;

public class MatchSimulatorTest {

	@Test
	public void strongerWinsAlwaysTest() {

		Team t1 = new Team();
		Team t2 = new Team();

		t1.setName("Animals");
		t2.setName("Birds");

		ArrayList<Player> team1Players = new ArrayList<>();

		team1Players.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 1.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 0.4), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 0.4), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 0.4), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 0.4), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 0.4)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 0.4)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 0.4)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 0.0), new SkillValue(Skill.OFFENCE, 0.0)));
		team1Players.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 0.0), new SkillValue(Skill.OFFENCE, 0.0)));

		t1.setPlayers(team1Players);

		ArrayList<Player> team2Players = new ArrayList<>();

		team2Players.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 1.0)));
		team2Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team2Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team2Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team2Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team2Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team2Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team2Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team2Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team2Players.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 0.0), new SkillValue(Skill.OFFENCE, 1.0)));
		team2Players.add(new Player("FW", new SkillValue(Skill.PLAYMAKING, 0.0), new SkillValue(Skill.OFFENCE, 1.0)));
		t2.setPlayers(team2Players);

		// MatchSimulator ms = new MatchSimulator(() -> 50);

		IMatchSimulator ms = MatchSimulatorFactory.createInstance(new RandomNumberProvider() {

			@Override
			public int calcPropability() {
				return 50; // 50 %
			}
		});

		MatchResult result = ms.playMatch(t1, t2);
		Assert.assertTrue(result.getTeam1Goals() < result.getTeam2Goals());
	}

	@Test
	public void eqTeamsAlwaysEqRezTest() {

		Team t1 = new Team();
		Team t2 = new Team();

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

		t1.setPlayers(team);
		t2.setPlayers(new ArrayList<>(team));

		// MatchSimulator ms = new MatchSimulator(() -> 50);

		IMatchSimulator ms = MatchSimulatorFactory.createInstance(new RandomNumberProvider() {

			@Override
			public int calcPropability() {
				return 50; // 50 %
			}
		});

		MatchResult result = ms.playMatch(t1, t2);
		Assert.assertEquals(result.getTeam1Goals(), result.getTeam2Goals());
	}

	@Ignore
	@Test
	public void eqTeamSkillsValueEqExpectedTest() {

		Map<Skill, Double> teamSkills = new HashMap<>();
		Team t1 = new Team();

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

		t1.setPlayers(team);

		// MatchSimulator ms = new MatchSimulator(() -> 50);

		IMatchSimulator ms = MatchSimulatorFactory.createInstance(null);
		//FIXME
//		teamSkills = ms.calc(t1);
//		double value = 0;
//		for (Skill skill : teamSkills.keySet()) {
//			if (Skill.GOALTENDING.equals(skill)) {
//				value = teamSkills.get(skill);
//			}
//		}
//
//		Assert.assertTrue(1.0 == value);
	}

}
