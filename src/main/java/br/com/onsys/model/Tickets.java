package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Tickets  {
  
  private List<Ticket> tickets = new ArrayList<Ticket>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   * Tickets
   **/
  @ApiModelProperty(value = "Tickets")
  @JsonProperty("tickets")
  public List<Ticket> getTickets() {
    return tickets;
  }
  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  
  /**
   * Leia mais sobre os metadados retornados nas listagens em <a href='../apis/index.html#search'>Metadada</a>
   **/
  @ApiModelProperty(value = "Leia mais sobre os metadados retornados nas listagens em <a href='../apis/index.html#search'>Metadada</a>")
  @JsonProperty("metadata")
  public List<MetadataEntry> getMetadata() {
    return metadata;
  }
  public void setMetadata(List<MetadataEntry> metadata) {
    this.metadata = metadata;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tickets {\n");
    
    sb.append("  tickets: ").append(tickets).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
