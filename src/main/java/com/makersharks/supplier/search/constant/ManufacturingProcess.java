package com.makersharks.supplier.search.constant;

public enum ManufacturingProcess {
	MOULDING(1, "moulding"),
	THREE_DIMENSION_PRINTNIG(2, "3d_printing"),
	CASTING(3, "casting"),
	COATING(4, "coating");
	
	private int processValue;
	private String processName;
	ManufacturingProcess(int processValue, String processName) {
		this.processValue = processValue;
		this.processName = processName;
	}
	
	public int getProcessValue() {
		return processValue;
	}
	
	public String getProcessName() {
		return processName;
	}
	
}
