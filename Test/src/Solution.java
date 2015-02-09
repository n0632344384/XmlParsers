import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* ����� �������� � ��������� ����� ����������������
������: � ������ ����� ���� ��� � �����-����. ������� �����, ������� �� �������� ������ ��������. ������� ��� �������: �����-���� � �����-����. ������� �� �� �����.
����� ������: � ������ ����� ���� ���, �����-���� � �����-����. �������� ����� Cat ���, ����� �� ��� ������� ������ ��������.
������� 6 ��������: ����, ����, ����, ����, �������(������ ����) � �������(����� ����).
������� �� ���� �� ����� � �������: �������, �������, ����, ����, ���, ����.

������ �����:
������� ����
������� �����
���� �������
���� ��������
��� ������
���� �������

������� ����
������� �����
���� �������
���� ��������
���� �������

������ ������:
Cat name is ������� ����, no mother, no father
Cat name is ������� �����, no mother, no father
Cat name is ���� �������, no mother, father is ������� ����
Cat name is ���� ��������, mother is ������� �����, no father
Cat name is ��� ������, mother is ���� ��������, father is ���� �������
Cat name is ���� �������, mother is ���� ��������, father is ���� �������
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName);
        
        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);
        
        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandFather);
        
        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);
        
        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parent;
        private Cat parent2;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parent)
        {
            this.name = name;
            this.parent = parent;
        }
        
        Cat(String name, Cat parent, Cat parent2)
        {
            this.name = name;
            this.parent = parent;
            this.parent2 = parent2;
        }

        @Override
        public String toString()
        {
            if (parent == null && parent2 == null)
                return "Cat name is " + name + ", no mother, no father ";
            else if (parent != null && parent2 == null)
                return "Cat name is " + name + ", mother is " + parent.name + ", no father";
            else if (parent == null && parent2 != null)
            	return "Cat name is " + name + ", no mother, father is " + parent2.name;
            else
            	return "Cat name is " + name + ", mother is " + parent.name + ", father is " + parent2.name;
        }
    }

}
