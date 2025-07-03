public class Algo_1_Find_Min_number {
    public static void main(String[] args){
        int[] number = {20, 4, 5, 6, 7,10};
        int min = number[0];

        for(int i=0; i<number.length; i++){
            if(number[i] < min){
                min = number[i];
            }
        }

        System.out.println("Lowest number in the array is: " + min);
    }   
}


/* 

1. Initialize an array "number" with some values.
2. Initialize a variable "min" to the first value of "number"
3. Iterate through "number" using a for loop.
    3.1 Check if the current value is less than "min".
    3.2 If true, then assign the current value to "min". Else move forward.
4. Print the lowest value.

*/

/* 
 
INITIALIZE array number with values
SET min = number[0]
FOR each index i from 1 to number.length - 1
    IF number[i] < min THEN
        SET min = number[i]
    END IF
END FOR
PRINT min

 */
