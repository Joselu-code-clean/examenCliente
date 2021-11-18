package com.bootcamp.nttdata.examenCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.nttdata.examenCliente.builder.BuilderProducto;
import com.bootcamp.nttdata.examenCliente.controllers.ClientController;
import com.bootcamp.nttdata.examenCliente.models.Producto;

@SpringBootApplication
public class ExamenClienteApplication implements CommandLineRunner{

	@Autowired
	ClientController controller;
	
	/*BUILDER*/
	private BuilderProducto builder = new BuilderProducto();
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamenClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Vamos ha realizar los metodos del CRUD que tenemos en el servicio.
		// Usando programacion funcional
		Producto producto = builder.conNombre("Camiseta").conPrecio(9.99d).build();
		
		// INSERTAMOS EL PRODUCTO EN EL STARTER
		controller.insertarProducto(producto);
		
		// Usando programacion funcional
		// COMPROBAMOS EL ALMACEN
		controller.consultarAlmacen().stream().forEach(System.out::println);
	}

}
