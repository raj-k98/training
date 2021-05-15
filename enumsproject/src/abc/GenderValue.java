package abc;

public enum GenderValue {

	MALE("Male Employee"), 
	FEMALE("Female Employee");
	
	private String description;
	
	private GenderValue(String s) {
		description = s;
	}

	public String getDescription() {
		return description;
	}
}


