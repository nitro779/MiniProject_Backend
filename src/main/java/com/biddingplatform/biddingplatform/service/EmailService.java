package com.biddingplatform.biddingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService{
	@Autowired
	private JavaMailSender mailSender;
	public void sendEmail(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
	    message.setFrom("rdjnaresh779@gmail.com");
	    message.setSubject("Bid Acceptance.");
	    message.setText("Hello,Thanks for Choosing my Product.Your Bid has been accepted.Just Go and do the Payment.Thank You");
	    mailSender.send(message);
	}
	public void sendEmail(String to,String password) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
	    message.setFrom("rdjnaresh779@gmail.com");
	    message.setSubject("Forgot Password");
	    message.setText("Hey,Thanks for reaching out Us.This is Your password : "+"' "+password+" '");
	    mailSender.send(message);
	}
}
