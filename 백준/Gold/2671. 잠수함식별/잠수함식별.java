import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();

        String regex = "^(100+1+|01)+$";
    	boolean flag = Pattern.matches(regex, sound);
    	
        if(flag == true) System.out.print("SUBMARINE");
    	else System.out.print("NOISE");
    }
}