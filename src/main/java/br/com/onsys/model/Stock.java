package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Stock  {
  
  private Integer quantity = null;
  private Integer crossDockingTime = null;
  private Integer warehouse = null;

  
  /**
   * Quantidade de produtos disponíveis
   **/
  @ApiModelProperty(required = true, value = "Quantidade de produtos disponíveis")
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  
  /**
   * Tempo de preparação/fabricação do produto em dias. Esse tempo é incluído no cálculo de frete
   **/
  @ApiModelProperty(value = "Tempo de preparação/fabricação do produto em dias. Esse tempo é incluído no cálculo de frete")
  @JsonProperty("crossDockingTime")
  public Integer getCrossDockingTime() {
    return crossDockingTime;
  }
  public void setCrossDockingTime(Integer crossDockingTime) {
    this.crossDockingTime = crossDockingTime;
  }

  
  /**
   * ID do depósito no qual o estoque do produto está sendo considerado. Consulte a lista completa de warehouses disponíveis no serviço <a href='#!/warehouses' target='_blank'><strong>GET /warehouses</strong></a>
   **/
  @ApiModelProperty(value = "ID do depósito no qual o estoque do produto está sendo considerado. Consulte a lista completa de warehouses disponíveis no serviço <a href='#!/warehouses' target='_blank'><strong>GET /warehouses</strong></a>")
  @JsonProperty("warehouse")
  public Integer getWarehouse() {
    return warehouse;
  }
  public void setWarehouse(Integer warehouse) {
    this.warehouse = warehouse;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stock {\n");
    
    sb.append("  quantity: ").append(quantity).append("\n");
    sb.append("  crossDockingTime: ").append(crossDockingTime).append("\n");
    sb.append("  warehouse: ").append(warehouse).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
