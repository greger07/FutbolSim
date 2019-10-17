package com.game;

public class ChanceTo {

	private static final int HUNDREAD_PERCENTS = 100;
	private Integer win;
	private Integer score;
	private Integer defend;

	public ChanceTo(ChanceTo ct) {
		win = HUNDREAD_PERCENTS - ct.win;
		score = HUNDREAD_PERCENTS - ct.score;
		defend = HUNDREAD_PERCENTS - ct.defend;
	}

	public ChanceTo() {
		super();
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public void setWin100_win(Integer win) {
		this.win = 100 - win;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setScore100_score(Integer score) {
		this.score = 100 - score;
	}

	public Integer getDefend() {
		return defend;
	}

	public void setDefend(Integer defend) {
		this.defend = defend;
	}

	public void setDefend100_defend(Integer defend) {
		this.defend = 100 - defend;
	}

}
