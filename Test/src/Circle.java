/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/
public class Circle {
	public int centerX;
	public int centerY;
	public int radius;
	public int width;
	public String color;
	
	public Circle(int x, int y, int r) {
		this.centerX = x;
		this.centerY = y;
		this.radius = r;
	}
	public Circle(int x, int y, int r, int w) {
		this.centerX = x;
		this.centerY = y;
		this.radius = r;
		this.width = w;
	}
	public Circle(int x, int y, int r, int w, String c) {
		this.centerX = x;
		this.centerY = y;
		this.radius = r;
		this.width = w;
		this.color = c;
	}
}
