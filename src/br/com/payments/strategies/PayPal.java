package br.com.payments.strategies;

import java.io.BufferedReader;
import java.io.IOException;
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
		if (signedIn) {
			System.out.println("Paying " + paymentAmount + " using Paypal");
			return true;
		} else {			
			return false;
		}
	}

	@Override
	public void collectPaymentDetails() {
		try {
			while (!signedIn) {
				System.out.println("Enter the user's email: ");
				email = READER.readLine();
				System.out.println("Enter the password: ");
				password = READER.readLine();
				
				if (verify()) {
					System.out.println("Data verification has been successful!");
				} else {
					System.out.println("Wrong email or password");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean verify() {
		setSignedIn(email.equals(DATA_BASE.get(password)));
		return signedIn;
	}

	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
	
}
