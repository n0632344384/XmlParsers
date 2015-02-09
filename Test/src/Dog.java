/* ������� � ������� ��� ������ Dog
������� class Dog. � ������ ������ ���� ������ String name � ������� int age.
�������� ������� � ������� ��� ���� ���������� ������ Dog.
*/
/* ������� ����� Dog
������� ����� Dog (������) � ����� ��������������:
- ���
- ���, ����
- ���, ����, ����
*/
public class Dog {
	String name;
	int age;
	int weight;
	String color;
	
	public Dog(String n) {
		this.name = n;
	}
	public Dog(String n, int w) {
		this.name = n;
		this.weight = w;
	}
	public Dog(String n, int w, String c) {
		this.name = n;
		this.weight = w;
		this.color = c;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}
}

