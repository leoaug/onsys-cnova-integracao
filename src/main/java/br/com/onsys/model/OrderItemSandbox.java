package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrderItemSandbox  {
  
  private String skuSellerId = null;
  private String name = null;
  private Double salePrice = null;
  private Integer quantity = null;

  
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
   * Nome do produto
   **/
  @ApiModelProperty(required = true, value = "Nome do produto")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Preço de venda
   **/
  @ApiModelProperty(required = true, value = "Preço de venda")
  @JsonProperty("salePrice")
  public Double getSalePrice() {
    return salePrice;
  }
  public void setSalePrice(Double salePrice) {
    this.salePrice = salePrice;
  }

  
  /**
   * Quantidade produtos
   **/
  @ApiModelProperty(required = true, value = "Quantidade produtos")
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemSandbox {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  salePrice: ").append(salePrice).append("\n");
    sb.append("  quantity: ").append(quantity).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
