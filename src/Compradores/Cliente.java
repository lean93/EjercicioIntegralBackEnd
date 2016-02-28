package Compradores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Paquetes.*;
import Excepciones.*;

import org.apache.logging.log4j.*;

public class Cliente {

	private static final Logger logger = LogManager.getLogger();

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
			logger.info("Realizando Compra");
			realizarPago(unPaquete.getPrecioPaquete(this));
			añadirPaquete(unPaquete);

			logger.info("Compra Realizada Exitosamente");

		} catch (SinSaldoException e) {
			System.out.println(e.getMessage());
			logger.error("Fallo en la Compra");
			throw new FalloEnCompraExcepcion("Hubo un problema en la compra");

		} finally {
			logger.info("Mostrando Saldo del Cliente");
			System.out.println("saldo del Cliente: " + getSaldo());
		}
	}

	public void realizarPago(double unMonto) throws SinSaldoException {
		if (saldo > unMonto) {
			logger.info("Efectuando el Pago");
			saldo = saldo - unMonto;
		} else {
			logger.error("Saldo insuficiente para realizar el pago");
			throw new SinSaldoException("Te quedaste sin saldo pibe !!");
		}

	}

	public void añadirPaquete(Paquete unPaquete) {
		logger.info("Añadiendo el paquete a Compras");
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
		logger.info("Buscando el Paquete mas Caro");
		for (Paquete unPaquete : unaListaDePaquetes) {

			if (unPaquete.getPrecioPaquete(this) > mayor) {
				masCaro = unPaquete;
				mayor = unPaquete.getPrecioPaquete(this);
			}
		}
		logger.info("Paquete mas caro encontrado");
		return masCaro;
	}

}
