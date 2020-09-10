package com.wilembergson.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.wilembergson.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
