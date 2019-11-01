package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SellerItemStatus  {
  
  private Boolean active = null;
  private String site = null;

  
  /**
   * Indica se o produto está ativo 'TRUE' (à venda no MP) ou não 'FALSE'
   **/
  @ApiModelProperty(required = true, value = "Indica se o produto está ativo 'TRUE' (à venda no MP) ou não 'FALSE'")
  @JsonProperty("active")
  public Boolean getActive() {
    return active;
  }
  public void setActive(Boolean active) {
    this.active = active;
  }

  
  /**
   * Site para o qual o status é considerado. Os possíveis sites são: 'EX','PF','CB', 'EH', 'BT', 'CD'.
   **/
  @ApiModelProperty(required = true, value = "Site para o qual o status é considerado. Os possíveis sites são: 'EX','PF','CB', 'EH', 'BT', 'CD'.")
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
    sb.append("class SellerItemStatus {\n");
    
    sb.append("  active: ").append(active).append("\n");
    sb.append("  site: ").append(site).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
