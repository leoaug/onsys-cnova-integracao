package br.com.onsys.util;


import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.model.Errors;

public class CnovaException {

	
	public static Errors deserializeErrors(String errorsJson, ApiClient apiClient) {

	    Errors errors = null;
	    try {

	        errors = (Errors) apiClient.deserialize(errorsJson, "", Errors.class);

	    } catch (ApiException e) {
	        System.err.println("Doesn't containt errors structure.");
	    }

	    return errors;

	}
	
}
