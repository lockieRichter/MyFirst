package model;

public class OutputData {
	double output;

	public OutputData(double output) {

		long factor = (long) Math.pow(10, 2);
		output = output * factor;
		long tmp = Math.round(output);
		this.output = (double) tmp / factor;
	}

	public double getOutput() {
		return output;
	}
}