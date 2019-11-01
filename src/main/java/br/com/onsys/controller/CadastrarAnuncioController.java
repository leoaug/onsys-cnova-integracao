package br.com.onsys.controller;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.service.LoadsApi;
import br.com.onsys.constantes.Constantes;
import br.com.onsys.model.Dimensions;
import br.com.onsys.model.Errors;
import br.com.onsys.model.Product;
import br.com.onsys.model.ProductAttribute;
import br.com.onsys.model.ProductLoadPrices;
import br.com.onsys.model.ProductLoadStock;
import br.com.onsys.util.ApiUtil;
import br.com.onsys.util.CnovaException;
import br.com.onsys.api.client.auth.ApiKeyAuth;

@Named
@Scope("view")
public class CadastrarAnuncioController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private ApiClient apiClient = ApiUtil.callApi();
	private LoadsApi loadsApi = new LoadsApi(apiClient);

	@PostConstruct
	public void onInit() {
		try {
			
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void cadastrarAnuncio() {
		try {
			
			// Criação de um novo produto
			Product product = new Product();

			product.setSkuSellerId("CEL_LGG4");
			product.setProductSellerId("CEL");
			product.setTitle("Produto de testes LG G4");
			product.setDescription("<h2>O novo produto de testes</h2>, LG G4");
			product.setBrand("LG");
			product.getGtin().add("123456ft");
			product.getCategories().add("Teste>API");
			product.getImages().add("http://img.g.org/img1.jpeg");

			ProductLoadPrices prices = new ProductLoadPrices();
			prices.setDefault(1999D);
			prices.setOffer(1799D);

			product.setPrice(prices);

			ProductLoadStock stock = new ProductLoadStock();
			stock.setQuantity(100);
			stock.setCrossDockingTime(0);

			product.setStock(stock);

			Dimensions dimensions = new Dimensions();
			dimensions.setWeight(Double.valueOf(10d));
			dimensions.setLength(Double.valueOf(10d));
			dimensions.setWidth(Double.valueOf(10d));
			dimensions.setHeight(Double.valueOf(10d));

			product.setDimensions(dimensions);

			ProductAttribute productAttribute = new ProductAttribute();
			productAttribute.setName("cor");
			productAttribute.setValue("Verde");

			product.getAttributes().add(productAttribute);

			// Adiciona o novo produto na lista a ser enviada
			List<Product> products = new ArrayList<Product>();
			products.add(product);

			// Envia a carga de produtos
			try {

			    loadsApi.postProducts(products);

			} catch (ApiException e) {

			    Errors errors = CnovaException.deserializeErrors(e.getMessage(), apiClient);

			    if (errors == null) {
			        System.err.print("Error calling LOADS resource.");
			    } else {
			        // TODO: Manage Errors structure.
			        System.out.println(errors);
			    }

			}
			
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Anúncio Publicado no Cnova"));
			
		} catch (Exception e) {
			e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao publicar, causa:" +e.getMessage()));
		}	
	
	}
}
