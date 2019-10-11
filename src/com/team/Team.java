package com.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.TeamSkillsCalc;
import com.player.Player;
import com.player.Skill;

public class Team {

	private String name;

	private Map<Skill, Double> skills = new HashMap<>();

	private List<Player> players = new ArrayList<>();

	private List<Player> bench = new ArrayList<>();
	
	public Team() {}
	
	public String getName() {
		return name;
	}

	public Map<Skill, Double> getSkills() {
		return skills;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Player> getBench() {
		return bench;
	}

}
