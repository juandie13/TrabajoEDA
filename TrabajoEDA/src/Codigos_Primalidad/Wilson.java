package Codigos_Primalidad;
import java.math.BigInteger;

public class Wilson
{
    public static BigInteger fact(BigInteger p)
    {
        if (p.equals(BigInteger.ZERO))
        {
            return BigInteger.ONE;
        }   
        else
        {
            return p.multiply(fact(p.subtract(BigInteger.ONE)));
        }
    }
    public static boolean isPrime(BigInteger p)
    {
        //(fact(p-1)+1)%p==0
        if(((fact(p.subtract(BigInteger.ONE))).add(BigInteger.valueOf(1))).mod(p)==BigInteger.ZERO)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
 
    public static void main(String[] args) 
    {
        //12853
        long start = System.nanoTime();
        System.out.println(isPrime(new BigInteger("131071")));
        float time = System.nanoTime() - start;
        System.out.println("Time: " + (long) time + " nanoseconds");
    }
}