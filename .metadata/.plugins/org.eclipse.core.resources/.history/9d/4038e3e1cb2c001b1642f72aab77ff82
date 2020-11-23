package simpleUnitTests;
import org.junit.Test;

import primitives.Coordinator;

import static org.junit.Assert.*;


public class CoordinatTest {

	@Test
	public void testSet(){
	
		Coordinator c=new Coordinator();
		c.setCoordinate(5);
		assertEquals(5,c.getCoordinate(),0.1);
	}


	@Test
	public void testEquals() {
		Coordinator c=new Coordinator(5);
		Coordinator c1=new Coordinator(5);
		assertEquals(c,c1);
	}
	
	@Test
	public void testToString() {
		Coordinator c=new Coordinator(5);
		assertEquals(" " + 5.0,c.toString());
	}
}
