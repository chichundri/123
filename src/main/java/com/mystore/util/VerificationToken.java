package com.mystore.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mystore.entities.User;

@Entity
public class VerificationToken {
	
    private static final int EXPIRATION = 60 * 24;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    private String token;
   
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
     
    private Date expiryDate;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

//	generate random token
	
//	 private void confirmRegistration(OnRegistrationCompleteEvent event) {
//	        User user = event.getUser();
//	        String token = UUID.randomUUID().toString();
//	        service.createVerificationToken(user, token);
//	         
//	        String recipientAddress = user.getEmail();
//	        String subject = "Registration Confirmation";
//	        String confirmationUrl 
//	          = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
//	        String message = messages.getMessage("message.regSucc", null, event.getLocale());
//	         
//	        SimpleMailMessage email = new SimpleMailMessage();
//	        email.setTo(recipientAddress);
//	        email.setSubject(subject);
//	        email.setText(message + " rn" + "http://localhost:8080" + confirmationUrl);
//	        mailSender.send(email);
//	    }
	
}