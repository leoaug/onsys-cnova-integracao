package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrderReference  {
  
  private Integer id = null;
  private String href = null;

  
  /**
   * ID do pedido.
   **/
  @ApiModelProperty(value = "ID do pedido.")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * URL de consulta da ordem por ID.
   **/
  @ApiModelProperty(value = "URL de consulta da ordem por ID.")
  @JsonProperty("href")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderReference {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  href: ").append(href).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
