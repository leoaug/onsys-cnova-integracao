package br.com.onsys.controller;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.json.JSONArray;
import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.service.LoadsApi;
import br.com.onsys.constantes.Constantes;
import br.com.onsys.model.BillingAddress;
import br.com.onsys.model.Category;
import br.com.onsys.model.CustomerSandbox;
import br.com.onsys.model.Dimensions;
import br.com.onsys.model.Errors;
import br.com.onsys.model.GetCategoriesResponse;
import br.com.onsys.model.OrderItemSandbox;
import br.com.onsys.model.OrderSandbox;
import br.com.onsys.model.Product;
import br.com.onsys.model.ProductAttribute;
import br.com.onsys.model.ProductLoadPrices;
import br.com.onsys.model.ProductLoadStock;
import br.com.onsys.util.ApiUtil;
import br.com.onsys.util.CnovaException;
import br.com.onsys.util.GZIPCompression;
import br.com.onsys.util.ObjetoUtil;

@Named
@Scope("view")
public class CadastrarAnuncioController extends OnsysCnovaController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Product product;
	private ProductAttribute productAttribute;
	private List <Product> products;
	private DualListModel <String> categoriesPickList;
	private DualListModel <String> gtinPickList;

	public boolean mostrarAdicionarProduct;

	@PostConstruct
	public void onInit() {
		try {
			
			super.onInit();
			
			setProduct(new Product());
			getProduct().setPrice(new ProductLoadPrices());
			getProduct().setStock(new ProductLoadStock());
			getProduct().setDimensions(new Dimensions());
			getProduct().setAttributes(new ArrayList <ProductAttribute> ());
			getProduct().setImages(new ArrayList<String>());
			setProductAttribute(new ProductAttribute());
			setProducts(new ArrayList<Product>());
			

			this.carregarCategoriesPickList();
			this.carregarGtinPickList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	private void carregarCategoriesPickList() {
		List <String> categoriesSource = new ArrayList<String>();
		List <String> categoriesTarget = new ArrayList<String>();
		categoriesSource.add("Teste>API");
		
		setCategoriesPickList(new DualListModel<String>(categoriesSource, categoriesTarget));
		
	}
	
	private void carregarGtinPickList() {
		List <String> gtinSource = new ArrayList<String>();
		List <String>gtinTarget = new ArrayList<String>();
		gtinSource.add("67892ft");
		
		setGtinPickList(new DualListModel<String>(gtinSource, gtinTarget));
		
	}

	/*
	public void cadastrarAnuncio2() {
		try {
			
			OrderSandbox oderSandbox = new OrderSandbox();
			
			OrderItemSandbox orderItemSandbox = new OrderItemSandbox();
			orderItemSandbox.setSkuSellerId("CEL_LGG4");
			orderItemSandbox.setQuantity(1);
			orderItemSandbox.setName("CEL");
			orderItemSandbox.setSalePrice(12.6);
			
			oderSandbox.setItems(new ArrayList<OrderItemSandbox>());
			oderSandbox.getItems().add(orderItemSandbox);
			
			
			CustomerSandbox customerSandbox = new CustomerSandbox();
			customerSandbox.setEmail("emai@email.com");
			customerSandbox.setGender("Male");
			customerSandbox.setName("Leonardo Silva");
			
			BillingAddress billingAddress = new BillingAddress();
			billingAddress.setAddress("endereco");
			billingAddress.setCity("Brasilia");
			billingAddress.setCountryId("BR");
			
			customerSandbox.setBilling(billingAddress);
			oderSandbox.setCustomer(customerSandbox);
			
			String retorno = getOrdersApi().postOrder(oderSandbox);
			
			System.out.println(retorno);
			
		} catch (Exception e) {
			e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao publicar, causa:" +e.getMessage()));
		}	
	
	}
	*/
	public void cadastrarAnuncio() {
		try {
			/*
			// Cria��o de um novo produto
			Product product = new Product();

			product.setSkuSellerId("CELULAR SAMSUMG");
			product.setProductSellerId("CELULAR");
			product.setTitle("Produto de testes CELULAR SAMSUMG");
			product.setDescription("<h2>O novo produto de testes</h2>, LG G4");
			product.setBrand("LG");
			product.getGtin().add("67892ft");
			
		    GetCategoriesResponse getCategoriesResponse =   getCategoriesApi().getCategories(0, 10);
		    
		    if(getCategoriesResponse.getCategories() != null) {
		    	for(Category category : getCategoriesResponse.getCategories()) {
		    		product.getCategories().add(category.getName());
		    		System.out.println(product.getCategories()); 
		    	}
		    }
			
			//product.getCategories().add("Teste>API");
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

			*/

			// Envia a carga de produtos
			try {
								

			    //String resposta = getLoadsApi().postProducts(GZIPCompression.compress(new JSONArray(products).toString()));
				
			    String resposta = getLoadsApi().postProducts(getProducts());
			    
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "An�ncio Publicado no Cnova"));
 
			    System.out.println(resposta);

			} catch (Exception e) {

				e.printStackTrace();
				
			    Errors errors = CnovaException.deserializeErrors(e.getMessage(), getApiClient());

		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao publicar, causa:" +e.getMessage()));

			    
			    if (errors == null) {
			        System.err.print("Error calling LOADS resource.");
			    } else {
			        // TODO: Manage Errors structure.
			        System.out.println(errors);
			    }

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao publicar, causa:" +e.getMessage()));
		}	
	
	}
	
	
	
	public void adicionarAtributosProduto() throws Exception {
		try {			
			
			getProduct().getAttributes().
				add((ProductAttribute) ObjetoUtil.copiarAtributosObjetoParaNovaInstancia(getProductAttribute()));
			
			setProductAttribute(new ProductAttribute());
			
			setMostrarAdicionarProduct(true);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void removerAtributosProduto(ProductAttribute productAttribute) throws Exception {
		getProduct().getAttributes().remove(productAttribute);
		if(getProduct().getAttributes().isEmpty()) {
			setMostrarAdicionarProduct(false);
		}
	}
	
	public void adicionarProduto() throws Exception {
		try {	
			
			getProduct().setCategories(getCategoriesPickList().getTarget());
			getProduct().setGtin(getGtinPickList().getTarget());
			//definir se coloca em tela depois
			getProduct().getImages().add("http://img.g.org/img1.jpeg");
			
			getProducts().add((Product) ObjetoUtil.copiarAtributosObjetoParaNovaInstancia(getProduct()));
			
			getProduct().setAttributes(new ArrayList<ProductAttribute>());
			getProduct().setCategories(new ArrayList<String>());
			
			getProduct().setSkuSellerId("");
			getProduct().setProductSellerId("");
			getProduct().setTitle("");
			getProduct().setDescription("");
			getProduct().getPrice().setDefault(null);
			getProduct().getPrice().setOffer(null);
			getProduct().getStock().setQuantity(1);
			getProduct().getStock().setCrossDockingTime(1);
			getProduct().getDimensions().setWeight(1.0);
			getProduct().getDimensions().setLength(1.0);
			getProduct().getDimensions().setWidth(1.0);
			getProduct().getDimensions().setHeight(1.0);
			
			this.carregarCategoriesPickList();
			this.carregarGtinPickList();
			
			
		} catch (Exception e) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao adicionarProduto, causa:" +e.getMessage()));

			throw e;
		}
	}
	
	public void removerProduto(Product product) throws Exception {
		getProducts().remove(product);		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductAttribute getProductAttribute() {
		return productAttribute;
	}

	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}

	public DualListModel<String> getCategoriesPickList() {
		return categoriesPickList;
	}

	public void setCategoriesPickList(DualListModel<String> categoriesPickList) {
		this.categoriesPickList = categoriesPickList;
	}
	

	public DualListModel<String> getGtinPickList() {
		return gtinPickList;
	}

	public void setGtinPickList(DualListModel<String> gtinPickList) {
		this.gtinPickList = gtinPickList;
	}

	public boolean isMostrarAdicionarProduct() {
		return mostrarAdicionarProduct;
	}

	public void setMostrarAdicionarProduct(boolean mostrarAdicionarProduct) {
		this.mostrarAdicionarProduct = mostrarAdicionarProduct;
	}
	
	
	
}
