package Main;

import Compradores.*;
import Excepciones.FalloEnCompraExcepcion;
import Paquetes.*;

public class Main {

	public static void main(String args[]) throws FalloEnCompraExcepcion {

		Cliente cliente = new Cliente(50);
		Paquete paquete = new Paquete(1.2, new PrecioFijo(500));
		System.out.println("Saldo del Cliente antes de compra:" + cliente.getSaldo());
		cliente.comprarPaquete(paquete);
		System.out.println("compras realizadas: " + cliente.getCantidadDeCompras());
		System.out.println("total gastado: " + cliente.getTotalGastado());
	}
}
