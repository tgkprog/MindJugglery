package aca2;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'calcMissing' function below.
     *
     * The function accepts STRING_ARRAY readings as parameter.
     */

    public static void calcMissing(List<String> readings) {
        // Write your code here
        final int ln = readings.size();
        long []vals = new long[ln];
        for(int i =0 ; i < ln; i++){
            vals[i] = calc(readings.get(i), i);
        }

        for(int i =0 ; i < ln; i++){
            if(vals[i] == -100){
                medianFor(i, vals, ln);
            }
        }

    }

    static long medianFor(final  int idx, final  long []vals, final int ln ){
        int from = 0;
        int till = 20;
        if(idx > 0 ){
            from = idx - 10;
            till = idx + 10;
        }
        if(from < 0){
            final int diff = 10 - idx;
            from += diff;
            till += diff;
        }
        return 1;
    }

    static long calc(String s, int i){
        if(s == null|| s.indexOf("Missing") > -1){
            return -100;
        }else{
            String[] result = s.split("\\s");
            System.err.println("For " + s + "  at " + i);
            for (int x=0; x<result.length; x++)
                System.out.println(result[x]);

            System.out.println();
            if(result.length != 3){
                System.err.println("result.length <> 3, is " + result.length);
            }
            long l = -900;
            try {
                l = Long.parseLong(result[2]);
                System.err.println("long l = " + l);
            } catch (Exception nfe) {
                System.err.println("NumberFormatException: " + nfe.getMessage());
            }
            return l;


        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int readingsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> readings = IntStream.range(0, readingsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        Result.calcMissing(readings);

        bufferedReader.close();
    }
}
