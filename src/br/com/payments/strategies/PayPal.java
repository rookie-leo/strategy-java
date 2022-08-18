package br.com.payments.strategies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class PayPal implements PaymentStrategy {
	
	private static final Map<String, String> DATA_BASE = new HashMap<>();
	private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	private String email;
	private String password;
	private boolean signedIn;
	
	static {
		DATA_BASE.put("passteste", "teste@email.com");
		DATA_BASE.put("passFulano", "fulano@email.com");
	}

	@Override
	public boolean pay(int paymentAmount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void collectPaymentDetails() {
		// TODO Auto-generated method stub
		
	}

}
