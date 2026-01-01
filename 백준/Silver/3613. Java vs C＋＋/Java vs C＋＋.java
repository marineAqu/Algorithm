import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        StringBuilder sb = new StringBuilder();

        //대문자가 들어있으면 자바
        //언더바가 있으면 C++
        
        if(a.charAt(0) < 97 || a.charAt(a.length()-1) == '_' || a.contains("__")){
            System.out.print("Error!");
            System.exit(0);
        }

        if(a.contains("_")){ //C++
            boolean c = false;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i) == '_'){
                    c = true;
                    continue;
                }

                if(a.charAt(i) < 97){
                    System.out.print("Error!");
                    System.exit(0);
                }

                if(c){
                    sb.append((char) (a.charAt(i) - 32));
                }
                else{
                    sb.append(a.charAt(i));
                }

                c = false;
            }
        }

        else{
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i) < 97){
                    sb.append('_');
                    sb.append((char)(a.charAt(i) + 32));
                }
                else sb.append(a.charAt(i));
            }
        }

        System.out.print(sb);
    }
}