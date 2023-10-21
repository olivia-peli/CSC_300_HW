package pack;

public class Driver {

	public static void main(String[] args) {
		double population = 7.7e9;
		double trueDisciples = 13;
		double trainingRate = 2;
		double trainingAge = 18;
		
		double years = 0;
		
		while(trueDisciples < population) {
			years = years + 3; //adds 3 years to the current years
			
			// allows the trueDeisciples to train new ones
			double newDisciples = trueDisciples * trainingRate;
			
			// number of new trained disciples
			double disciplesByNewDisciples = 0;
			if(years >= trainingAge) {
				disciplesByNewDisciples = (population - trueDisciples)/2;
				}
			
			trueDisciples += newDisciples + disciplesByNewDisciples;
		}
		System.out.println("it takes " + years + " years");
		}

	}

