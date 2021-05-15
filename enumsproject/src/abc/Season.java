package abc;

public enum Season {

	WINTER("Very Cold"), SPRING("Rains a lot"), SUMMER("Very Hot"), AUTUMN("Quite Pleasant");

	private String state;

	private Season(String state) {
		this.state = state;
	}

	public void ShowState() {
		System.out.println(this.state);
	}

}
