package simon_headley_assignment;

import java.util.ArrayList;

import aima.core.search.framework.GoalTest;
import aima.core.search.local.Individual;

public class BinaryStringSearchGoalTest implements GoalTest {

	@SuppressWarnings("unchecked")
	@Override
	public boolean isGoalState(Object state) {
		Individual<Boolean> genotype = (Individual<Boolean>) state;
		Individual<Boolean> goalStateTemplate = getGoalStateTemplate(genotype.getRepresentation().size());
		
		for (int i = 0; i < genotype.getRepresentation().size(); i++){
			if (genotype.getRepresentation().get(i) != goalStateTemplate.getRepresentation().get(i))
				return false;
			
		}
		

		return true;
	}

	private Individual<Boolean> getGoalStateTemplate(int size) {
		ArrayList<Boolean> arrayListGenotype = new ArrayList<Boolean>();

		for (int i = 0; i < size; i++) {
			if (i % 2 == 0)
				arrayListGenotype.add(true);
			else
				arrayListGenotype.add(false);

		}

		return new Individual<Boolean>(arrayListGenotype);
	}

}
