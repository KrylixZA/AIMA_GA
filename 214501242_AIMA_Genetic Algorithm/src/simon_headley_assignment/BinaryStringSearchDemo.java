package simon_headley_assignment;

import java.util.HashSet;
import java.util.Set;

import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.Individual;

public class BinaryStringSearchDemo {

	private static int[] stringLengths = { 8, 16, 32, 64 };
	private static int popSize = 100;

	public static void main(String[] args) {
		binaryStringGeneticAlgorithmSearch();
	}

	public static void binaryStringGeneticAlgorithmSearch() {
		for (int index = 0; index < stringLengths.length; index++) {
			System.out.println("\nBinary String Genetic Algorithm of string length " + stringLengths[index] + " -->");
			try {
				BinaryStringSearchFitnessFunction fitnessFunction = new BinaryStringSearchFitnessFunction(stringLengths[index]);
				Set<Individual<Boolean>> population = new HashSet<Individual<Boolean>>();
				for (int j = 0; j < popSize; j++) {
					population.add(fitnessFunction.generateRandomIndividual());
				}

				Set<Boolean> finiteAlphabet = new HashSet<Boolean>();
				finiteAlphabet.add(true);
				finiteAlphabet.add(false);
				GeneticAlgorithm<Boolean> ga = new GeneticAlgorithm<Boolean>(stringLengths[index], finiteAlphabet,
						0.15);

				//Run for a set amount of time
				Individual<Boolean> bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, fitnessFunction,
						1000L);

				System.out.println("Max Time (1 second) Best Individual=\n"
						+ fitnessFunction.getIndividualRepresentation(bestIndividual));
				System.out.println("Fitness(Hamming)= " + fitnessFunction.getValue(bestIndividual));
				System.out.println("Is Goal         = " + fitnessFunction.isGoalState(bestIndividual));
				System.out.println("Population Size = " + ga.getPopulationSize());
				System.out.println("Itertions       = " + ga.getIterations());
				System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");

				// Run until goal is achieved
//				bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, fitnessFunction, 0L);
//
//				System.out.println();
//				System.out.println("Goal Test Best Individual=\n"
//						+ fitnessFunction.getIndividualRepresentation(bestIndividual));
//				System.out.println("Fitness(Hamming)= " + fitnessFunction.getValue(bestIndividual));
//				System.out.println("Is Goal         = " + fitnessFunction.isGoalState(bestIndividual));
//				System.out.println("Population Size = " + ga.getPopulationSize());
//				System.out.println("Itertions       = " + ga.getIterations());
//				System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
