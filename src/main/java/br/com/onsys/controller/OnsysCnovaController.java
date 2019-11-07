package br.com.onsys.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.service.LoadsApi;
import br.com.onsys.model.Errors;
import br.com.onsys.util.ApiUtil;
import br.com.onsys.util.CnovaException;

@Named
@Scope("view")
public class OnsysCnovaController implements Serializable {


	private ApiClient apiClient;
	private LoadsApi loadsApi;
	private String titulo;
	
	private static final long serialVersionUID = 1L;
	

	@PostConstruct
	public void onInit() {
		
			try {
			
				apiClient = ApiUtil.callApi();
				loadsApi = new LoadsApi(apiClient);
				
			} catch (ApiException e) {

			    Errors errors = CnovaException.deserializeErrors(e.getMessage(), apiClient);

			    if (errors == null) {
			        System.err.println("Error calling LOADS resource." + e);
			    } else {
			        // TODO: Manage Errors structure.
			        System.out.println(errors);
			    }

			}
		}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ApiClient getApiClient() {
		return apiClient;
	}
	public LoadsApi getLoadsApi() {
		return loadsApi;
	}
	
			
			

}
