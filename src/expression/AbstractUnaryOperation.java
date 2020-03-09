package expression;

import expression.operations.Operator;

abstract class AbstractUnaryOperation<T extends Number> implements TripleExpression<T> {
    TripleExpression<T> arg;
    Operator<T> operator;

    AbstractUnaryOperation(TripleExpression<T> arg, Operator<T> operator) {
        this.arg = arg;
        this.operator = operator;
    }

    String toString(String operand) {
        return operand + "(" + arg.toString() + ")";
    }
}
