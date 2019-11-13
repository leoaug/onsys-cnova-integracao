package br.com.onsys.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.service.LoadsApi;
import br.com.onsys.model.Errors;
import br.com.onsys.model.GetProductsResponse;
import br.com.onsys.model.MetadataEntry;
import br.com.onsys.model.Product;
import br.com.onsys.model.ProductResponseItem;
import br.com.onsys.util.ApiUtil;
import br.com.onsys.util.CnovaException;

@Named
@Scope("view")
public class ManterAnuncioController extends OnsysCnovaController implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@PostConstruct
	public void onInit() {
		
		super.onInit();
		
		try {

		    GetProductsResponse getProductsResponse = getLoadsApi().getProducts(null, null, 0, 10);
		    
		    for(ProductResponseItem productResponseItem : getProductsResponse.getSkus()) {
		    	System.out.println(productResponseItem.getSkuSeller().getId());
		    	System.out.println(productResponseItem.getStatus());
		    }
		    
		    for(MetadataEntry metadataEntry : getProductsResponse.getMetadata()) {
		    	 System.out.println(metadataEntry.getKey() + metadataEntry.getValue());
		    }
		   

		} catch (ApiException e) {

		   e.printStackTrace();
		}
	}
	
	public void alterarProduto (RowEditEvent event) throws Exception {
		try {
		
			Product product = (Product) event.getObject();
			
			getLoadsApi().putProduct(product.getSkuSellerId(),product);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Anúncio Alterado no Cnova"));
		} catch (Exception e) {
			e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao Alterar, causa:" +e.getMessage()));

			throw e;
		}
	}

	
	
}
