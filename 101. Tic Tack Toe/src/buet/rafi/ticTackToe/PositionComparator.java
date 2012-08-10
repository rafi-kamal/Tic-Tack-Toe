package buet.rafi.ticTackToe;
import java.util.Comparator;

public class PositionComparator implements Comparator<PositionPriority>
{
	public int compare(PositionPriority a, PositionPriority b)
	{
		return b.priority - a.priority;
	}
}
