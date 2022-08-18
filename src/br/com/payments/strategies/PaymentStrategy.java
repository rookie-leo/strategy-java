package br.com.payments.strategies;

public interface PaymentStrategy {

	boolean pay(int paymentAmount);
	void collectPaymentDetails();
	
}
