package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SellerItemReference  {
  
  private String id = null;
  private String href = null;

  
  /**
   * ID do produto
   **/
  @ApiModelProperty(value = "ID do produto")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Caminho do produto
   **/
  @ApiModelProperty(value = "Caminho do produto")
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
    sb.append("class SellerItemReference {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  href: ").append(href).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
