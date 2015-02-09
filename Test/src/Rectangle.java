/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/
public class Rectangle  {
	public int top;
	public int left;
	public int width;
	public int height;
	
	public Rectangle(int t, int l, int w, int h) {
		this.top = t;
		this.left = l;
		this.width = w;
		this.height = h;
	}
	public Rectangle(int t, int l) {
		this.top = t;
		this.left = l;
		this.width = 0;
		this.height = 0;
	}
	public Rectangle(int t, int l, int w) {
		this.top = t;
		this.left = l;
		this.width = w;
		this.height = w;
	}
	public Rectangle(Rectangle r) {
		this.top = r.top;
		this.left = r.left;
		this.width = r.width;
		this.height = r.height;
	}
}
