package com.student.model;
import java.util.ArrayList;
import java.util.List;

public class CoinChanging {
	
    /**
     * Space efficient DP solution
     */
    public int numberOfSolutionsOnSpace(int total, int arr[]){

        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= arr[i]){
                    temp[j] += temp[j-arr[i]];
                }
            }
        }
        return temp[total];
    }

    /**
     * This method actually prints all the combination. It takes exponential time.
     */
    public void printCoinChangingSolution(int total,int coins[]){
        List<Integer> result = new ArrayList<>();
        printActualSolution(result, total, coins, 0);
    }
    
    private void printActualSolution(List<Integer> result,int total,int coins[],int pos){
        if(total == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
                printActualSolution(result,total-coins[i],coins,i);
                result.remove(result.size()-1);
            }
        }
    }

    public static void main(String args[]){
        CoinChanging cc = new CoinChanging();
        int total = 5;
        int coins[] = {1,2,3};
        System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
        cc.printCoinChangingSolution(total, coins);
    }
}
