package bugword;

import java.util.Comparator;

public class CompareAll {
	public class PlantSizeComparator implements Comparator<Plant>{
		@Override
        public int compare(Plant p1, Plant p2) {
            return Integer.compare(p1.getSize(), p2.getSize());
        }
	}
	public static class BugEnergy implements Comparator<Bug> {
        @Override
        public int compare(Bug b1, Bug b2) {
            return Integer.compare(b1.getEnergy(), b2.getEnergy());
        }
    }
	public static class BugSpeciesName implements Comparator<Bug> {
        @Override
        public int compare(Bug b1, Bug b2) {
            int speciesCompare = b1.getSpecies().compareTo(b2.getSpecies());
            if (speciesCompare != 0) {
                return speciesCompare;
            }
            return b1.getName().compareTo(b2.getName());
        }
	}
}
