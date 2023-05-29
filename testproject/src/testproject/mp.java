package testproject;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class mp extends Throwable implements Runnable{

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(mp.class);

		log.info("wda");
		List<String> st = new ArrayList<String>();
		st.add("apple");
		st.add("orange");
		st.add("banana");
		st.add("peace");
		List<String> st1;
		try {
			st1 = filtraFrutti(st);
			st1.forEach(f -> System.out.println(f));
			Thread t1 = new Thread();
			t1.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<String> filtraFrutti(List<String> list) throws Exception{
		return list.stream().filter(f -> f.contains("e")).collect(Collectors.toList());
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
}
