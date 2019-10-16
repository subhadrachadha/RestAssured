package com.paypalexample.base;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypalexamples.payment.pojo.Amount;
import com.paypalexamples.payment.pojo.Details;
import com.paypalexamples.payment.pojo.Item_List;
import com.paypalexamples.payment.pojo.Items;
import com.paypalexamples.payment.pojo.Payer;
//import com.paypalexamples.payment.pojo.Links;
import com.paypalexamples.payment.pojo.Payment_options;
import com.paypalexamples.payment.pojo.PostObj;
import com.paypalexamples.payment.pojo.Redirect_urls;
import com.paypalexamples.payment.pojo.Shipping_address;
import com.paypalexamples.payment.pojo.Transactions;



public class PostAsObj extends BaseClass{
	
	static String payment_id;
	@Test
	public void createAPaymentObject() throws JsonGenerationException, JsonMappingException, IOException {
		
		Redirect_urls redirect_urls=new Redirect_urls();
		redirect_urls.setReturn_url("https://example.com/return");
		redirect_urls.setCancel_url("https://example.com/cancel");
		
		
		
		Details details =new Details();
		details.setSubtotal("30.00");
		details.setTax("0.07");
		details.setShipping("0.03");
		details.setHandling_fee("1.00");
		details.setShipping_discount("-1.00");
		details.setInsurance("0.01");
		
		//create Amount
		Amount amount=new Amount();
		amount.setTotal("30.11");
		amount.setCurrency("USD");
		amount.setDetails(details);
		
		//set the shipping address
		Shipping_address shipping_address=new Shipping_address();
		shipping_address.setRecipient_name("Brian Robinson");
		shipping_address.setLine1("4th Floor");
		shipping_address.setLine2("Unit #34");
		shipping_address.setCity("San Jose");
		shipping_address.setCountry_code("US");
		shipping_address.setPostal_code("95131");
		shipping_address.setPhone("011862212345678");
		shipping_address.setState("CA");
		
		
		
		
		//set the items first
		Items item=new Items();
		item.setName("hat");
		item.setDescription("Brown hat");
		item.setQuantity("5");
		item.setPrice("3.00");
		item.setTax("0.01");
		item.setSku("1");
		item.setCurrency("USD");
		
		
		
		
		Items item2=new Items();
		item2.setName("handbag");
		item2.setDescription("Black handbag");
		item2.setQuantity("1");
		item2.setPrice("15.00");
		item2.setTax("0.02");
		item2.setSku("product34");
		item2.setCurrency("USD");
		
		
		
		List<Items> items=new ArrayList<>();
		items.add(item);
		items.add(item2);
		
		Item_List item_list=new Item_List();
		item_list.setItems(items);
		item_list.setShipping_address(shipping_address);
		
		
		Payment_options payment_options=new Payment_options();
		payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");
		
		
		/*List<Related_resources> related_resources=new ArrayList<>();
		related_resources.addAll(" ");*/
		
		Transactions transaction=new Transactions();
		transaction.setAmount(amount);
		transaction.setDescription("The payment transaction description");
		transaction.setCustom("EBAY_EMS_90048630024435");
		transaction.setInvoice_number("48787589673");
		transaction.setPayment_options(payment_options);
		transaction.setSoft_descriptor("ECHI5786786");
		transaction.setItem_list(item_list);
		
		
		Payer payer=new Payer();
		payer.setPayment_method("paypal");
		
		List<Transactions> transactions=new ArrayList();
		transactions.add(transaction);
		
		ObjectMapper mapper = new ObjectMapper();
		PostObj postObj=new PostObj();
		postObj.setIntent("sale");
		postObj.setPayer(payer);
		postObj.setTransaction(transactions);
		postObj.setNote_to_payer("Contact us for any questions on your order.");
		postObj.setRedirect_urls(redirect_urls);
		
		String json=mapper.writeValueAsString(postObj);
		System.out.println(json);
		
		
		
		
		
		payment_id=given().contentType("application/json").auth()
		.oauth2(accessToken).when().body(postObj).post("/payments/payment")
		.then().log().all().extract().path("id");
	}
	
	@Test
	public void getPaymentDetails()
	{
		given().contentType("application/json").auth().oauth2(accessToken).when().get("/payments/payment"+payment_id).then().log().all();
	}

}
