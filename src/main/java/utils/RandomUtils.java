package utils;

import java.util.Random;

public class RandomUtils {
	private static Random random = new Random();

	public static int getNumber(int bound) {
		return random.nextInt(bound);
	}
}
