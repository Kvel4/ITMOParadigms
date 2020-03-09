package expression;


import expression.operations.Operator;

abstract class AbstractBinaryOperation<T extends Number> implements TripleExpression<T> {
    TripleExpression<T> arg1, arg2;
    Operator<T> operator;

    AbstractBinaryOperation(TripleExpression<T> arg1, TripleExpression<T> arg2, Operator<T> operator) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.operator = operator;
    }

    String toString(String operand) {
        return "(" + arg1.toString() + " " + operand + " " + arg2.toString() + ")";
    }
}
