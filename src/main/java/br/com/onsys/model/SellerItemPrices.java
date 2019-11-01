package br.com.onsys.model;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SellerItemPrices  {
  
  private String skuSellerId = null;
  private List<Prices> prices = new ArrayList<Prices>() ;

  
  /**
   * SKU do produto do lojista que deverá ser alterado
   **/
  @ApiModelProperty(required = true, value = "SKU do produto do lojista que deverá ser alterado")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  
  /**
   * Preço do produto
   **/
  @ApiModelProperty(required = true, value = "Preço do produto")
  @JsonProperty("prices")
  public List<Prices> getPrices() {
    return prices;
  }
  public void setPrices(List<Prices> prices) {
    this.prices = prices;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SellerItemPrices {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  prices: ").append(prices).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
