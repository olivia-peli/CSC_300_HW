package pack;

public class Driver {

	public static void main(String[] args) {
		int years = yearsToConvertAllToDisciples(13, 2.0 / 3.0, 7.7e9);
		//13 Disciples, 2.0 / 3.0 2 in 3 years, 7.7e9 population
		System.out.println("It will take approximately " + years + " years to convert all humans to be disciples of Christ.");
		
		int disciplesToTrain = disciplesToTrainInYears(13, 7.7e9, 50);
		//13 disciples, 7.7e9 population, 50 how many years to fulfill the need
		System.out.println("To train the entire population in 50 years it would take " + disciplesToTrain + " people to be trained at the same time");
		
	}

	public static int yearsToConvertAllToDisciples(int initialDisciples, double disciplesPerCycle, double totalPopulation) {
	    int years = 0;
	    double currentDisciples = initialDisciples;

	    while (currentDisciples < totalPopulation) {//loop keeps running until Disciples fill entire population
	        currentDisciples += currentDisciples * disciplesPerCycle;
	        years++;
	    }

	    return years;
	}
	
	public static int disciplesToTrainInYears(int initialDisciples, double totalPopulation, int targetYears) {
	    double disciplesPerCycle = Math.pow(totalPopulation / initialDisciples, 1.0 / targetYears) - 1;
	    //raises total population to the power of initial disciples to the power of 1/target years
	    return (int) Math.ceil(1 / disciplesPerCycle);
	    //rounds 1/disciples per cycle up
}
}
