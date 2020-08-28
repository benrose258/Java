package chemistry;

public class KaKbKw {

	private static double Kw = 1 * Math.pow(10, -14);

	public static double getKb(double Ka, int power) {
		Ka = Ka * Math.pow(10, power);
		double Kb = Kw / Ka;
		int KbPow = -(15 + power);
		System.out.println("Kb: "+Kb*Math.pow(10, -KbPow)+" * 10^"+KbPow);
		return Kb;
	}

	public static double getKa(double Kb, int power) {
		Kb = Kb * Math.pow(10, power);
		double Ka = Kw / Kb;
		int KaPow = -(15 + power);
		System.out.println("Ka: "+Ka*Math.pow(10, -KaPow)+" * 10^"+KaPow);
		return Ka;
	}

	public static double pH(double Ka, int power) {
		return pH(Ka*Math.pow(10, power));
	}

	public static double pH(double Ka) {
		double pH = -Math.log10(Ka);
		System.out.println(pH);
		return pH;
	}

	public static void main(String[] args) {
		getKb(1.8,-4);
		pH(3.3,-9);
	}
}
