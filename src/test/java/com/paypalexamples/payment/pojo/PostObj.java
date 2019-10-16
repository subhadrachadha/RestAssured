package com.paypalexamples.payment.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PostObj {	
private List<Transactions> transactions;
private String note_to_payer;
private Payer payer;
private String intent;
private Redirect_urls redirect_urls;

public Redirect_urls getRedirect_urls() {
	return redirect_urls;
}
public void setRedirect_urls(Redirect_urls redirect_urls) {
	this.redirect_urls = redirect_urls;
}

@JsonProperty("transactions")
public List<Transactions> getTransaction() {
	return transactions;
}

@JsonProperty("transactions")
public void setTransaction(List<Transactions> transactions) {
	this.transactions = transactions;
}

public String getNote_to_payer() {
	return note_to_payer;
}
public void setNote_to_payer(String note_to_payer) {
	this.note_to_payer = note_to_payer;
}
public Payer getPayer() {
	return payer;
}
public void setPayer(Payer payer) {
	this.payer = payer;
}

public String getIntent() {
	return intent;
}
public void setIntent(String intent) {
	this.intent = intent;
}


}
