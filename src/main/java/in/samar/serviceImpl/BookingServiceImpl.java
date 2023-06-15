package in.samar.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.samar.request.Passenger;
import in.samar.response.Ticket;
import in.samar.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private Map<Integer, Ticket> ticketMap = new HashMap<>();
	private Integer ticketNumber = 1;

	@Override
	public Ticket bookTicket(Passenger p) {
		Ticket t = new Ticket();
		
		BeanUtils.copyProperties(p, t);
		t.setTicketPrice(652.65);
		t.setStatus("CNF");
		t.setTicketNum(ticketNumber);

		ticketMap.put(ticketNumber, t);

		ticketNumber++;

		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		if (ticketMap.containsKey(ticketNum)) {
			return ticketMap.get(ticketNum);
		}
		return null;
	}

}
