package in.samar.response;

import lombok.Data;

@Data
public class Ticket {

	
	private Integer ticketNum;
	private String status;
	private Double ticketPrice;
	private String name;
	private String from;
	private String to;
	private String doj;
	private Integer trainNum;
}
