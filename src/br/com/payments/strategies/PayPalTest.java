package br.com.payments.strategies;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// TODO tornar esse teste, um teste de integração com o BD usando Mock

class PayPalTest {


	@Test
	void shouldCollectUsersEmail() {
		var payPal = gerarDetails();
		
		assertTrue(payPal.getEmail().equals("teste@email.com"));
	}

	@Test
	void shouldCollectUsersPassword() {
		var payPal = gerarDetails();
		
		assertTrue(payPal.getPassword().equals("passteste"));
	}

	@Test
	void dontShouldCollectWrongPaymentDetails() {
		var payPal = gerarDetails();
		
		assertFalse(payPal.getEmail().equals("fulano@email.com"));
		assertFalse(payPal.getPassword().equals("passFulano"));
	}

	@Test
	void dontShouldAcceptEmptyEmailsUser() {
		PayPal payPal = new PayPal();
		
		NullPointerException ex = assertThrows(NullPointerException.class, () -> {
			payPal.collectPaymentDetails("", "passteste");
		});
		
		assertTrue(ex.getMessage().equals("Wrong email or password"));
	}
	
	private PayPal gerarDetails() {
		PayPal payPalPayments = new PayPal();
		payPalPayments.collectPaymentDetails("teste@email.com", "passteste");
		
		return payPalPayments;
	}
	
}
