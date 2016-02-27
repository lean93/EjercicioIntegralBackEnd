package Compradores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Paquetes.*;
import Excepciones.*;

public class Cliente {

	private double saldo;
	private List<Paquete> compras;

	public Cliente(double unSaldo) {
		saldo = unSaldo;
		compras = new ArrayList<Paquete>();
	}

	public void comprarPaquete(Paquete unPaquete) {
		
		try{
		realizarPago(unPaquete.getPrecioPaquete(this));
		añadirPaquete(unPaquete);
		
		} catch(SinSaldoException e){
			System.out.println(e.getMessage() );
		} finally{
			System.out.println("saldo del Cliente: " + getSaldo() );
		}
	}
	
	public void realizarPago(double unMonto) throws SinSaldoException{
		if (saldo > unMonto){
			saldo = saldo - unMonto;
		} else {throw new SinSaldoException("Te quedaste sin saldo pibe !!");}
		
	}
	
	public void añadirPaquete(Paquete unPaquete){
		
		compras.add(unPaquete);
	}

	public double getSaldo() {
		return saldo;
	}

	public int getCantidadDeCompras() {
		return compras.size();
	}

	public double getTotalGastado() {
		double total = 0;

		for (Paquete p : compras) {
			total = total + p.getPrecioPaquete(this);
		}
		return total;
	}

	public Paquete getPaqueteMasCaro(Collection<Paquete> unaListaDePaquetes) {

		Paquete masCaro = new Paquete();
		double mayor = 0;

		for (Paquete unPaquete : unaListaDePaquetes) {

			if (unPaquete.getPrecioPaquete(this) > mayor) {
				masCaro = unPaquete;
				mayor = unPaquete.getPrecioPaquete(this);
			}
		}
		return masCaro;
	}
	
	
	

}
