package com.pcci.idls.maintenance.client.service;

import java.util.List;

import com.pcci.idls.maintenance.client.domain.Client;

public interface ClientService {
    public void store(Client Client);
    public void delete(String ClientId);
    public Client findById(String ClientId);
    public List<Client> findAll();
    public List<Client> findByClientName(String clientName);
}
