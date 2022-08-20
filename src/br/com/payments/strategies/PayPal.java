package br.com.payments.strategies;

import java.util.HashMap;
import java.util.Map;

public class PayPal implements PaymentStrategy {

	private static final Map<String, String> DATA_BASE = new HashMap<>();
//	private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
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
	public void collectPaymentDetails(String email, String password) {
		if (email.isEmpty()) {
			throw new NullPointerException("Wrong email or password");
		} else if (email.isBlank()) {
			throw new NullPointerException("Wrong email or password");
		}

		if (password.isEmpty()) {
			throw new NullPointerException("Wrong email or password");
		} else if (password.isBlank()) {
			throw new NullPointerException("Wrong email or password");
		}

		this.email = email;
		this.password = password;

	}

//	private boolean verify() {
//		setSignedIn(email.equals(DATA_BASE.get(password)));
//		return signedIn;
//	}

	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean isSignedIn() {
		return signedIn;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (signedIn ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PayPal other = (PayPal) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (signedIn != other.signedIn)
			return false;
		return true;
	}

}
