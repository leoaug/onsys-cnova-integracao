package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Prices  {
  
  private Double _default = null;
  private Double offer = null;
  private String site = null;

  
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

  
  /**
   * Site no qual o preço será aplicado. Os possíveis sites são: 'EX', 'PF', 'CB', 'EH', 'BT', 'CD'. Caso nenhum valor seja informado, será assumido o valor 'EX' como padrão. Consulte a lista completa de sites disponíveis no serviço <a href='#!/sites' target='_blank'><strong>GET /sites</strong></a>
   **/
  @ApiModelProperty(value = "Site no qual o preço será aplicado. Os possíveis sites são: 'EX', 'PF', 'CB', 'EH', 'BT', 'CD'. Caso nenhum valor seja informado, será assumido o valor 'EX' como padrão. Consulte a lista completa de sites disponíveis no serviço <a href='#!/sites' target='_blank'><strong>GET /sites</strong></a>")
  @JsonProperty("site")
  public String getSite() {
    return site;
  }
  public void setSite(String site) {
    this.site = site;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prices {\n");
    
    sb.append("  _default: ").append(_default).append("\n");
    sb.append("  offer: ").append(offer).append("\n");
    sb.append("  site: ").append(site).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
