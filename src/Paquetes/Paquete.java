package Paquetes;

import org.springframework.beans.factory.annotation.Required;

import Compradores.*;
public class Paquete {

	
	private double impuesto;
	private TipoPaquete tipoPaquete;

	public Paquete(double unImpuesto, TipoPaquete unTipo) {
		impuesto = unImpuesto;
		tipoPaquete = unTipo;
	}
	
	public Paquete(double unImupuesto){
		impuesto = unImupuesto;
	}

	public Paquete() {

	}

	public double getPrecioPaquete(Cliente unCliente) {
		return tipoPaquete.calcularPrecioBase(unCliente) * impuesto;
	}

	public double getMedioPrecio(Cliente unCliente) {
		return getPrecioPaquete(unCliente) / 2;
	}
	public TipoPaquete getTipoPaquete(){
		return tipoPaquete;
	}
	@Required
	public void setImpuesto(double unImpuesto){
		this.impuesto= unImpuesto;
	}
    @Required
	public void setTipoPaquete(TipoPaquete unTipo){
		this.tipoPaquete = unTipo;
	}
}
