public class Friend
{
    private String name;
    private int age;
    private String sex;
    
    public Friend(String n) {
    	this.name = n;
    }

    public Friend(String n, int a) {
    	this.name = n;
    	this.age = a;
    }
    
    public Friend(String n, int a, String s) {
    	this.name = n;
    	this.age = a;
    	this.sex = s;
    }
}
