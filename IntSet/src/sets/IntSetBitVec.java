package com.DevSet5.structure;

import java.util.*;

public class IntSetBitVec {
	private Vector<Boolean> bitvec;
	private int max_value, max_elements;
	private int size;
	
	public IntSetBitVec(int max_valuel, int max_elements) {
		bitvec = new Vector<Boolean>();
		this.max_value = max_value;
		this.max_elements = max_elements;
		this.size = 0;
		
		for (int i = 0; i <= max_value; i++) {
			bitvec.add(i, false); //벡터 리스트 추가
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public void insert(int element) {
		if ((size >= max_elements) | (element > max_value)) {
			return;
		}
		if(bitvec.get(element)) {
			return;
		} 
		else {
			bitvec.remove(element);
			bitvec.add(element, true);
			size++;
		}
	}
	public void report(int [] vec) {
		int j = 0;
		for(int i = 0; i <= max_value; i++) {
			if(bitvec.get(i)) {
				vec[j++] = i;
			}
		}
		
		for(int i = 0; i < vec.length; i++) {
			//System.out.println("element >> " + vec[i]);
		}
	}
	
}