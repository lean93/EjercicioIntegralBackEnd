package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import Compradores.*;
import Excepciones.*;
import Paquetes.*;

public class TestUsuario {
	
	private Individuo leandro;
	@Before
	public void setUp(){
	
		 leandro = new Individuo(2000);
	}
	
	
	@Test
	public void leandroTiene2000DeSaldo(){
		assertEquals(2000.0, leandro.getSaldo(),0.001);
	}
		

}
