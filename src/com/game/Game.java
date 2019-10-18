package com.game;

import java.util.ArrayList;

import com.player.Player;
import com.player.Skill;
import com.player.SkillValue;
import com.team.Team;

public class Game {


	public void start() {
		
		Team t1 = new Team();
		Team t2 = new Team();
	
		t1.setName("Animals");
		t2.setName("Birds");

		ArrayList<Player> team1Players = new ArrayList<>();

		team1Players.add(new Player("GK", new SkillValue(Skill.GOALTENDING, 1.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("DF", new SkillValue(Skill.DEFENCE, 1.0), new SkillValue(Skill.PLAYMAKING, 0.0)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
		team1Players.add(new Player("MF", new SkillValue(Skill.DEFENCE, 0.0), new SkillValue(Skill.PLAYMAKING, 1.0)));
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
		
		MatchSimulatorImpl ms = new MatchSimulatorImpl(new RandomNumberProviderImpl());
		for (int i = 0; i < 10; i++) {
			System.out.println(ms.playMatch(t1, t2, null));
		}

	}
	
}
