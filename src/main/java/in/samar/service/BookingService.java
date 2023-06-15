package in.samar.service;

import in.samar.request.Passenger;
import in.samar.response.Ticket;

public interface BookingService {

	public Ticket bookTicket(Passenger p);
	
	public Ticket getTicket(Integer ticketNum);
	
}
