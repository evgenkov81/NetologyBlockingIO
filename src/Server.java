import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        while (true) {
            try (ServerSocket servSocket = new ServerSocket(30555);
                 Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                String line;
                long number;
                while ((line = in.readLine()) != null) {
                    if (line.equals("end"))
                        break;
                    else
                        number = Long.parseLong(line);
                    if (number <= 0) {
                        out.println("Enter a number greater than 0");

                    } else if (number == 1) {
                        out.println(number + " term of the Fibonacci series is 1 ");
                    } else if (number == 2) {
                        out.println(number + " term of the Fibonacci series is 1 ");
                    } else {
                        long a = 1;
                        long b = 1;
                        for (long i = 3; i <= number; ++i) {
                            long next = a + b;
                            a = b;
                            b = next;
                        }
                        out.println(number + " term of the Fibonacci series is " + b);
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}//The BlockingIO interaction method was chosen because we cannot
// start the calculation of the sequence
// until we know the number up to which we should count.
