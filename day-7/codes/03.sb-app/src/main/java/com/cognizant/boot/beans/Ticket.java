package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ticket {
	@Value("AF52637O")
	private String pnr;
	
	//@Value("${cts.psngrname}")
	@Value(value = "${cts.psngrname}")
	private String passengerName;

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", passengerName=" + passengerName + "]";
	}
}
