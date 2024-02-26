package guru.springframework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import guru.springframework.model.AirBooking;
import guru.springframework.model.CargoBooking;
import guru.springframework.model.OceanBooking;
import guru.springframework.repositories.AirBookingRepository;
import guru.springframework.repositories.OceanBookingRepository;
import guru.springframework.services.CargoBookingMode;
import guru.springframework.services.CargoBookingService;

@Controller
@RequestMapping("cargo")
public class CargoBookingController {

	@Autowired
    private OceanBookingRepository oceanBookingRepository;
	
	@Autowired
	private AirBookingRepository airBookingRepository;
	
	@Autowired
	private CargoBookingService cargoBookingService;
	
	@GetMapping(value = "/test")
	@ResponseBody
	public String test() {
		List<OceanBooking> list = oceanBookingRepository.list();
		System.out.println(((CargoBooking)list.get(0)).getLoading());
		
		List<AirBooking> list2 = airBookingRepository.list();
		System.out.println(((CargoBooking)list2.get(0)).getLoading());
		return list.size()+"";
	}
	
	@GetMapping(value = "/list_bookings")
	public String listBookings(Model model) {
		List<CargoBooking> list = cargoBookingService.listAllBookings();
		model.addAttribute("bookingList", list);
		return "booking_list";
	}
	
	@GetMapping(value = "/get_booking")
	public String getBooking(Model model,
			@RequestParam(required = true, name = "id") Integer id,
			@RequestParam(required = true, name = "mode") String mode
			) {
		CargoBooking booking = 
				cargoBookingService.getCargoByIdAndMode(id, CargoBookingMode.parse(mode));
		model.addAttribute("booking", booking);
		return "booking_show";
	}
	
	@PostMapping(value = "/create_booking")
	public String createBooking(Model model, @RequestBody String body) {
		CargoBooking booking = cargoBookingService.parse(body);
		String msg = 
				cargoBookingService.saveCargoBooking(booking, booking.getMode())?
						"Create Success !" : "Create Failed !";
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@DeleteMapping(value = "/delete_booking")
	public String deleteBooking(Model model,
			@RequestParam(required = true, name = "id") Integer id,
			@RequestParam(required = true, name = "mode") String mode
			) {
		String msg = 
				cargoBookingService.deleteCargoBooking(id, CargoBookingMode.parse(mode))?
						"Delete Success !" : "Delete Failed !";
		model.addAttribute("msg", msg);
		return  "index";
	}

//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public String list(Model model){
//        model.addAttribute("products", productService.listAllProducts());
//        System.out.println("Returning rpoducts:");
//        return "products";
//    }
//
//    @RequestMapping("product/{id}")
//    public String showProduct(@PathVariable Integer id, Model model){
//        model.addAttribute("product", productService.getProductById(id));
//        return "productshow";
//    }
//
//    @RequestMapping("product/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model){
//        model.addAttribute("product", productService.getProductById(id));
//        return "productform";
//    }
//
//    @RequestMapping("product/new")
//    public String newProduct(Model model){
//        model.addAttribute("product", new Product());
//        return "productform";
//    }
//
//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String saveProduct(Product product){
//
//        productService.saveProduct(product);
//
//        return "redirect:/product/" + product.getId();
//    }

}
