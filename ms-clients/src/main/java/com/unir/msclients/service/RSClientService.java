package com.unir.msclients.service;

import java.util.List;

import com.unir.msclients.model.pojo.RSClient;
import com.unir.msclients.model.request.CreateRSClientRequest;

public interface RSClientService {

    List<RSClient> getRSClients();

    RSClient getRSClient(String clientid);

    RSClient createRSClient(CreateRSClientRequest request);
}
