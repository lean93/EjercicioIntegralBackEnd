package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


import Compradores.Cliente;
import Excepciones.FalloEnCompraExcepcion;
import Paquetes.Paquete;

@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class SpringIntegralTest extends AbstractJUnit4SpringContextTests {

	private Cliente cliente;


	@Before
	public void setUp() {
		cliente = new Cliente(3000);
	
	}

	@Test
	public void testSpring() throws FalloEnCompraExcepcion {
		Paquete paquete = (Paquete) applicationContext.getBean("paquete");

		cliente.comprarPaquete(paquete);
		assertEquals(1,cliente.getCantidadDeCompras());
		assertEquals(2700, cliente.getSaldo(),0.01);
	}

}
