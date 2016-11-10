package simon_headley_assignment;

import java.util.ArrayList;
import java.util.Random;

import aima.core.search.framework.GoalTest;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;

public class BinaryStringSearchFitnessFunction implements FitnessFunction<Boolean>, GoalTest  {

	private int stringLength = 8;
	
	private final BinaryStringSearchGoalTest goalTest = new BinaryStringSearchGoalTest();

	public BinaryStringSearchFitnessFunction(int stringLength) {
		this.stringLength = stringLength;
	}

	public Individual<Boolean> generateRandomIndividual() {
		ArrayList<Boolean> arrayListGenotype = new ArrayList<Boolean>();
				
		for (int i = 0; i < stringLength; i++) {
			int bit = new Random().nextInt(2);
			if (bit == 0){
				arrayListGenotype.add(false);
			}else{
				arrayListGenotype.add(true);
			}
		}
		return new Individual<Boolean>(arrayListGenotype);
	}

	@Override
	public boolean isGoalState(Object state) {
		return goalTest.isGoalState(state);
	}

	@Override
	public double getValue(Individual<Boolean> individual) {
		int fitnessValue = 0;

		for (int i = 0; i < individual.getRepresentation().size(); i++) {
			if (i % 2 == 0 && individual.getRepresentation().get(i))
				fitnessValue++;
			else if (i % 2 != 0 && !individual.getRepresentation().get(i))
				fitnessValue++;
		}
		
		return fitnessValue;
	}
	
	public String getIndividualRepresentation(Individual<Boolean> bestIndividual){
		String temp = "[";
		
		for (int i = 0; i < bestIndividual.getRepresentation().size() - 1; i++){
			if (bestIndividual.getRepresentation().get(i))
				temp += "1, ";
			else
				temp += "0, ";
		}
		
		if (bestIndividual.getRepresentation().get(bestIndividual.getRepresentation().size() - 1))
			temp += "1]";
		else
			temp += "0]";
		
		return temp;
	}
}
