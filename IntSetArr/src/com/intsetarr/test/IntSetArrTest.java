package com.intsetarr.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.intsetarr.IntSetArr;

class IntSetArrTest {

	@Test
	void test() {
		int maxval = (int) Math.pow(10, 8);
		int m = maxval/100;
		long oldtime, oldtimeTotal;
		int[] v = new int[m];
		
		int testMax = 0, testMin = maxval, randnum;
		
		Random rand = new Random();
		
		System.out.println("Maxval: "+maxval+"  |  Maxelem: "+m+"\n");
		
		oldtimeTotal = System.currentTimeMillis();
		oldtime = System.currentTimeMillis();
		IntSetArr S = new IntSetArr(m, maxval);
		System.out.println("Initailize time: "+(System.currentTimeMillis() - oldtime)+" ms");
		
		oldtime = System.currentTimeMillis();
		while (S.size() < m) {
			randnum = rand.nextInt(maxval);
			S.insert(randnum);
			if (testMax < randnum)
				testMax = randnum;
			if (testMin > randnum)
				testMin = randnum;
		}
		System.out.println("Insert time: "+(System.currentTimeMillis() - oldtime)+" ms");
		
		oldtime = System.currentTimeMillis();
		S.report(v);
		System.out.println("Report time: "+(System.currentTimeMillis() - oldtime)+" ms");
		
		assertEquals(testMax, v[m - 1], "testMax");
		assertEquals(testMin, v[0], "testMin");
		
		System.out.println("Total time: "+(System.currentTimeMillis() - oldtimeTotal)+" ms");
		System.out.println("space: "+S.size() * 4+" bytes");
	}

}
