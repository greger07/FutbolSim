package com.player;

public class SkillValue {

	private Skill skill;
	private Double value;

	public SkillValue(Skill skill, Double value) {
		super();
		this.skill = skill;
		this.value = value;
	}

	public Skill getSkill() {
		return skill;
	}

	public Double getValue() {
		return value;
	}

}
