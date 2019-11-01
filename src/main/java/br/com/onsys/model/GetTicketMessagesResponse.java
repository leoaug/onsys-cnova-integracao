package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetTicketMessagesResponse  {
  
  private List<TicketMessage> messages = new ArrayList<TicketMessage>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   * Mensagens
   **/
  @ApiModelProperty(value = "Mensagens")
  @JsonProperty("messages")
  public List<TicketMessage> getMessages() {
    return messages;
  }
  public void setMessages(List<TicketMessage> messages) {
    this.messages = messages;
  }

  
  /**
   * Metadados do status
   **/
  @ApiModelProperty(required = true, value = "Metadados do status")
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
    sb.append("class GetTicketMessagesResponse {\n");
    
    sb.append("  messages: ").append(messages).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
