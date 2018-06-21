package com.DevSet5.test;
	
	import static org.junit.Assert.*;
	
	import java.util.Random;
	
	import org.junit.Test;
	import com.DevSet2.structure.IntSetBitVec;
	
	public class SetBitVecTest {
	
		@Test
		public void setBitVecTest {
			int max_value, max_elements;
			long start, end, during_time;
			
			int mb = 1024 * 1024;
			
			Runtime run = Runtime.getRuntime();
			
			//Time elapsed
			//Initialize
			max_value = 1000000;
			max_elements = max_value / 100;
			
			during_time = System.currentTimeMillis();
			start = System.currentTimeMillis();
			
			
		IntSetBitVec x = new IntSetBitVec(max_value, max_elements);
			
			end = System.currentTimeMillis();
			System.out.println("Initialize : " + (end - start)/1000.0 + "sec");
			
			//Insert
			start = System.currentTimeMillis();
			
			Random random = new Random();
			while(x.size() < max_elements) {
				x.insert(random.nextInt(max_value));
			}
			
			end = System.currentTimeMillis();
			System.out.println("Insert : " + (end - start)/1000.0 + "sec");
			
			//Insert
			start = System.currentTimeMillis();
			
			int [] v = new int[max_elements];
			x.report(v);
			
			end = System.currentTimeMillis();
			System.out.println("Report : " + (end - start)/1000.0 + "sec");
			
			//Total
			System.out.println("Total : " + (end - during_time)/1000.0 + "sec");
			
			//Space
			System.out.println("Used Memory : " + (run.totalMemory() - run.freeMemory()) / mb);
		}
	
	}

