package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Client;
import com.houdaifa.stockmanagement.model.CommandeClient;
import com.houdaifa.stockmanagement.model.LigneCommandeClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private  ClientDto client;
    private List<LigneCommandeClientDto> ligneCommandeClients;
    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        } else {
           CommandeClientDto commandeClientDto=new CommandeClientDto();
           ClientDto clientDto=new ClientDto();
           clientDto.fromEntity(commandeClient.getClient());
           commandeClientDto.setClient(clientDto);
           List<LigneCommandeClientDto>ligneCommandeClientDtos=new ArrayList<>();
           for (LigneCommandeClient ligneCommandeClient:commandeClient.getLIgneCommandeClients()){
               LigneCommandeClientDto ligneCommandeClientDto=new LigneCommandeClientDto();
               ligneCommandeClientDto.fromEntity(ligneCommandeClient);
               ligneCommandeClientDtos.add(ligneCommandeClientDto);

           }
           commandeClientDto.setLigneCommandeClients(ligneCommandeClientDtos);
           commandeClientDto.setId(commandeClient.getId());
           commandeClientDto.setDateCommande(commandeClient.getDateCommande());
           commandeClientDto.setCode(commandeClient.getCode());
           return commandeClientDto;

        }
    }
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto==null){
            return  null;
        }
        else{
            CommandeClient commandeClient=new CommandeClient();
            Client client=new Client();
            client=commandeClientDto.client.toEntity(commandeClientDto.getClient());
            commandeClient.setClient(client);
            commandeClient.setDateCommande(commandeClientDto.getDateCommande());
            List<LigneCommandeClient>ligneCommandeClients=new ArrayList<>();
            for (LigneCommandeClientDto ligneCommandeClientDto:commandeClientDto.getLigneCommandeClients()){
                LigneCommandeClient ligneCommandeClient=new LigneCommandeClient();
               ligneCommandeClient= ligneCommandeClientDto.toEntity(ligneCommandeClientDto);
                ligneCommandeClients.add(ligneCommandeClient);

            }
            commandeClient.setLIgneCommandeClients(ligneCommandeClients);
            commandeClient.setDateCommande(commandeClientDto.getDateCommande());
            commandeClient.setCode(commandeClient.getCode());
            return commandeClient;
        }

    }

}
