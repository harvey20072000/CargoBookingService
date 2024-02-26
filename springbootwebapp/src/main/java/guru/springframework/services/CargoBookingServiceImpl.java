package guru.springframework.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.model.AirBooking;
import guru.springframework.model.CargoBooking;
import guru.springframework.model.OceanBooking;
import guru.springframework.repositories.AirBookingRepository;
import guru.springframework.repositories.OceanBookingRepository;
import guru.springframework.utils.Utils;


@Service
public class CargoBookingServiceImpl implements CargoBookingService {
	
	@Autowired
	private OceanBookingRepository oceanBookingRepository;
	
	@Autowired
	private AirBookingRepository airBookingRepository;

	@Override
	public List<CargoBooking> listAllBookings() {
		List<CargoBooking> list = new ArrayList<CargoBooking>();
		list.addAll(oceanBookingRepository.findAll());
		list.addAll(airBookingRepository.findAll());
		return list;
	}

	@Override
	public CargoBooking getCargoByIdAndMode(Integer id, CargoBookingMode mode) {
		CargoBooking booking;
		switch (mode) {
			case OCEAN : 
				booking = oceanBookingRepository.findById(id).orElse(null);
				break;
			case AIR : 
				booking = airBookingRepository.findById(id).orElse(null);
				break;
			default :
				throw new IllegalArgumentException("Unexpected value: " + mode);
		};
		booking.setMode(mode);
		return booking;
	}

	@Override
	public boolean saveCargoBooking(CargoBooking booking, CargoBookingMode mode) {
		switch (mode) {
		case OCEAN : 
			oceanBookingRepository.save((OceanBooking)booking);
			break;
		case AIR : 
			airBookingRepository.save((AirBooking)booking);
			break;
		default :
			throw new IllegalArgumentException("Unexpected value: " + mode);
		};
		return true;
	}

	@Override
	public boolean deleteCargoBooking(Integer id, CargoBookingMode mode) {
		switch (mode) {
		case OCEAN : 
			oceanBookingRepository.deleteById(id);
			break;
		case AIR : 
			airBookingRepository.deleteById(id);
			break;
		default :
			throw new IllegalArgumentException("Unexpected value: " + mode);
		};
		return true;
	}

	@Override
	public CargoBooking parse(String input) {
		CargoBooking booking = null;
		Map map = Utils.jsonParse(input, Map.class);
		CargoBookingMode mode = CargoBookingMode.parse((String)map.get("mode"));
		switch (mode) {
		case OCEAN:
			booking = new OceanBooking();
			break;
		case AIR:
			booking = new AirBooking();
			break;
		default:
			break;
		}
		booking.setMode(mode);
		booking.setCargo((String)map.get("cargo"));
		booking.setLoading((String)map.get("from"));
		booking.setDischarge((String)map.get("to"));
		return booking;
	}
	
	

    
}
