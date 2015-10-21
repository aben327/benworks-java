package benworks.java.lang.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Canvas {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		List<Shape> shapes = new ArrayList<Shape>();
		List<Circle> circles = new ArrayList<Circle>();
		List<Rectangle> rectangles = new ArrayList<Rectangle>();

		Shape shape1 = new Circle();
		Shape shape2 = new Rectangle();

		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();

		canvas.drawAll1(shapes);
		// canvas.drawAll1(shapes2); // compile-time error!

		canvas.drawAll2(shapes);
		canvas.drawAll2(circles);

		canvas.addRectangle2(shapes, rectangles);
	}

	public void draw(Shape s) {
		s.draw(this);
	}

	/**
	 * Canvas里有一个方法来画出所有的形状会比较方便： 比如说对List<Circle>来调用。这很不幸，因为这个方法所作的只是从这个list读取shape，因此它应该也能对List<Circle>调用
	 * @param shapes
	 */
	public void drawAll1(List<Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
	}

	/**
	 * 我们把类型 List<Shape> 替换成了 List<? extends Shape>。现在drawAll()可以接受任何Shape的子类的List，所以我们可以对List<Circle>进行调用。
	 * @param shapes
	 */
	public void drawAll2(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
	}

	/**
	 * 像平常一样，要得到使用通配符的灵活性有些代价。这个代价是，现在像shapes中写入是非法的。比如下面的代码是不允许的： 因为shapes.add的第二个参数类型是? extends Shape
	 * 一个Shape未知的子类。因此我们不知道这个类型是什么，我们不知道它是不是Rectangle的父类；它可能是也可能不是一个父类，所以这里传递一个Rectangle不安全。
	 * @param shapes
	 */
	public void addRectangle1(List<? extends Shape> shapes1) {
		// shapes1.add(0, new Rectangle()); // compile-time error!
		// shapes1.add(0, new Circle()); // compile-time error!
	}

	/**
	 * @param shapes2
	 * @param shapes3
	 */
	public void addRectangle2(List<Shape> shapes2, List<Rectangle> shapes3) {
		shapes2.add(0, new Rectangle()); // is ok
		shapes2.add(0, new Circle()); // is ok

		shapes3.add(0, new Rectangle()); // is ok
	}

}
