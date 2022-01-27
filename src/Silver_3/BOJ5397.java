package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5397 {
    static class Stack {
        int pos = 0;
        int countOfData = 0;
        char[] array = null;

        public Stack(int size) {
            array = new char[size];
        }

        public char pop() {
            countOfData--;
            char rData = array[--pos];
            array[pos] = 0;
            return rData;
        }

        public void push(char c) {
            array[pos++] = c;
            countOfData++;
        }

        public boolean isEmpty() {
            return (countOfData == 0);
        }

        public int size() {
            return countOfData;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[] input = null;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            input = br.readLine().toCharArray();
            sb.append(keylog(input)).append('\n');
        }

        System.out.println(sb);
    }

    private static String keylog(char[] input) {
        Stack keylogger = new Stack(input.length);
        Stack tmpInputs = new Stack(input.length);

        for(int i=0; i<input.length; i++) {
            switch (input[i]) {
                case '<':
                    if (keylogger.size() == 0) break;
                    tmpInputs.push(keylogger.pop()); break;

                case '>':
                    if (tmpInputs.isEmpty()) break;
                    keylogger.push(tmpInputs.pop()); break;

                case '-':
                    if (keylogger.isEmpty()) break;
                    keylogger.pop();
                    break;

                default:
                    keylogger.push(input[i]);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!tmpInputs.isEmpty()) keylogger.push(tmpInputs.pop());
        while (!keylogger.isEmpty()) sb.append(keylogger.pop());
        return sb.reverse().toString();
    }
}

