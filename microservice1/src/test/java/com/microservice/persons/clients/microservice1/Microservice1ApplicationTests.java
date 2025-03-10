package com.microservice.persons.clients.microservice1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microservice.persons.clients.microservice1.entity.Client;
import com.microservice.persons.clients.microservice1.entity.Person;

class Microservice1ApplicationTests {

	private Client client;
    private Person mockPerson;

    @BeforeEach
    public void setUp() {
        mockPerson = mock(Person.class);
        when(mockPerson.getId()).thenReturn(1);

        client = new Client("1", "password123", "A", mockPerson);
    }

    @Test
    public void testClientCreation() {
        // Verificar que los valores de las propiedades se hayan asignado correctamente
        assertEquals("1", client.getId());
        assertEquals("password123", client.getPassword());
        assertEquals("A", client.getState());
        assertNotNull(client.getIdPerson());
        assertEquals(1, client.getIdPerson().getId());
    }

    @Test
    public void testClientWithNullPerson() {
        // Crear un cliente sin Person asociado
        Client clientWithoutPerson = new Client("2", "password456", "A", null);

        // Verificar que el Person sea null
        assertNull(clientWithoutPerson.getIdPerson());
    }

    @Test
    public void testSettersAndGetters() {
        // Modificar el cliente y verificar que los setters funcionan correctamente
        client.setPassword("newPassword");
        client.setState("I");

        assertEquals("newPassword", client.getPassword());
        assertEquals("I", client.getState());
    }

}
