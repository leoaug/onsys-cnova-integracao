package br.com.onsys.model;



import java.util.*;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetProductWithErrorsResponse  {
  
  private String skuId = null;
  private String skuSellerId = null;
  private String productSellerId = null;
  private String title = null;
  private String description = null;
  private String brand = null;
  private List<String> gtin = new ArrayList<String>() ;
  private List<String> categories = new ArrayList<String>() ;
  private List<String> images = new ArrayList<String>() ;
  private List<String> videos = new ArrayList<String>() ;
  private ProductLoadPrices price = null;
  private ProductLoadStock stock = null;
  private Dimensions dimensions = null;
  private GiftWrap giftWrap = null;
  private List<ProductAttribute> attributes = new ArrayList<ProductAttribute>() ;
  private List<Error> errors = new ArrayList<Error>() ;

  
  /**
   * SKU ID do produto no Marketplace - utilizado para realizar associação de produtos
   **/
  @ApiModelProperty(value = "SKU ID do produto no Marketplace - utilizado para realizar associação de produtos")
  @JsonProperty("skuId")
  public String getSkuId() {
    return skuId;
  }
  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }

  
  /**
   * SKU ID do produto do Lojista
   **/
  @ApiModelProperty(required = true, value = "SKU ID do produto do Lojista")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  
  /**
   * ID do produto do lojista para fazer o agrupamento de SKUs
   **/
  @ApiModelProperty(value = "ID do produto do lojista para fazer o agrupamento de SKUs")
  @JsonProperty("productSellerId")
  public String getProductSellerId() {
    return productSellerId;
  }
  public void setProductSellerId(String productSellerId) {
    this.productSellerId = productSellerId;
  }

  
  /**
   * Nome no Marketplace. Ex Televisor de LCD Sony Bravia 40...
   **/
  @ApiModelProperty(required = true, value = "Nome no Marketplace. Ex Televisor de LCD Sony Bravia 40...")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   * Descrição do produto. Aceita tags HTML para formatar a apresentação da descrição, no entanto há alguma tags restritas (tags para acesso a conteúdo externo): img, object, script e iframe.
   **/
  @ApiModelProperty(required = true, value = "Descrição do produto. Aceita tags HTML para formatar a apresentação da descrição, no entanto há alguma tags restritas (tags para acesso a conteúdo externo): img, object, script e iframe.")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   * Marca. Ex Sony
   **/
  @ApiModelProperty(required = true, value = "Marca. Ex Sony")
  @JsonProperty("brand")
  public String getBrand() {
    return brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }

  
  /**
   * Lista que pode conter tanto o código EAN do produto (código de barras) quanto códigos ISBN (geralmente utilizados para livros)
   **/
  @ApiModelProperty(value = "Lista que pode conter tanto o código EAN do produto (código de barras) quanto códigos ISBN (geralmente utilizados para livros)")
  @JsonProperty("gtin")
  public List<String> getGtin() {
    return gtin;
  }
  public void setGtin(List<String> gtin) {
    this.gtin = gtin;
  }

  
  /**
   * Lista de categorias
   **/
  @ApiModelProperty(required = true, value = "Lista de categorias")
  @JsonProperty("categories")
  public List<String> getCategories() {
    return categories;
  }
  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  
  /**
   *  Lista de URLs de imagens. Pelo menos uma imagem precisa ser informada
   **/
  @ApiModelProperty(required = true, value = " Lista de URLs de imagens. Pelo menos uma imagem precisa ser informada")
  @JsonProperty("images")
  public List<String> getImages() {
    return images;
  }
  public void setImages(List<String> images) {
    this.images = images;
  }

  
  /**
   *  Lista de URLs de vídeos
   **/
  @ApiModelProperty(value = " Lista de URLs de vídeos")
  @JsonProperty("videos")
  public List<String> getVideos() {
    return videos;
  }
  public void setVideos(List<String> videos) {
    this.videos = videos;
  }

  
  /**
   * Informações de preço do produto
   **/
  @ApiModelProperty(required = true, value = "Informações de preço do produto")
  @JsonProperty("price")
  public ProductLoadPrices getPrice() {
    return price;
  }
  public void setPrice(ProductLoadPrices price) {
    this.price = price;
  }

  
  /**
   * Informações de estoque do produto
   **/
  @ApiModelProperty(required = true, value = "Informações de estoque do produto")
  @JsonProperty("stock")
  public ProductLoadStock getStock() {
    return stock;
  }
  public void setStock(ProductLoadStock stock) {
    this.stock = stock;
  }

  
  /**
   * Informações de dimensões do produto
   **/
  @ApiModelProperty(required = true, value = "Informações de dimensões do produto")
  @JsonProperty("dimensions")
  public Dimensions getDimensions() {
    return dimensions;
  }
  public void setDimensions(Dimensions dimensions) {
    this.dimensions = dimensions;
  }

  
  /**
   * Informações de embrulho para presente
   **/
  @ApiModelProperty(value = "Informações de embrulho para presente")
  @JsonProperty("giftWrap")
  public GiftWrap getGiftWrap() {
    return giftWrap;
  }
  public void setGiftWrap(GiftWrap giftWrap) {
    this.giftWrap = giftWrap;
  }

  
  /**
   * Características do produto
   **/
  @ApiModelProperty(required = true, value = "Características do produto")
  @JsonProperty("attributes")
  public List<ProductAttribute> getAttributes() {
    return attributes;
  }
  public void setAttributes(List<ProductAttribute> attributes) {
    this.attributes = attributes;
  }

  
  /**
   * Lista de erros que ocorreram na importação do produto
   **/
  @ApiModelProperty(value = "Lista de erros que ocorreram na importação do produto")
  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }
  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetProductWithErrorsResponse {\n");
    
    sb.append("  skuId: ").append(skuId).append("\n");
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  productSellerId: ").append(productSellerId).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  brand: ").append(brand).append("\n");
    sb.append("  gtin: ").append(gtin).append("\n");
    sb.append("  categories: ").append(categories).append("\n");
    sb.append("  images: ").append(images).append("\n");
    sb.append("  videos: ").append(videos).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  stock: ").append(stock).append("\n");
    sb.append("  dimensions: ").append(dimensions).append("\n");
    sb.append("  giftWrap: ").append(giftWrap).append("\n");
    sb.append("  attributes: ").append(attributes).append("\n");
    sb.append("  errors: ").append(errors).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
