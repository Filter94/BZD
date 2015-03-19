import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String paramsFile = "";
        String outputFile = "";
        if (args.length > 0){
            paramsFile = args[0];
            if (args.length > 1){
                outputFile = args[1];
            }
        }
        try {
            Scanner in = new Scanner(System.in);
            if (paramsFile.length() > 0) {
                in = new Scanner(new FileInputStream(paramsFile));
            }
            BZDProblem BZDProblem = new BZDProblem();
            BZDProblem.readParameters(in);
            in.close();
            double firstProblemAnswer;
            double secondProblemAnswer;
            firstProblemAnswer = BZDProblem.solveFirstProblem();
            secondProblemAnswer = BZDProblem.solveSecondProblem();
            DataOutputStream out = new DataOutputStream(System.out);
            if (outputFile.length() > 0) {
                out = new DataOutputStream(new FileOutputStream(outputFile));
            }
            out.writeBytes("Answer on first problem is: ");
            out.writeChars(Double.toString(firstProblemAnswer));
            out.writeBytes("\n");
            out.writeBytes("Answer on second problem is: ");
            out.writeChars(Double.toString(secondProblemAnswer));
            out.writeBytes("\n");
            out.close();
        }
        catch (Exception e){
            System.err.print("Some error.");
        }
    }

}
