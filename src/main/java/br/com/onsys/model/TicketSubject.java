package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketSubject  {
  
  private Integer id = null;
  private String name = null;

  
  /**
   * Identificador do assunto.
   **/
  @ApiModelProperty(value = "Identificador do assunto.")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Descrição do assunto relacionado ao ticket.
   **/
  @ApiModelProperty(value = "Descrição do assunto relacionado ao ticket.")
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
    sb.append("class TicketSubject {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
