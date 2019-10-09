package com.player;

import java.util.HashMap;
import java.util.Map;

public class Player {

	private String name;

	private Map<Skill, Double> skills = new HashMap<>();

	public Player(String name, SkillValue... skillValues) {
		super();
		for (SkillValue skillValue : skillValues) {
			skills.put(skillValue.getSkill(), skillValue.getValue());
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Map<Skill, Double> getSkills() {
		return skills;
	}

}
