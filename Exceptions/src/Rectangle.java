public class Rectangle {

	private final double height;
	private final double width;

	public Rectangle(double height, double width) throws LogicException {
		if (height < 0 || width < 0) {
			throw new LogicException("Values must be >0 \n");
		}
		this.height = height;
		this.width = width;
	}

	public static void main(String[] args) {

	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}
}
