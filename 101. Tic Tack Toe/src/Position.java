// Determines next position selecting randomly

import java.util.PriorityQueue;
import java.util.Random;

public class Position 
{
	PriorityQueue<PositionPriority> positions;
	
	public void init()
	{
		positions = new PriorityQueue<PositionPriority> (10, new PositionComparator());
		Random random = new Random();
		
		positions.add(new PositionPriority(5, 10 + random.nextInt(3)));					// Position 5 has the highest priority, 10 - 12
		
		for(int i = 0; i < 5; i++)
			if(i != 2)																	// Skip position 5
				positions.add(new PositionPriority(2 * i + 1, 5 + random.nextInt(6)));	// Position 1, 3, 7, 9 have moderate priority, 5 - 10
		
		for(int i = 1; i < 5; i++)
			positions.add(new PositionPriority(2 * i, 1 + random.nextInt(5)));			// Position 2, 4, 6, 8 have lowest priority, 1 - 5
	}
	
	public int getNext()																// Return the next position with maximum priority
	{
		PositionPriority next = null;
		
		if(!positions.isEmpty())
			next = positions.poll();
		//printPosition();
		
		if(next == null)
			return 5;
		
		return next.postioin;
	}
	
	/*public void hasThreeOdd()															// If there is three filled odd positions, then the priority of the last position will be lowest
	{
		int oddPositions = 0;
		PositionPriority odd = null;
		
		while(! positions.isEmpty())
		{
			if(positions.peek().postioin % 2 == 1)										// An odd position found
			{
				oddPositions++;
				odd = positions.peek();													// Save the position
				
				if(oddPositions > 1)
					break;
			}
		}
		
		if(oddPositions == 1) 															// Only one odd position is vacant, so other three odd positions are already filled
			odd.priority = 1;															// Minimize its priority
	}*/
	
	public void printPosition()
	{
		for(PositionPriority p : positions)
			System.out.printf("%2d:%2d ", p.postioin, p.priority);
		
		System.out.println();
	}
}
