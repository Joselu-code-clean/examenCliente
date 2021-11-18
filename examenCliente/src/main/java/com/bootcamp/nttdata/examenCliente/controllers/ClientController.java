package com.bootcamp.nttdata.examenCliente.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.nttdata.examenCliente.models.Producto;

@RestController
public class ClientController {

	RestTemplate restTemplate = new RestTemplate();
	String urlBase = "http://localhost:8888/actuator/almacen";
	URI url = URI.create(urlBase);
	
	
	public List<Producto> consultarAlmacen() {
		// No se si funciona, o tendria que retornar un JSON e interpretarlo en esta funcion.
		ResponseEntity<List<Producto>> response = restTemplate.getForEntity(url+"/consultarAlmacen", null);
		return response.getBody();
	}
	
	public void insertarProducto(Producto producto) {
		restTemplate.postForEntity(URI.create(urlBase+"/"+producto), producto, Producto.class);
	}
	
	public void eliminarProducto(int id) {
		restTemplate.postForEntity(URI.create(urlBase+"/"+id), id, Integer.class);
	}
	
}
