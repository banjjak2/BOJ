package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String notation = br.readLine();
        List<String> listNotation = new ArrayList<>();

        for(int i=0; i<notation.length(); i++) {
            listNotation.add(String.valueOf(notation.charAt(i)));
        }

        double[] operand = new double[N];
        for(int i=0; i<N; i++) {
            operand[i] = Double.parseDouble(br.readLine());
        }

        convAlphabetToNumber(operand, listNotation);

        char chr = ' ';
        Stack<Double> stack = new Stack<>();
        double op1 = 0;
        double op2 = 0;
        for(int i=0; i<listNotation.size(); i++) {
            chr = listNotation.get(i).charAt(0);
            if (Character.isDigit(chr)) {
                stack.push(Double.parseDouble(listNotation.get(i)));
            }
            else {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(calculate(op1, op2, chr));
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }

    private static void convAlphabetToNumber(double[] operand, List<String> listNotation) {
        char chr = ' ';
        for(int i=0; i<operand.length; i++) {
            for(int j=0; j<listNotation.size(); j++) {
                chr = listNotation.get(j).charAt(0);
                if (chr >= 'A' && chr <= 'Z') {
                    if (chr == 'A' + i) {
                        listNotation.set(j, String.valueOf(operand[i]));
                    }
                }
            }
        }
    }

    private static double calculate(double op1, double op2, char operator) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            default:
                return op1 / op2;
        }
    }
}
