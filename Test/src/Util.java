/* ����� Util
����������� ����������� ����� double getDistance(x1, y1, x2, y2). �� ������ ��������� ���������� ����� �������.
��������� ����� double Math.sqrt(double a), ������� ��������� ���������� ������ ����������� ���������
*/

public class Util
{
    public static double getDistance(int x1, int y1, int x2, int y2)
    {
    	//Double distance = Math.sqrt((x1 - x2)*2 + (y1 - y2)*2);
    	return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    	//return distance;
    }
}