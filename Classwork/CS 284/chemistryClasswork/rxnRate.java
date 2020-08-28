package chemistry;

public class rxnRate {

	private int time1;
	private double concentration1;
	private int time2;
	private double concentration2;

	rxnRate(int time1, double concentration1, int time2, double concentration2) {
		this.time1 = time1;
		this.concentration1 = concentration1;
		this.time2 = time2;
		this.concentration2=concentration2;
	}

	public int getTime1() {
		return time1;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public double getConcentration1() {
		return concentration1;
	}

	public void setConcentration1(double concentration1) {
		this.concentration1 = concentration1;
	}

	public int getTime2() {
		return time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}

	public double getConcentration2() {
		return concentration2;
	}

	public void setConcentration2(double concentration2) {
		this.concentration2 = concentration2;
	}

	public double avgRate() {
		return -(concentration2-concentration1)/(time2-time1);
	}

	public double rateFormation() {
		return -avgRate();
	}

	public static void main(String[] args) {
		rxnRate rxn1 = new rxnRate(0,1,10,0.913);
		rxnRate rxn2 = new rxnRate(40,0.697,50,0.637);
		rxnRate rxn3 = new rxnRate(20,0.835,30,0.763);
		rxnRate rxn4 = new rxnRate(0,0.184,1500,0.016);
		rxnRate rxn5 = new rxnRate(200,0.129,1200,0.019);
		rxnRate rxn6 = new rxnRate(5,1.43,15,1.79);
		System.out.println(rxn6.rateFormation());
	}

}
