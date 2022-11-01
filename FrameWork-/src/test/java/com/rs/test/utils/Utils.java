package com.rs.test.utils;

import java.util.List
;
import java.util.Random;

public class Utils {

	public static <T> T getRandomItem(List<T> list) {
		Random random = new Random(System.currentTimeMillis());
		return list.get(random.nextInt(list.size()));
	}

}
