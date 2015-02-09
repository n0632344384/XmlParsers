/* ������� ����� ������������� (Rectangle)
������� ����� ������������� (Rectangle). ��� ������� ����� top, left, width, height (����� ����������, �������, ������ � ������). ������� ��� ���� ��� ����� ������ �������������:
�������:
-	������ 4 ���������: left, top, width, height
-	������/������ �� ������ (��� ����� 0)
-	������ �� ������ (����� ������) ������ �������
-	������ ����� ������� �������������� (�� � ��������� � ����������)
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
