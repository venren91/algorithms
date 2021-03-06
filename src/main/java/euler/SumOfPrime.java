package euler;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class SumOfPrime {
    private LongStream primeStreamTillRange(int limit){
        return LongStream.range(2,limit).filter(x -> isPrime(x));
    }

    private boolean isPrime(long inp) {
        if(inp == 2 || inp == 3) return true;
        OptionalLong isDivisible = LongStream.range(2,Math.round(Math.sqrt(inp))+1).filter(x -> inp%x == 0).findFirst();
        return !isDivisible.isPresent();
    }

    public long SumOfPrimeUsingSieveOfEratosthenes(int limit){
        Boolean[] primes = new Boolean[limit+1];
        Arrays.fill(primes,true);
        AtomicLong index = new AtomicLong(-1);
        Arrays.fill(primes,0,2,false);
        for(int i=2; i<=Math.round(Math.sqrt(limit)); i++){
            if(primes[i] == true){
                for(int j=i*i; j<=limit; j += i ){
                    primes[j] = false;
                }
            }
        }

        return Arrays.stream(primes).mapToLong(i -> index.incrementAndGet()).filter(x -> primes[(int)x]).sum();
    }

    public Long sumOfPrimeTillRange(int limit){
        return primeStreamTillRange(limit).sum();
    }

    public static void main(String[] args) {
        SumOfPrime inst = new SumOfPrime();
        Instant start = Instant.now();
        long result = inst.sumOfPrimeTillRange(2000000);
        System.out.println("Time taken for till range method : " + Duration.between(start,Instant.now()).toMillis());
        System.out.println(result);
        Instant soEStart = Instant.now();
        System.out.println(inst.SumOfPrimeUsingSieveOfEratosthenes(2000000));
        System.out.println("Time taken for till range method : " + Duration.between(soEStart,Instant.now()).toMillis());
    }
}
