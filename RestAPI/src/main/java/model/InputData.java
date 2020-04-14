package model;

public class InputData {
	public double[] getData() {
		return data;
	}

	public void setData(double[] data) {
		if (data.length < 3) {
			throw new IllegalArgumentException(
					"Numeric array must be 3 elements or longer.");
		}
		this.data = data;
	}

	double[] data;
}
