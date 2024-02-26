package guru.springframework.services;


import java.util.List;

import guru.springframework.model.CargoBooking;

public interface CargoBookingService {
	
    List<CargoBooking> listAllBookings();

    CargoBooking getCargoByIdAndMode(Integer id, CargoBookingMode mode);

    boolean saveCargoBooking(CargoBooking booking, CargoBookingMode mode);
    
    boolean deleteCargoBooking(Integer id, CargoBookingMode mode);
    
    CargoBooking parse(String input);
}
