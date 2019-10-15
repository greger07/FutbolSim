package com.game;

public interface IMatch {
	
	Boolean isShotSuccess(int chanceToDefendCoefficientTeam);
	Boolean tryToScoreGoal(int chanceToScoreCoefficientTeam);
	Boolean doAttack(int chanceToWinCoefficientTeam);

}
