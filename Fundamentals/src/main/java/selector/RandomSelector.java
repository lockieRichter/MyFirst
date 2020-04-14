package selector;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomSelector {

	public static void main(final String[] args) {

		final RandomSelector picker = new RandomSelector();
		picker.selectChoice();
	}

	Object[] choices;
	InputStream inputStream;
	int numberOfChoices;
	Random random;

	public RandomSelector() {

		inputStream = getClass().getClassLoader()
				.getResourceAsStream("selectionList.txt");

		final InputStreamReader streamReader =
				new InputStreamReader(inputStream);
		choices = new BufferedReader(streamReader).lines().toArray();

		random = new Random(System.currentTimeMillis());
		numberOfChoices = choices.length;
	}

	private void selectChoice() {
		final int index = random.nextInt(numberOfChoices);
		System.err.println("Random choice selected: " + choices[index]);
	}
}
