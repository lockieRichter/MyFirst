package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonElementsTest {
	Integer[] a = { 1, 2, 3, 4, 5 };
	Integer[] b = { 1, 2, 4, 5, 6, 7, 8 };

	List<?> matches = Arrays.asList(1, 2, 4, 5);

	@Test
	public void test_findWithForLoop() {
		final List<?> result = CommonElements.findWithForLoops(a, b);
		Assertions.assertEquals(matches, result);
	}

	@Test
	public void test_findWithHashSet() {
		final List<?> result = CommonElements.findWithHashSet(a, b);
		Assertions.assertEquals(matches, result);
	}

	@Test
	public void test_findWithSortedArray() {
		final List<?> result = CommonElements.findWithSortedArray(a, b);
		Assertions.assertEquals(matches, result);
	}

	@Test
	public void test_findWithStreams() {
		final List<?> result = CommonElements.findWithStreams(a, b);
		Assertions.assertEquals(matches, result);
	}

	@Test
	public void test_Times() {

		final Random rd = new Random(System.currentTimeMillis()); // creating
																	// Random
																	// object
		final Integer[] randA = new Integer[5000];
		final Integer[] randB = new Integer[5000];
		for (int i = 0; i < randA.length; i++) {
			randA[i] = rd.nextInt();
			randB[i] = rd.nextInt();
		}

		final List<Long> loopTimes = new ArrayList<>();
		final List<Long> setTimes = new ArrayList<>();
		final List<Long> streamTimes = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			final long startTime = System.nanoTime();
			CommonElements.findWithForLoops(randA, randB);
			final long stopTime = System.nanoTime();
			loopTimes.add(stopTime - startTime);
		}
		loopTimes.stream() //
				.mapToLong(i -> i) //
				.average() //
				.ifPresent(avg -> System.out
						.println("For loop average is " + avg / 1e+6));

		for (int i = 0; i < 100; i++) {
			final long startTime = System.nanoTime();
			CommonElements.findWithHashSet(randA, randB);
			final long stopTime = System.nanoTime();
			setTimes.add(stopTime - startTime);
		}
		setTimes.stream() //
				.mapToLong(i -> i) //
				.average() //
				.ifPresent(avg -> System.out
						.println("Set average is " + avg / 1e+6));

		for (int i = 0; i < 100; i++) {
			final long startTime = System.nanoTime();
			CommonElements.findWithStreams(randA, randB);
			final long stopTime = System.nanoTime();
			streamTimes.add(stopTime - startTime);
		}
		streamTimes.stream() //
				.mapToLong(i -> i) //
				.average() //
				.ifPresent(avg -> System.out
						.println("Stream average is " + avg / 1e+6));

		for (int i = 0; i < 100; i++) {
			final long startTime = System.nanoTime();
			CommonElements.findWithSortedArray(randA, randB);
			final long stopTime = System.nanoTime();
			streamTimes.add(stopTime - startTime);
		}
		streamTimes.stream() //
				.mapToLong(i -> i) //
				.average() //
				.ifPresent(avg -> System.out
						.println("Sorted array average is " + avg / 1e+6));
	}
}
