import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCGTest {
    public static void main(String[] args) {
        // LCG Parameters
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 0L;

        // Part 1: Find Cycle Count
        int maxIterations = 1_000_000; // Adjust if needed


        long cycleLength = findCycle(seed, a, c, m, maxIterations);
        System.out.println("Cycle Length: " + cycleLength);

        // Part 2: Build Distribution
        int count = 1_000_00;
        int[] histogram = buildDistribution(seed, a, c, m, count, 100); // 100 bins
        System.out.println("Total iterations amount: "+ count);
        // Print the Distribution as a Graph
        System.out.println("\nDistribution Graph:");
        printHistogram(histogram);
    }

    // Part 1: Find Cycle Count
    private static long findCycle(long seed, long a, long c, long m, int maxIterations) {
        Map<Long, Integer> seen = new HashMap<>();
        long x = seed;

        for (int i = 0; i < maxIterations; i++) {
            if (seen.containsKey(x)) {
                return i - seen.get(x); // Cycle length
            }
            seen.put(x, i);
            x = (a * x + c) % m;
        }
        System.out.println("Not enough iterations, ("+maxIterations+") cycle length not found");
        return -1; // No cycle found within maxIterations
    }


    // Part 2: Build Distribution
    private static int[] buildDistribution(long seed, long a, long c, long m, int count, int bins) {
        int[] histogram = new int[bins];
        long x = seed;

        for (int i = 0; i < count; i++) {
            x = (a * x + c) % m;

            // Ensure x is always non-negative before normalization
            if (x < 0) {
                x += m;
            }

            double normalized = (double) x / m;

            // Adjust bin index calculation for better precision
            int binIndex = (int) Math.floor(normalized * bins);

            // Ensure binIndex is clamped within [0, bins - 1]
            if (binIndex >= 0 && binIndex < bins) {
                histogram[binIndex]++;
            } else {
                System.err.printf("Unexpected binIndex: %d (normalized: %.12f)%n", binIndex, normalized);
            }
        }
        return histogram;
    }
    // Print Histogram
    private static void printHistogram(int[] histogram) {
        int maxStars = 150; // Max stars for visualization
        int bins = 50;     // Total bins (steps) to display
        int maxCount = Arrays.stream(histogram).max().orElse(1);

        double step = 1.0 / bins; // Step size for 50 gradual bins
        for (int i = 0; i < bins; i++) {
            double rangeStart = i * step;
            double rangeEnd = (i + 1) * step;

            System.out.printf("%.2f - %.2f | ", rangeStart, rangeEnd);

            int stars = (int) ((double) histogram[i] / maxCount * maxStars);
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
