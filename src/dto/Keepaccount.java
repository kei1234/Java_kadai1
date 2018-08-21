package dto;

public class Keepaccount {


	private String income;
	private String spending;


	public Keepaccount(){

	}

	public Keepaccount(String income, String spending) {


		this.income = income;
		this.spending = spending;

	}


	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getSpending() {
		return spending;
	}
	public void setSpending(String spending) {
		this.spending = spending;
	}

	}



