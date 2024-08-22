package com.makersharks.supplier.search.constant;

public enum BusinessNature {
	SMALL_SCALE(1, "small_scale"),
	MEDIUM_SCALE(2, "medium_scale"),
	LARGE_SCALE(3, "large_scale");
	
	private int scaleValue;
	private String scaleName;
	BusinessNature(int scaleValue, String scaleName) {
		this.scaleValue = scaleValue;
		this.scaleName = scaleName;
	}
	
	public int getScaleValue() {
		return this.scaleValue;
	}
	
	public String getScaleName() {
		return this.scaleName;
	}
}
