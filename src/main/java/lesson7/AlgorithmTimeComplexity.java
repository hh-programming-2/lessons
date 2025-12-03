package lesson7;

// In this example we'll analyse time complexity of simple algorithms
// https://www.geeksforgeeks.org/dsa/understanding-time-complexity-simple-examples/
public class AlgorithmTimeComplexity {
    // What does this algorithm do and what is its time complexity?
    public int mysteryAlgorithmA(int[] arr) {
        int value = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > value) {
                value = arr[i];
            }
        }

        return value;
    }

    // What does this algorithm do and what is its time complexity?
    public boolean mysteryAlgorithmB(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
