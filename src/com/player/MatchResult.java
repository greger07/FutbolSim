package com.player;

public class MatchResult {
	
	private int team1Goals = 0;
	private int team2Goals = 0;

	public int getTeam1Goals() {
		return team1Goals;
	}

	public void setTeam1Goals(int team1Goals) {
		this.team1Goals = team1Goals;
	}

	public int getTeam2Goals() {
		return team2Goals;
	}

	public void setTeam2Goals(int team2Goals) {
		this.team2Goals = team2Goals;
	}

	@Override
	public String toString() {
		return "MatchResult [team1Goals=" + team1Goals + ", team2Goals=" + team2Goals + "]";
	}
	
	
}
