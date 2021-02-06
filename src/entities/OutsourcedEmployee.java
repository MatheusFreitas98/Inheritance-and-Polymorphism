package entities;

public class OutsourcedEmployee extends Employee{
	
	private Double additional;
	
	public OutsourcedEmployee() {
		super();
	}

	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additional) {
		super(name, hours, valuePerHour);
		this.additional = additional;
	}

	public Double getAdditional() {
		return additional;
	}

	public void setAdditional(Double additional) {
		this.additional = additional;
	}
	
	@Override
	public Double payment() {
		Double paymentValue = valuePerHour * hours + (additional * 1.10);
		return paymentValue;
	}
	
}
