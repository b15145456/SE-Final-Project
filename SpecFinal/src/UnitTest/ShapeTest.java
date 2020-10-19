package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Shapes.Oval;
import Shapes.Shape;

class ShapeTest {

	@Test
	void test() {
		Point p = new Point();
		Shape s = new Shape(p);
		// 初始點為(0, 0)時， s 的點 分別為 (0, 0) , (100, 0) , (0, 150) , (100, 150)
		
		assertEquals(true , s.isInShape(new Point(50, 50)));
		assertEquals(true , s.isInShape(new Point(0, 0)));
		assertEquals(true , s.isInShape(new Point(100, 0)));
		assertEquals(true , s.isInShape(new Point(0, 150)));
		assertEquals(true , s.isInShape(new Point(100, 150)));
		assertEquals(false , s.isInShape(new Point(100, 151)));
		
		assertEquals(new Point(50, 0) , s.nearestconnect(new Point(0, 0)));
		assertEquals(new Point(50, 150) , s.nearestconnect(new Point(100, 150)));
		assertEquals(new Point(100, 75) , s.nearestconnect(new Point(50, 75)));
		assertEquals(new Point(0, 75) , s.nearestconnect(new Point(25, 75)));
		assertEquals(new Point(50, 150) , s.nearestconnect(new Point(200, 300)));		// 在圖形外的
		Shape o = new Oval(p);
		// 初始點為(0, 0)時， s 的點 分別為 (0, 0) , (150, 0) , (0, 100) , (150, 100)
		
		assertEquals(true , o.isInShape(new Point(75, 0)));
		assertEquals(true , o.isInShape(new Point(150, 50)));
		assertEquals(true , o.isInShape(new Point(0, 50)));
		assertEquals(true , o.isInShape(new Point(75, 100)));
		assertEquals(true , o.isInShape(new Point(100, 10)));
		assertEquals(false , o.isInShape(new Point(150, 100)));
		
		assertEquals(new Point(0, 50) , o.nearestconnect(new Point(0, 0)));
		assertEquals(new Point(150, 50) , o.nearestconnect(new Point(150, 100)));
		assertEquals(new Point(75, 100) , o.nearestconnect(new Point(75, 50)));
		assertEquals(new Point(75, 0) , o.nearestconnect(new Point(75, 25)));
		assertEquals(new Point(75, 100) , o.nearestconnect(new Point(200, 300)));		// 在圖形外的
	}

}
