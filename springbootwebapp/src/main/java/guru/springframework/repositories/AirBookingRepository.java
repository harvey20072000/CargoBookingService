package guru.springframework.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import guru.springframework.model.AirBooking;

@Repository
public interface AirBookingRepository extends JpaRepository<AirBooking, Integer>{
	
	@Query(value = "FROM AirBooking a")
	List<AirBooking> list();
	
}
