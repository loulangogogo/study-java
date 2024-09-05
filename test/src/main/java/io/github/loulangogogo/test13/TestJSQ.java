package io.github.loulangogogo.test13;

/*********************************************************
 ** 解释器模式测试
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestJSQ {
    public static void main(String[] args) {
        // 创建表达式树
        Expression expr1 = new NumberExpression(5);
        Expression expr2 = new NumberExpression(10);
        Expression addExpr = new AddExpression(expr1, expr2); // 5 + 10
        Expression subtractExpr = new SubtractExpression(addExpr, new NumberExpression(6)); // (5 + 10) - 6

        // 解释表达式
        System.out.println("结果: " + subtractExpr.interpret());
    }
}

/*********************************************************
 ** 加法表达式，非终结符表达式
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class AddExpression extends Expression {
    private Expression expr1;
    private Expression expr2;

    public AddExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    int interpret() {
        return expr1.interpret() + expr2.interpret();
    }
}

/*********************************************************
 ** 减法表达式，非终结符表达式
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class SubtractExpression extends Expression {
    private Expression expr1;
    private Expression expr2;

    public SubtractExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    int interpret() {
        return expr1.interpret() - expr2.interpret();
    }
}

/*********************************************************
 ** 数字表达式，终结符表达式
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class NumberExpression extends Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    int interpret() {
        return number;
    }
}

/*********************************************************
 ** 表达式抽象类
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
abstract class Expression {
    abstract int interpret();
}
