package ownyit.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Queue {
	
	private static final int DEFAULT_MSG_POP_COUNT = 100;
	
	private List<String> queue = null;

	public Queue() {
		this.queue = Collections.synchronizedList(new LinkedList<String>());
	}

	public void push(String obj) {

		if (obj == null) {
			return;
		}
		this.queue.add(obj);
	}

	public void pushAll(List<String> query_list) {
		
		int size = (query_list != null) ? query_list.size() : 0;
		
		if (size == 0) {
			return;
		}
		this.queue.addAll(query_list);
	}

	public int size() {
		return this.queue.size();
	}

	public List<String> pop() {
		return pop(DEFAULT_MSG_POP_COUNT);
	}

	public List<String> pop(int counter) {

		List<String> query_list = new ArrayList<String>();

		synchronized(this.queue){
			
			for(int i = 0; i < counter; i++){
				
				if(this.queue.isEmpty()){
					break;
				}
				String obj = this.queue.remove(0);
				
				if (obj != null) {
						
					query_list.add(obj);
					
					obj = null;
				}
			}
		}
		return query_list;
	}

	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	public void clear() {
		this.queue.clear();		
	}
}
