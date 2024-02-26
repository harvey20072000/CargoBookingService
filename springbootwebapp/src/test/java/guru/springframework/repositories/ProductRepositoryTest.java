package guru.springframework.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.configuration.RepositoryConfiguration;
import guru.springframework.model.OceanBooking;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

	@Autowired
    private OceanBookingRepository oceanBookingRepository;

//	@Autowired
//	private AirBookingRepository airBookingRepository;
    
    @Test
    public void testSaveOceanBooking(){
        //setup booking
        OceanBooking booking = new OceanBooking();
        booking.setCargo("iPhone");
        booking.setLoading("Tianjin Xingang Pt, Tianjin, CN");
        booking.setDischarge("New York, New York, US");

        //save product, verify has ID value after save
        assertNull(booking.getId()); //null before save
        oceanBookingRepository.save(booking);
        assertNotNull(booking.getId()); //not null after save
        //fetch from DB
        OceanBooking fetchedBooking = oceanBookingRepository.findById(booking.getId()).orElse(null);

        //should not be null
        assertNotNull(fetchedBooking);

        //should equal
        assertEquals(booking.getId(), fetchedBooking.getId());
        assertEquals(booking.getDischarge(), fetchedBooking.getDischarge());

        //update cargo and save
        fetchedBooking.setCargo("New iPhone");
        oceanBookingRepository.save(fetchedBooking);

        //get from DB, should be updated
        OceanBooking fetchedUpdatedProduct = oceanBookingRepository.findById(fetchedBooking.getId()).orElse(null);
        assertEquals(fetchedBooking.getDischarge(), fetchedUpdatedProduct.getDischarge());

        //verify count of products in DB
        long bookingCount = oceanBookingRepository.count();
        assertEquals(bookingCount, 1);

        //get all products, list should only have one
        Iterable<OceanBooking> bookings = oceanBookingRepository.findAll();

        int count = 0;

        for(OceanBooking p : bookings){
            count++;
        }

        assertEquals(count, 1);
    }
}
