package Compradores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Paquetes.*;

import Excepciones.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cliente {

	
	private static final  Logger LOGGER = LoggerFactory.getLogger(Cliente.class);

	private double saldo;
	private List<Paquete> compras;

	public Cliente(double unSaldo) {
		saldo = unSaldo;
		compras = new ArrayList<Paquete>();
	}

	public Collection<Paquete> getPaquetesComprados() {

		return compras;
	}

	public void comprarPaquete(Paquete unPaquete) throws FalloEnCompraExcepcion {

		try {
			LOGGER.info("Realizando Compra con un Saldo de {} ", getSaldo());
			realizarPago(unPaquete.getPrecioPaquete(this));
			añadirPaquete(unPaquete);

			LOGGER.info("Compra Realizada Exitosamente");

		} catch (SinSaldoException e) {
		
			LOGGER.error("Sin saldo no hay compra");
			throw new FalloEnCompraExcepcion("Falta Saldo, No se puede comprar", e);

		} catch (VariasComprasException e1) {
			LOGGER.error("Ya tenes una reserva... no podes Comprar Otra");
			throw new FalloEnCompraExcepcion("Ya tenes una reserva, No se puede seguir con la compra", e1);
		}
		finally {
			LOGGER.info("Mostrando Saldo del Cliente");
			LOGGER.info("saldo del Cliente: {} ", getSaldo());
		}
	}

	public void realizarPago(double unMonto) throws SinSaldoException {
		if (saldo > unMonto) {
			LOGGER.info("Efectuando el Pago");
			saldo = saldo - unMonto;
		} else {
			LOGGER.error("Saldo insuficiente para realizar el pago");
			throw new SinSaldoException("Te quedaste sin saldo pibe !!");
		}

	}

	public void añadirPaquete(Paquete unPaquete) {
		LOGGER.info("Añadiendo el paquete a Compras");
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
		LOGGER.info("Buscando el Paquete mas Caro");
		for (Paquete unPaquete : unaListaDePaquetes) {

			if (unPaquete.getPrecioPaquete(this) > mayor) {
				masCaro = unPaquete;
				mayor = unPaquete.getPrecioPaquete(this);
			}
		}
		LOGGER.info("Paquete mas caro encontrado");
		return masCaro;
	}
	

}
