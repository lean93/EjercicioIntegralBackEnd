package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Compradores.*;
import Paquetes.*;

public class TestEjercicio2 {

	private Individuo leandro;
	private Paquete paquete1;
	private Paquete paquete2;
	
	@Before
	public void setUp(){
		
		leandro = new Individuo(3000);
		paquete1 = new Paquete(400, 1.5, new PrecioFijo());
		paquete2 = new Paquete(200, 1.1, new PrecioFijo());
		
	}
	
	@Test
	public void leanCompro2PaquetesYGastoEnTotal820(){
		leandro.comprarPaquete(paquete1);
		leandro.comprarPaquete(paquete2);
		
		//600 del primer paquete y 220 del segundo
		
		assertEquals(820, leandro.getTotalGastado(),0.01);
		assertEquals(2, leandro.getCantidadDeCompras());
	}
	
	
}
