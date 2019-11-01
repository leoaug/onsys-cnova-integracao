package br.com.onsys.model;



import java.util.Date;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Ticket  {
  
  private String code = null;
  private String status = null;
  private String description = null;
  private Date createdAt = null;
  private Date updatedAt = null;
  private Date closedAt = null;
  private String priority = null;
  private TicketAssignedUser assignee = null;
  private Ombudsman ombudsman = null;
  private CustomerReference customer = null;
  private String site = null;
  private String channel = null;
  private TicketType type = null;
  private TicketSubject subject = null;
  private TicketSla sla = null;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   * ID do ticket
   **/
  @ApiModelProperty(value = "ID do ticket")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  
  /**
   * Status do ticket que são classificados como: <strong>'opened', 'closed' e 'attendance'.</strong>
   **/
  @ApiModelProperty(value = "Status do ticket que são classificados como: <strong>'opened', 'closed' e 'attendance'.</strong>")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * Descrição do ticket
   **/
  @ApiModelProperty(value = "Descrição do ticket")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   * Data da criação do ticket
   **/
  @ApiModelProperty(value = "Data da criação do ticket")
  @JsonProperty("createdAt")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * Atualização do ticket
   **/
  @ApiModelProperty(value = "Atualização do ticket")
  @JsonProperty("updatedAt")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  
  /**
   * Data de encerramento do ticket
   **/
  @ApiModelProperty(value = "Data de encerramento do ticket")
  @JsonProperty("closedAt")
  public Date getClosedAt() {
    return closedAt;
  }
  public void setClosedAt(Date closedAt) {
    this.closedAt = closedAt;
  }

  
  /**
   * Prioridade do ticket possui os seguintes valores: <strong>'Normal' e 'Em Acompanhamento'</strong>
   **/
  @ApiModelProperty(value = "Prioridade do ticket possui os seguintes valores: <strong>'Normal' e 'Em Acompanhamento'</strong>")
  @JsonProperty("priority")
  public String getPriority() {
    return priority;
  }
  public void setPriority(String priority) {
    this.priority = priority;
  }

  
  /**
   * Responsável pelo atendimento do protocolo.
   **/
  @ApiModelProperty(value = "Responsável pelo atendimento do protocolo.")
  @JsonProperty("assignee")
  public TicketAssignedUser getAssignee() {
    return assignee;
  }
  public void setAssignee(TicketAssignedUser assignee) {
    this.assignee = assignee;
  }

  
  /**
   * Informações de ouvidoria
   **/
  @ApiModelProperty(value = "Informações de ouvidoria")
  @JsonProperty("ombudsman")
  public Ombudsman getOmbudsman() {
    return ombudsman;
  }
  public void setOmbudsman(Ombudsman ombudsman) {
    this.ombudsman = ombudsman;
  }

  
  /**
   * Cliente associado ao ticket
   **/
  @ApiModelProperty(value = "Cliente associado ao ticket")
  @JsonProperty("customer")
  public CustomerReference getCustomer() {
    return customer;
  }
  public void setCustomer(CustomerReference customer) {
    this.customer = customer;
  }

  
  /**
   * Site de origem do protocolo. Os valores disponíveis no site são: <strong> CD, BT, EH, EX, PF, e CB </strong>
   **/
  @ApiModelProperty(value = "Site de origem do protocolo. Os valores disponíveis no site são: <strong> CD, BT, EH, EX, PF, e CB </strong>")
  @JsonProperty("site")
  public String getSite() {
    return site;
  }
  public void setSite(String site) {
    this.site = site;
  }

  
  /**
   * O canal de atendimento de origem do protocolo, possui os seguintes valores: <strong> Fale Conosco, Admin Seller, CallCenter, Email, e External Service</strong>
   **/
  @ApiModelProperty(value = "O canal de atendimento de origem do protocolo, possui os seguintes valores: <strong> Fale Conosco, Admin Seller, CallCenter, Email, e External Service</strong>")
  @JsonProperty("channel")
  public String getChannel() {
    return channel;
  }
  public void setChannel(String channel) {
    this.channel = channel;
  }

  
  /**
   * Tipo do ticket.
   **/
  @ApiModelProperty(value = "Tipo do ticket.")
  @JsonProperty("type")
  public TicketType getType() {
    return type;
  }
  public void setType(TicketType type) {
    this.type = type;
  }

  
  /**
   * Assunto relacionado ao ticket.
   **/
  @ApiModelProperty(value = "Assunto relacionado ao ticket.")
  @JsonProperty("subject")
  public TicketSubject getSubject() {
    return subject;
  }
  public void setSubject(TicketSubject subject) {
    this.subject = subject;
  }

  
  /**
   * Informações sobre o prazo de atendimento do ticket.
   **/
  @ApiModelProperty(value = "Informações sobre o prazo de atendimento do ticket.")
  @JsonProperty("sla")
  public TicketSla getSla() {
    return sla;
  }
  public void setSla(TicketSla sla) {
    this.sla = sla;
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
    sb.append("class Ticket {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  closedAt: ").append(closedAt).append("\n");
    sb.append("  priority: ").append(priority).append("\n");
    sb.append("  assignee: ").append(assignee).append("\n");
    sb.append("  ombudsman: ").append(ombudsman).append("\n");
    sb.append("  customer: ").append(customer).append("\n");
    sb.append("  site: ").append(site).append("\n");
    sb.append("  channel: ").append(channel).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  subject: ").append(subject).append("\n");
    sb.append("  sla: ").append(sla).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
