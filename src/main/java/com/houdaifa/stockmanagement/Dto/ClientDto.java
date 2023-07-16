package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Adresse;
import com.houdaifa.stockmanagement.model.Article;
import com.houdaifa.stockmanagement.model.Client;
import com.houdaifa.stockmanagement.model.CommandeClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
  private Integer id;
  private String nom;
  private String prenom;
  private Adresse adresse;
  private String photo;
  private String mail;
  private String numTel;
  private AddressDto address;
  private List<CommandeClientDto>commandeClients;

  public static Client toEntity(ClientDto clientDto){
   if(clientDto==null){
     return null;
   }
   Client client=new Client();
   client.setAdresse(clientDto.getAdresse());
   client.setMail(clientDto.getMail());
   client.setCommandeClients(client.getCommandeClients());
   client.setNumTel(clientDto.getNumTel());
   List<CommandeClient>commandeClients1=new ArrayList<>();
      for(CommandeClientDto commandeClientDto:clientDto.getCommandeClients()){
          CommandeClient commandeClient=new CommandeClient();
          commandeClient=commandeClientDto.toEntity(commandeClientDto);
          commandeClients1.add(commandeClient);
      }
   client.setCommandeClients(commandeClients1);
   client.setPhoto(clientDto.getPhoto());
   client.setNom(clientDto.getNom());
   client.setAdresse(clientDto.getAdresse());
   client.setPrenom(clientDto.getPrenom());
   return client;
  }
  public  static ClientDto fromEntity(Client client){
      if(client==null){
          return  null;
      }
      else{
        ClientDto clientDto=new ClientDto();
        clientDto.setAdresse(client.getAdresse());
        clientDto.setMail(client.getMail());
        List<CommandeClientDto>commandeClientDtos=new ArrayList<>();
          for(CommandeClient commandeClient:client.getCommandeClients()){
              CommandeClientDto commandeClientDto=new CommandeClientDto();
              commandeClientDto.fromEntity(commandeClient);
              commandeClientDtos.add(commandeClientDto);

          }

        clientDto.setCommandeClients(commandeClientDtos);
        clientDto.setNumTel(client.getNumTel());
        clientDto.setId(client.getId());
        clientDto.setPhoto(client.getPhoto());
        clientDto.setNom(client.getNom());
        clientDto.setPrenom(client.getPrenom());
        return clientDto;
      }
  }



}
