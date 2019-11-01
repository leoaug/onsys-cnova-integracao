package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketStatus  {
  
  public enum TicketStatusEnum {
     attendance,  closed, 
  };
  private TicketStatusEnum ticketStatus = null;

  
  /**
   * Novo status desejado do Ticket. Fechado <strong> (closed) </strong> e Em Acompanhamento <strong> (attendance) </strong>
   **/
  @ApiModelProperty(required = true, value = "Novo status desejado do Ticket. Fechado <strong> (closed) </strong> e Em Acompanhamento <strong> (attendance) </strong>")
  @JsonProperty("ticketStatus")
  public TicketStatusEnum getTicketStatus() {
    return ticketStatus;
  }
  public void setTicketStatus(TicketStatusEnum ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketStatus {\n");
    
    sb.append("  ticketStatus: ").append(ticketStatus).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
