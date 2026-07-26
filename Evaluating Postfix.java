/*It evaluates a postfix expression*/


import java.util.*;
class EvPost
{
    static Stack<Double> stack = new Stack<Double>();
    boolean operand(char ch)
    {
        return Character.isLetterOrDigit(ch);
    }
    boolean opr(char ch)
    {
        return (ch=='+')||(ch=='-')||(ch=='/')||(ch=='*')||(ch=='^');
    }
    double evaluate(char[] E)
    {
        int i;
        for(i=0; i< E.length; i++)
        {
            char c = E[i];
            int p= (int)c -48;
            if(operand(c))
                stack.push((double)p);
            else if(opr(c))
            {
                double y=stack.pop(), x=stack.pop();
                switch(c)
                {
                    case '+':
                        stack.push(x+y);
                    break;
                    case '-':
                        stack.push(x-y);
                    break;
                    case '*':
                        stack.push(x*y);
                    break;
                    case '/':
                        stack.push(x/y);
                    break;
                    case '^':
                        stack.push(Math.pow(x,y));
                    break;
                    default:
                        System.out.println("Invalid Expression");
                        System.exit(1);
                }
            }
        }
        return stack.pop();
    }
    public static void main()
    {
        EvPost OP = new EvPost();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a postfix expression");
        String exp = sc.nextLine();
        char[] carray = exp.toCharArray();
        double res= OP.evaluate(carray);
        System.out.printf("Result= %.3f", res);
    }
}
