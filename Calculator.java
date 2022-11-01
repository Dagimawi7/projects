import java.util.Scanner;

public class Calculator {
    /*  The class represents a simple calculactor that can be used as interactive mode and 
    non intercative mode*/
    public static void main(String[] args) {
        /* main method doesn't change and it looks for the main method when java is lauched. 
        the method should contan either 3 or 0 arguments. 3 making it non-intercative mode 
        which takes a form like" java Calculator 2 x 3" to give out a soloution and 0 being 
        an intercative mode where you input the operatin and the numbers you like the get 
        results from the calculator.*/

        if (args.length == 3) { // 3 arguments which takes it to non intercativec mode

            double number1 = Double.parseDouble(args[0]); // first input intinalization as a double take both int and float
            String op = (args[1]);
            double number2 = Double.parseDouble(args[2]); // second input intinalization as a double take both int and float
            double result;
            if (op.equals("+")) {
                result = number1 + number2;
                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
                // addtion
            } else if (op.equals("-")) {
                result = number1 - number2;
                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
                // substraction
            } else if (op.equals("x")) {
                result = number1 * number2;
                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
                // mulitplaction
            } else if ((op.equals("xx"))) {
                result = Math.pow(number1, number2);
                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
                // power
            } else if (op.equals("/")) {
                result = number1 / number2;
                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
                // divison
            } else if (op.equals("%")) {
                result = number1 % number2;
                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
                // mode

                //prints the output
            }

        } else if (args.length == 0) {

                double num1; // first input intinalization as a double take both int and float
                double num2; // second input intinalization as a double take both int and float
                Scanner scanner = new Scanner(System.in); // scanner taking num input from the user 

                System.out.print("Enter an operator (+, -, x, /,xx,%): "); // asks for opreator
                String operator = scanner.next(); // takes the asked operator 
                double outPut; // sets the output 

                System.out.print("Enter first number:"); // asks for the first number
                num1 = scanner.nextDouble(); // stores the first numbver
                System.out.print("Enter second number:"); // asks for the second number
                num2 = scanner.nextDouble(); // sotres the second number
                scanner.close(); // closes the scanner 

                if (num2 == 0) {
                    System.out.println("Wrong value!. The divisor cannot be zero. Please try again.");
                    // num 2 can't be zero
                }

                switch (operator) {
                case "+":
                    outPut = num1 + num2;
                    break;
                    // addtion 

                case "-":
                    outPut = num1 - num2;
                    break;
                    // substion 

                case "x":
                    outPut = num1 * num2;
                    break;
                    // multiplaction

                case "/":
                    outPut = num1 / num2;
                    break;
                    // divison

                case "xx":
                    outPut = Math.pow(num1, num2);
                    break;
                    // power

                case "%":
                    outPut = num1 % num2;
                    break;
                    // mode

                default:
                    System.out.printf("You have entered wrong operator");
                    return;
                    // a statment for returning the wrong operator 
                }

                System.out.println(num1 + " " + operator + " " + num2 + " = " + outPut);
                // prints out the calculated answer
            }

        }

    }
