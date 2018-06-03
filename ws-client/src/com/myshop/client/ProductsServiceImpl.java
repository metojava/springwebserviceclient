package com.myshop.client;

import java.io.StringReader;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.myshop.webservices.getproductsservices.GetAllProductsRequest;
import com.myshop.webservices.getproductsservices.GetAllProductsResponse;
import com.myshop.webservices.getproductsservices.GetProductsRequest;
import com.myshop.webservices.getproductsservices.GetProductsResponse;
import com.shop.my.Products;

public class ProductsServiceImpl extends WebServiceGatewaySupport implements ProductsService {

	private static final String MESSAGE = "<GetProductsRequest xmlns=\"http://com/myshop/webservices/getProductsServices\">2</GetProductsRequest>";

	@Override
	public Products getProduct(String id) {
		GetProductsRequest request = new GetProductsRequest();
		request.setPid(id);
		GetProductsResponse response = (GetProductsResponse) getWebServiceTemplate().marshalSendAndReceive(request);

		return response.getProductsDetails();
	}

	@Override
	public void customSendAndReceive() {
		StreamSource source = new StreamSource(new StringReader(MESSAGE));
		StreamResult result = new StreamResult(System.out);
		getWebServiceTemplate().sendSourceAndReceiveToResult("http://localhost:8085/ws/services", source, result);
	}

	@Override
	public List<Products> getProducts() {
		GetAllProductsRequest request = new GetAllProductsRequest();

		GetAllProductsResponse response = (GetAllProductsResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);

		return response.getProducts();
	}

}
