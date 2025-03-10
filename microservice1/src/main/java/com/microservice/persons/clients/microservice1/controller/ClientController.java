package com.microservice.persons.clients.microservice1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.persons.clients.microservice1.dto.ClientDto;
import com.microservice.persons.clients.microservice1.service.ClientService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    // GET ALL CLIENTS REST API
    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients () {
        List<ClientDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }
    
    // GET CLIENT REST API
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getMethodName (@PathVariable("id") String clinetId) {
        ClientDto clientDto = clientService.getClientById(clinetId);
        return ResponseEntity.ok(clientDto);
    }

    // ADD CLIENT REST API
    @Validated
    @PostMapping
    public ResponseEntity<ClientDto> createClient (@Valid @RequestBody ClientDto clientDto) {
        ClientDto savedClient = clientService.createClient(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    // UPDATE CLIENT REST API
    @Validated
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient (@PathVariable("id") String clientId,
                                            @Valid @RequestBody ClientDto updatedClientDto) {
        ClientDto clientDto = clientService.updateClient(clientId, updatedClientDto);
        return ResponseEntity.ok(clientDto);
    }

    // SOFT DELETE CLIENT REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") String clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }

    // ACTIVATE CLIENT REST API
    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activateClient(@PathVariable("id") String clientId) {
        clientService.activateClient(clientId);
        return ResponseEntity.ok("Client with ID: " + clientId + ", activated successfully");
    }

}
