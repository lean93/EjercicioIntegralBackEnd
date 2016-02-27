package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import Compradores.*;
import Excepciones.SinSaldoException;
import Paquetes.*;

public class TestEjercicio2 {

	private Individuo leandro;
	private Empresa utn;
	private Paquete paquete1;
	private Paquete paqueteMardel;
	private Paquete elTercerPaquete;

	@Before
	public void setUp() {

		leandro = new Individuo(2000);
		paquete1 = new Paquete(1.25, new PrecioFijo(500));
		paqueteMardel = new Paquete(1.2, new SegunHabitacion(2, 50));
		elTercerPaquete = new Paquete(1.2, new SegunHabitacion(4, 50));
		utn = new Empresa(2000);
	}

	@Test
	public void leanCompro2PaquetesYGastoEnTotal745() {
		leandro.comprarPaquete(paquete1);
		leandro.comprarPaquete(paqueteMardel);
		assertEquals(745, leandro.getTotalGastado(), 0.01);
		assertEquals(2, leandro.getCantidadDeCompras());
	}

	@Test
	public void elPaqueteMasCaroCompradoParaLeanEsElPaquete1() {
		
		Collection<Paquete> paquetesAEvaluar= new ArrayList<Paquete>();
		paquetesAEvaluar.add(paqueteMardel);
		paquetesAEvaluar.add(paquete1);
		assertEquals(leandro.getPaqueteMasCaro(paquetesAEvaluar), paquete1);
	}
	
	@Test
	public void laUTNCompra3PaquetesAlMismoTiempoYGasta985(){
		
		Collection<Paquete> paquetesAComprar= new ArrayList<Paquete>();
		paquetesAComprar.add(paquete1);
		paquetesAComprar.add(paqueteMardel);
		paquetesAComprar.add(elTercerPaquete);
		utn.comprarVarios(paquetesAComprar);
		assertEquals(985,utn.getTotalGastado(),0.001);
		assertEquals(3,utn.getCantidadDeCompras());
	}
	
	@Test
	public void leanReservaUnPaqueteYLuegoTerminaLaCompra() throws SinSaldoException{
		
		leandro.reservarPaquete(elTercerPaquete);
		//El paquete se encuentra reservado y pago la mitad del precio ($120)
		assertEquals(leandro.getPaqueteEnReserva(), elTercerPaquete);
		assertEquals(leandro.getSaldo(), 1880, 0.01);
	    assertEquals(leandro.getCantidadDeCompras(),0);
	    
	    leandro.terminarCompra();
	    
	    
	    //Al terminar el proceso de reserva, paga la otra mitad, y se hace efectiva la compra
	   
	    assertEquals(leandro.getSaldo(),1760,0.001);
	    assertEquals(leandro.getCantidadDeCompras(),1);
	    assertEquals(leandro.getPaqueteEnReserva(), null);
		
	}
	
}
