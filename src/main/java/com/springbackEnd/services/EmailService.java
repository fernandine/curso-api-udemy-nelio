package com.springbackEnd.services;

import com.springbackEnd.domain.Cliente;
import com.springbackEnd.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}