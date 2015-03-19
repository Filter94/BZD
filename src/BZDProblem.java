import java.io.IOException;
import java.util.Scanner;

public class BZDProblem {
    final static int PARAMS_NUMBER = 11;
    final static int PARAM_PARTS = 3;
    double params[][] = new double [PARAMS_NUMBER][PARAM_PARTS];
    final static double WEIGHTS[] = {12, 22, 6, 12 ,8, 10, 12, 5, 4.2, 2.2, 6.6};
    final static double WEIGHTS_SUM = 70.;
    double Ps[] = new double [PARAMS_NUMBER];


    public void readParameters(Scanner in) throws IOException{
        for (int i = 0; i < PARAMS_NUMBER; i ++){
            for (int j = 0; j < PARAM_PARTS; j ++){
                params[i][j] = in.nextDouble();
            }
        }
    }

    public double solveFirstProblem() {
        double P = 0;
        double Pi;
        for (int i = 0; i < PARAMS_NUMBER; i ++){
            Pi = (params[i][1] + (100 - params[i][1])*params[i][0]/100);
            Ps[i] = Pi;
            P += Pi * WEIGHTS[i];
        }
        P /= WEIGHTS_SUM;
        return P;
    }

    public double solveSecondProblem() {
        double Ki;
        double K = 0;
        double Ks[] = new double [PARAMS_NUMBER];
        for (int i = 0; i < PARAMS_NUMBER; i ++){
            Ki = (params[i][2]) * WEIGHTS[i];
            Ks[i] = Ki;
            K += Ki;
        }
        double Bs[] = new double [PARAMS_NUMBER];
        double BsSum = 0;
        double Bi;
        for (int i = 0; i < PARAMS_NUMBER; i ++){
            Bi = Ks[i] / K;
            Bs[i] = Bi;
            BsSum += Bi;
        }
        double P = 0;
        for (int i = 0; i < PARAMS_NUMBER; i ++){
            P += Ps[i] * Bs[i] / BsSum;
        }
        return P;
    }
}
