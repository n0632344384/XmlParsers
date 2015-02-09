/* Геттеры и сеттеры для класса Dog
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
*/
/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
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

