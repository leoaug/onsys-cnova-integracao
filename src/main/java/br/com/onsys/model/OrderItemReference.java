package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrderItemReference  {
  
  private String skuSellerId = null;
  private Integer quantity = null;

  
  /**
   * SKU do produto do lojista que deverá ser alterado
   **/
  @ApiModelProperty(value = "SKU do produto do lojista que deverá ser alterado")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  
  /**
   * Quantidade do estoque
   **/
  @ApiModelProperty(value = "Quantidade do estoque")
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
    sb.append("class OrderItemReference {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  quantity: ").append(quantity).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
