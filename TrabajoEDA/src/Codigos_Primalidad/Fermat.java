package Codigos_Primalidad;
import java.util.Random;
import java.math.BigInteger;
/**
 *
 * @author Duena
 */
public class Fermat {
    private final static Random rand = new Random();

private static BigInteger getRandomFermatBase(BigInteger n)
{
      while (true)
      {
           final BigInteger a = new BigInteger (n.bitLength(), rand);
           if (a.compareTo(BigInteger.ONE) == 1 && a.compareTo(n) < 0)
            {
                  return a; // 1 <= a < n
            }
      }
}

public static String isPrime(BigInteger n, int maxIterations)
{
      if (n.equals(BigInteger.ONE))
          return "is compuesto";

      for (int i = 0; i < maxIterations; i++)
      {
         BigInteger a = getRandomFermatBase(n); //generate random a
         a = a.modPow(n.subtract(BigInteger.ONE), n); //a^(p-1) mod p

            if (!a.equals(BigInteger.ONE)) // not equals 1
                  return "is compuesto";
      }
      return "is probably prime";
}

  public static void main(String[] args)
  { 
      long start = System.nanoTime();
      int x = 2;
      BigInteger a = new BigInteger("2");
      BigInteger resul = a.pow(x);
       
      BigInteger N = resul.subtract(BigInteger.ONE);
      System.out.println(N + "\n" + isPrime(N , 20));
      float time = System.nanoTime() - start;
      System.out.println("Tiempo de ejecucion de Fermat: " + (long) time + " nanosegundos");
  }
}