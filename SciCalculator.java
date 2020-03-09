import java.util.Scanner;

public class SciCalculator {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int menuOption = 0;
        String first;
        String second;
        double firstOperand = 0;
        double secondOperand = 0;
        double currentResult = 0;
        double sumOfCalculation = 0;
        int numOfCalculation = 0;
        double averageCalculation = 0;

        while (true) {
            System.out.println("Current Result: " + currentResult);
            System.out.println("Calculator Menu \n--------------- \n0. Exit Program \n1. Addition \n2. Subtraction");
            System.out.println("3. Multiplication \n4. Division \n5. Exponentiation \n6. Logarithm \n7. Display Average");
            System.out.print("Enter Menu Selection: ");
            menuOption = scnr.nextInt();
            //only print out average if there have already been previous calculations
            while (menuOption < 0 || menuOption > 6) {
                if (menuOption == 7) {
                    if (numOfCalculation > 0) {
                        averageCalculation = sumOfCalculation / numOfCalculation;
                        averageCalculation = Math.round(averageCalculation * 100.0) / 100.0;
                        System.out.println("Sum of calculations: " + sumOfCalculation);
                        System.out.println("Number of calculations: " + numOfCalculation);
                        System.out.println("Average of calculations: " + averageCalculation);
                        System.out.print("Enter Menu Selection: ");
                        menuOption = scnr.nextInt();
                    }
                    else {
                        System.out.println("Error: No calculations yet to average!");
                        System.out.print("Enter Menu Selection: ");
                        menuOption = scnr.nextInt();
                    }
                }
                else {
                    System.out.println("Error: Invalid selection!");
                    System.out.print("Enter Menu Selection: ");
                    menuOption = scnr.nextInt();
                }
            }
            //if user inputs a number that is not on the menu it will print out an error
            if (menuOption < 0 || menuOption > 7) {
                System.out.println("Error: Invalid selection!");
                System.out.print("Enter Menu Selection: ");
                menuOption = scnr.nextInt();
            }

            if (menuOption == 0) {
                System.out.println("Thanks for using this calculator. Goodbye!");
                break;
            }
            //if user inputs "RESULT", previous answer will be utilized as the first/second operand
            if (menuOption != 0) {
                System.out.print("Enter first operand: ");
                first = scnr.next();
                if (first.equals("RESULT")) {
                    firstOperand = currentResult;
                } else {
                    double firstDouble = Double.parseDouble(first);
                    firstOperand = firstDouble;
                }
                System.out.print("Enter second operand: ");
                second = scnr.next();
                if (second.equals("RESULT")) {
                    secondOperand = currentResult;
                } else {
                    double secondDouble = Double.parseDouble(second);
                    secondOperand = secondDouble;
                }
                //depending on the menu, the mathematical operation will be executed
                if (menuOption == 1) {
                    currentResult = firstOperand + secondOperand;
                }
                else if (menuOption == 2) {
                    currentResult = firstOperand - secondOperand;
                }
                else if (menuOption == 3) {
                    currentResult = firstOperand * secondOperand;
                }
                else if (menuOption == 4) {
                    currentResult = firstOperand / secondOperand;
                }
                else if (menuOption == 5) {
                    currentResult = Math.pow(firstOperand, secondOperand);
                }
                else if (menuOption == 6) {
                    currentResult = Math.log(secondOperand) / Math.log(firstOperand);
                }
            }
            //update total sum of calculations and increment number of calculations done
            sumOfCalculation = sumOfCalculation + currentResult;
            numOfCalculation += 1;
        }
    }
}
