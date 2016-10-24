package com.matex.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matex.app.model.Client;
import com.matex.app.model.to.ClientTo;


@Component
public class ClientMapper {


	public ClientTo mapModel2To(Client client) {
		return new ClientTo(client.getEmail(), client.getName(), client.getId());
	}

	public Client mapTo2Model(ClientTo clientTo) {
		return new Client(clientTo.getEmail(), clientTo.getName());
	}
	public List<ClientTo> mapModels2Tos(List<Client> clients) {
		List<ClientTo> clientsTo = new ArrayList<ClientTo>();
		for (Client client : clients) {
			clientsTo.add(new ClientTo(client.getEmail(), client.getName(), client.getId()));
		}
	    return clientsTo;
	  }

	  public List<Client> mapTos2Models(List<ClientTo> clientTos) {
		  List<Client> clients = new ArrayList<Client>();
			for (ClientTo client : clientTos) {
				clients.add(new Client(client.getEmail(), client.getName()));
			}
		    return clients;
	  }
}
