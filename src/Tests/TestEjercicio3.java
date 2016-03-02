package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Compradores.*;
import Excepciones.FalloEnCompraExcepcion;
import Excepciones.SinSaldoException;
import Excepciones.VariasComprasException;
import Paquetes.*;

public class TestEjercicio3 {

	private Individuo leandro;
	private Individuo leanCortoDeEfectivo;
	private Paquete paquete1;
	private Paquete paqueteMardel;
	private Paquete elTercerPaquete;

	@Before
	public void setUp() {

		leanCortoDeEfectivo = new Individuo(200);
		leandro = new Individuo(900);
		paquete1 = new Paquete(1.25, new PrecioFijo(500));
		paqueteMardel = new Paquete(1.2, new SegunHabitacion(2, 50));
		elTercerPaquete = new Paquete(1.2, new SegunHabitacion(4, 50));
	}

	@Test
	public void leanNoTieneSaldoParaRealizarUnaCompra() {

		try {
			leanCortoDeEfectivo.realizarPago(paquete1.getPrecioPaquete(leandro));
			fail("Como no tiene suficiente saldo, deberia lanzar una excepcion");
		} catch (SinSaldoException e) {
			assertEquals(leanCortoDeEfectivo.getSaldo(), 200, 0.01);
		}
	}

	@Test(expected = FalloEnCompraExcepcion.class)
	public void falloEnLaCompraPorqueLeanSeQuedaSinSaldoPorTantasCompras() throws FalloEnCompraExcepcion {
			leandro.comprarPaquete(paquete1);
			leandro.comprarPaquete(paqueteMardel);
			leandro.comprarPaquete(elTercerPaquete);
			fail("Como se queda sin saldo, deberia lanzar una excepcion para cortar el flujo de compra");
	}
	
	@Test(expected = VariasComprasException.class)
	public void falloEnLaCompraPorqueYaTineUnaReserva() throws SinSaldoException, FalloEnCompraExcepcion{
		
			leandro.reservarPaquete(paquete1);
			leandro.comprarPaquete(elTercerPaquete);
			fail("como tiene una reserva no puede comprar");
	}
}
