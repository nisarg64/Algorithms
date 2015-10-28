
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
public class StackWithIncOps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int[] array = new int[count+1];
        int pointer = 0;
        StringBuffer str = new StringBuffer();
        for(int i=0;i<count; i++){
            String instruction  = scanner.nextLine();

            if(instruction.contains("push")){
                String value = instruction.substring(5, instruction.length());

                array[pointer] = Integer.parseInt(value);
                pointer++;

            }else if(instruction.contains("pop")){
                pointer--;

            }else if(instruction.contains("inc")) {

                String[] splited = instruction.split(" ");
                int add = Integer.parseInt(splited[2]);
                int firstN = Integer.parseInt(splited[1]);

                for (int x = 0; x < firstN; x++) {
                    array[x] = array[x] + add;
                }

            }
            if(pointer > 0)
                str.append(array[pointer-1]);
            else {
                pointer = 0;
                str.append("EMPTY");
            }
            str.append("\n");
        }
        System.out.println(str.toString());
    }

}

