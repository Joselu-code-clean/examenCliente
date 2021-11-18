package com.bootcamp.nttdata.examenCliente.builder;

import com.bootcamp.nttdata.examenCliente.models.Producto;

public class BuilderProducto implements BuilderI{

	private Producto producto = new Producto("Unknown",0.0);
	
	public BuilderProducto conNombre(String nombre) {
		if (nombre.isBlank() || nombre.isEmpty()) {
			this.producto.setNombre("Unknown");
		} else {
			this.producto.setNombre(nombre);
		}
		return this;
	}
	
	public BuilderProducto conPrecio(double precio) {
		if (precio < 0) {
			this.producto.setPrecio(0);
		} else {
			this.producto.setPrecio(precio);
		}
		return this;
	}

	@Override
	public Producto build() {
		// TODO Auto-generated method stub
		return this.producto;
	}
	
}
