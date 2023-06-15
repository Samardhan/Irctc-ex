package in.samar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.samar.request.Passenger;
import in.samar.response.Ticket;
import in.samar.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bs;

	@PostMapping(value = "/ticket", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p) {

		Ticket t = bs.bookTicket(p);
		
		System.out.println(p);

		System.out.println(t);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{ticketNum}",
			produces = {"application/json"}
			)
	public Ticket getTicket(@PathVariable("ticketNum") Integer ticketNum) {

		return bs.getTicket(ticketNum);

	}

}
