package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Promotion  {
  
  private String id = null;
  private String name = null;
  private Double amount = null;
  private String type = null;

  
  /**
   * ID da promoção que o produto foi adquirido
   **/
  @ApiModelProperty(required = true, value = "ID da promoção que o produto foi adquirido")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Descrição da promoção
   **/
  @ApiModelProperty(value = "Descrição da promoção")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Total de desconto
   **/
  @ApiModelProperty(value = "Total de desconto")
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  
  /**
   * Tipo da promoção
   **/
  @ApiModelProperty(value = "Tipo da promoção")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Promotion {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
