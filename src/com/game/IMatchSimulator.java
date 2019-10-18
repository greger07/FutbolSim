package com.game;

import com.player.MatchResult;
import com.team.Team;

public interface IMatchSimulator {

	MatchResult playMatch(Team t1, Team t2);
}
