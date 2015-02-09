import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* ����� ConsoleReader
������� ����� ConsoleReader, � �������� ����� 4 ����������� ������:
String readString() � ������ � ���������� ������
int readInt() � ������ � ���������� �����
double readDouble() � ������ � ���������� ������� �����
void readLn() � ���� ������� enter [������������ readString()]
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static int readInt() throws Exception
    {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static double readDouble() throws Exception
    {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }

    public static void readLn() throws Exception
    {
    	Boolean isExit = false;
    	while(!isExit)
    	{
    		//String curStr = readString();
    		//System.out.println("."+curStr+".");
    		if (!readString().equals("\\n"))
    			isExit = true;
    		//System.out.println("Exited");
    	}	
    }
}

