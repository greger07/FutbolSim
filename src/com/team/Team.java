package com.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.player.Player;
import com.player.Skill;

public class Team {

	private String name;

	private Map<Skill, Double> skills = new HashMap<>();

	private List<Player> players = new TeamList();

	private List<Player> bench = new TeamList();
	
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

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
