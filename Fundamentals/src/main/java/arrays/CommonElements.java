package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElements {
	public static ArrayList<Integer> findWithForLoops(final Integer[] a,
			final Integer[] b) {
		final ArrayList<Integer> matches = new ArrayList<>();

		for (final Integer element : a) {
			for (final Integer element2 : b) {
				if (element == element2) {
					matches.add(element);
				}
			}
		}
		return matches;
	}

	public static ArrayList<Integer> findWithHashSet(final Integer[] a,
			final Integer[] b) {
		final ArrayList<Integer> matches = new ArrayList<>();

		final Set<?> hashSet = new HashSet<>(Arrays.asList(a));
		for (final Integer element : b) {
			if (hashSet.contains(element)) {
				matches.add(element);
			}
		}

		return matches;
	}

	public static ArrayList<Integer> findWithSortedArray(final Integer[] a,
			final Integer[] b) {
		final ArrayList<Integer> matches = new ArrayList<>();

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				matches.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return matches;
	}

	public static ArrayList<Integer> findWithStreams(final Integer[] a,
			final Integer[] b) {
		ArrayList<Integer> matches = new ArrayList<>();

		matches = (ArrayList<Integer>) Arrays.asList(a).stream()
				.filter(Arrays.asList(b)::contains)
				.collect(Collectors.toList());

		return matches;
	}
}
