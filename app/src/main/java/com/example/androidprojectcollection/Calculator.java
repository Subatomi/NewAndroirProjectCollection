package com.example.androidprojectcollection;

import java.util.Stack;

public class Calculator {
    private Stack<Character> operatorStack;
    private String postfix;

    private double result = 0;


    public String Calculate(String solutionText) {
        operatorStack = new Stack<>();

        // Convert infix to postfix
        infixToPostfix(solutionText);

        return evaluatePostfix();
    }

    public String CalculateSequence(String solutionText){
        String[] sqc = solutionText.split("\\s+");

        double x = Double.parseDouble(sqc[0]);;
        char y = sqc[1].charAt(0);
        double z = Double.parseDouble(sqc[2]);
        return evaluateSeq(x,y,z);
    }

    private String evaluateSeq( double operand1, char operator, double operand2) {
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    return "Error: Division by zero!";
                }
                result = operand1 / operand2;
                break;
        }

        return String.valueOf(result);
    }

    public void infixToPostfix(String solutionText) {
        StringBuilder postfixExpression = new StringBuilder();
        String[] sqc = solutionText.split("\\s+");
        for (String sqc1 : sqc) {
            char c = sqc1.charAt(0);
            if (Character.isDigit(c)) {
                postfixExpression.append(sqc1).append(" ");
            } else if (isOperator(c)) {

                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfixExpression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop()).append(" ");
        }

        postfix = postfixExpression.toString().trim();
    }


    private String evaluatePostfix() {
        if (postfix == null || postfix.isEmpty()) {
            throw new IllegalArgumentException("Postfix expression is empty");
        }

        Stack<Double> operandStack = new Stack<>();
        String[] elements = postfix.split("\\s+");
        for (String element : elements) {
            if (isNumeric(element)) {
                operandStack.push(Double.parseDouble(element));
            } else if (isOperator(element.charAt(0))) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for operator");
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(operand1, operand2, element.charAt(0));
                operandStack.push(result);
            }
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return String.valueOf(operandStack.pop());
    }


    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}

