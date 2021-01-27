package springcore_example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)	
public class AreaCalculatorTest {
	
	@Autowired
    private AreaCalculator areaCalculator;
	
	@Test
	public void testSquareNegativeSide() {
		assertEquals(-1,areaCalculator.square(-5),0);
	}
	
	@Test
	public void testSquareArea() {
		assertEquals(25,areaCalculator.square(5),0);
	}
	
	@Test
	public void testRectangleLengthNegative() {
		assertEquals(-1,areaCalculator.rectangle(-20,30),0);
	}
	
	@Test
	public void testRectangleWidthNegative() {
		assertEquals(-1,areaCalculator.rectangle(14,-29),0);
	}
	
	@Test
	public void testRectangleLengthGT() {
		assertEquals(-2,areaCalculator.rectangle(50000,30),0);
	}
	
	@Test
	public void testRectangleWidthGT() {
		assertEquals(-2,areaCalculator.rectangle(32,12000),0);
	}
	
	@Test
	public void testRectangleArea() {
		assertEquals(68,areaCalculator.rectangle(17,4),0);
	}
	
	@Test
	public void testShapeNameNotExists() {
		String name = areaCalculator.getShapeName();
		assertNull("Name cannot be null",name);
	}
	
	@Test
	public void testShapeNameExists() {
		areaCalculator.setShapeName("Squiggly");
		String name = areaCalculator.getShapeName();
		assertNotNull("Name cannot be null",name);
	}
	
	@Test
	public void testTriangleBaseNegative() {
		assertEquals(-1,areaCalculator.triangle(-5,8,"cms"),0);		
	}
	
	@Test
	public void testTriangleHeightNegative() {
		assertEquals(-1,areaCalculator.triangle(14,-16,"cms"),0);		
	}
	
	@Test
	public void testTriangleIncorrectUnit() {
		assertEquals(-2,areaCalculator.triangle(14,16,"pixels"),0);		
	}
	
	@Test
	public void testTriangleArea() {
		assertEquals(224.0,areaCalculator.triangle(32,14,"cms"),0);		
	}
	
	@Test
	public void testCircleNegativeRadius() {
		Map<Float,String> hm = areaCalculator.circle(-14, 12, 13, 135);
		Float key=0f;
		String value="";
		for ( Float k : hm.keySet() ) {
		    key=k;
		    value=hm.get(k);
		}
				
		assertEquals(-1.0f,key,0);
		assertEquals("",value);
	}
	
	@Test
	public void testCircleDrawable() {
		areaCalculator.circle(-14, 12, 13, 135);				
		//assertFalse(areaCalculator.isDrawable());
		assertTrue(areaCalculator.isDrawable());
	}
	
	@Test
	public void testCircleArea() {
		Map<Float,String> hm = areaCalculator.circle(15, 248,196,113);
		Float key=0f;
		String value="";
		for ( Float k : hm.keySet() ) {
		    key=k;
		    value=hm.get(k);
		}
				
		assertEquals(706.5f,key,1);
		assertEquals("#f8c471",value);
	}
	
	@Test
	public void testRoundShapeCircle() {
		assertEquals("Circle", areaCalculator.getRoundShape(14, 14));
	}
	
	@Test
	public void testRoundShapeVerticalOval() {
		assertEquals("Vertical Oval", areaCalculator.getRoundShape(20, 9));
	}
	
	@Test
	public void testRoundShapeHorizontalOval() {
		assertEquals("Horizontal Oval", areaCalculator.getRoundShape(14,32));
	}

}
