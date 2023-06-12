package Answer1;

public class BalancedArraySolution {

    public static int balancedSum(int[] arr){
        int[] forwardSum = new int[arr.length];
        int[] backwardsSum = new int[arr.length];
        int smallestVal = Integer.MAX_VALUE;
        int pivotIndex = -1;
        forwardSum[0] = arr[0];
        for (int i=1; i< arr.length; i++){
            forwardSum[i] = forwardSum[i-1] + arr[i];
        }
        backwardsSum[arr.length-1] = arr[arr.length-1];
        for (int i= arr.length-2; i>=0; i--){
            backwardsSum[i] = backwardsSum[i+1] + arr[i];
        }
        for (int i=1; i< arr.length-1; i++){
            if(forwardSum[i-1] == backwardsSum[i+1] && arr[i] < smallestVal){
                smallestVal = arr[i];
                pivotIndex = i;
            }
        }
        return pivotIndex;
    }

    public static void main(String[] args){
        int result = balancedSum(new int[]{1,2,3,4,6});
        System.out.println("Answer: " + result);
    }

}
