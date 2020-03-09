package expression;

import expression.operations.Operator;

public class Negate<T extends Number> extends AbstractUnaryOperation<T> {
    public Negate(TripleExpression<T> arg, Operator<T> operator) {
        super(arg, operator);
    }

    @Override
    public T evaluate(int x, int y, int z) {
        return operator.negate(arg.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return super.toString("-");
    }
}
