package queen;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class QueenText {
  public static void main(String[] args) {
	String[] s = new String[22];
	ArrayList list = new ArrayList();
	Queue<String> queue = new LinkedList<String>();
	list.add("lids st");
	
	queue.addAll(list);
	queue.add("dd");
	queue.offer("sxcxs");
//	queue.peek();
	queue.poll();
	queue.toArray(s);
//	queue.toArray();
	System.out.println(s[0]);
	System.out.println(queue.addAll(list));
	System.out.println(queue.peek());
}
}
