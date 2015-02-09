/*  ласс StringHelper
Cделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) Ц возвращает строку повторенную count раз.
String multiply(String s) Ц возвращает строку повторенную 5 раз.
ѕример:
јмиго -> јмигојмигојмигојмигојмиго
*/

public class StringHelper
{
    public static String multiply(String s)
    {
        String result = "";
        for (int i=0; i < 5; i++)
        	result = result + s;
        return result;
    }

    public static String multiply(String s, int count)
    {
        String result = "";
        for (int i=0; i < count; i++)
        	result = result + s;
        return result;
    }
}

