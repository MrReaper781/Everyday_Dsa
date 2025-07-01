import java.util.*;

public class QueueImplementation{
	public static void main(String[] args){
		Queue<Integer> q = new LinkedList<>();

		// Adding elements(enqueue) - use(offer/add)
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.add(5);

		System.out.println(q);

		// Check the top element
		System.out.println(q.peek());

		// removing element(dequeue) - use(poll)
		System.out.println(q.poll());
		System.out.println(q);

		// to check if queue contains that element or not
		System.out.println(q.contains(2));

		// to check the size of queue
		System.out.println(q.size());

		// to check if the queue is empty or not
		System.out.println(q.isEmpty());

		// to clear the queue
		q.clear();
		System.out.println(q);
		System.out.println(q.isEmpty());	
	}
}