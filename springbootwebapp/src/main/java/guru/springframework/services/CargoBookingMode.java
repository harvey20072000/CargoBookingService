package guru.springframework.services;

public enum CargoBookingMode {
	OCEAN, 
	AIR;
	
	public static CargoBookingMode parse(String input) {
		if (input == null) 
			throw new IllegalArgumentException("input should not be null !");
		if (OCEAN.toString().equals(input.toUpperCase())) 
			return OCEAN;
		if (AIR.toString().equals(input.toUpperCase())) 
			return AIR;
		throw new IllegalArgumentException("input value is invalid : " + input);
	}
}
