package guru.springframework.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import guru.springframework.model.OceanBooking;

@Repository
public interface OceanBookingRepository extends JpaRepository<OceanBooking, Integer>{
	
	@Query(value = "FROM OceanBooking o")
	List<OceanBooking> list();
	
}
