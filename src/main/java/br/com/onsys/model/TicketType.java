package br.com.onsys.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketType  {
  
  private Integer id = null;
  private String name = null;

  
  /**
   * Identificador do tipo de ticket.
   **/
  @ApiModelProperty(value = "Identificador do tipo de ticket.")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Descrição do tipo de ticket com a ação esperada.
   **/
  @ApiModelProperty(value = "Descrição do tipo de ticket com a ação esperada.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketType {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
