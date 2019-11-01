package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ProductLoadPrices  {
  
  private Double _default = null;
  private Double offer = null;

  
  /**
   * Preço de do produto no Marketplace
   **/
  @ApiModelProperty(required = true, value = "Preço de do produto no Marketplace")
  @JsonProperty("default")
  public Double getDefault() {
    return _default;
  }
  public void setDefault(Double _default) {
    this._default = _default;
  }

  
  /**
   * Preço real de venda. Preço por do produto no Marketplace
   **/
  @ApiModelProperty(required = true, value = "Preço real de venda. Preço por do produto no Marketplace")
  @JsonProperty("offer")
  public Double getOffer() {
    return offer;
  }
  public void setOffer(Double offer) {
    this.offer = offer;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductLoadPrices {\n");
    
    sb.append("  _default: ").append(_default).append("\n");
    sb.append("  offer: ").append(offer).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
