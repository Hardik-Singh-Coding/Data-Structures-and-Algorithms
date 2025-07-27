package Basics;
public class Fibonacci_using_recursion {
    static int count = 2;
    
    static void fibo(int n1, int n2){
        if(count <= 19){
            int n3 = n1+n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
            count ++;
            fibo(n1, n2);
        }
        else{
            return;
        }
    }
    public static void main(String[] args){
        System.out.println(0);
        System.out.println(1);
        fibo(0,1);
    }
}
