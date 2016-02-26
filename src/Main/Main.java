package Main;

import Compradores.*;
import Paquetes.*;

public class Main {

	public static void main(String args[]) {

		Cliente cliente = new Cliente(50);
		Paquete paquete = new Paquete(40000, 1.2, new PrecioFijo());
		
		
		System.out.println("Saldo del Cliente antes de compra:" + cliente.getSaldo());
		
		cliente.comprarPaquete(paquete);
	
		System.out.println("compras realizadas: " + cliente.getCantidadDeCompras());
		System.out.println("total gastado: " + cliente.getTotalGastado());
	}
}
