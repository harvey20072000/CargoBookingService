package guru.springframework.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static <T> T jsonParse(String input, Class<T> type) {
		try {
			return objectMapper.readValue(input, type);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T convert(Object object, Class<T> type) {
		return objectMapper.convertValue(object, type);
	}
	
//	public static void main(String[] args) {
//		OceanBooking booking = new OceanBooking();
//		booking.setCargo("iPhone");
//		booking.setMode(CargoBookingMode.OCEAN);
//		booking.setLoading("from");
//		booking.setDischarge("to");
//		Map map = objectMapper.convertValue(booking, Map.class);
//		System.out.println(map);
//	}
	
}
