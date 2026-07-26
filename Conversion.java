/*Converts any infix expression to postfix, and evaluates them using EvPost class */


import java.util.*;
class INFtoPOST 
{
    static Stack<Character> stack= new Stack<Character>();
    boolean operand(char ch)
    {
        return Character.isLetterOrDigit(ch);
    }
    boolean opr(char ch)
    {
        return (ch=='+')||(ch=='-')||(ch=='/')||(ch=='*')||(ch=='^');
    }
    int preceedance(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
                return 2;
            case '/': 
                return 3;
            case '^':
                return 4;
            default: 
                System.out.println("Invalid");
                System.exit(1);
                return 0;
        }
    }
    char[] convert(char[] cha)
    {
        char x[]=new char[cha.length +20];
        int i,j=0;
        char a,b;
        for(i=0; i< cha.length; i++)
        {
            a=cha[i];
            if(operand(a))
                x[j++]=a;
            else
            {
                while(!stack.empty() && preceedance(a)>=preceedance(stack.peek()) && a!='(')
                {
                    b=stack.pop();
                    if(b=='(')
                        break;
                    if(a!='(')
                        x[j++]=b;
                }
                stack.push(a);
            }
            if(a==')')
                stack.push(a);
        }
        while(!stack.empty())
            x[j++]=stack.pop();
        return x;
    }
    public static void main()
    {
        System.out.println("Enter an infix expression");
        String exp= (new Scanner(System.in)).nextLine();
        char[] store = exp.toCharArray();
        char[] res= (new INFtoPOST()).convert(store);
        for(int i=0; i< res.length; i++)
            if(res[i]!='\u0000')
                System.out.print(res[i]);
        if(Character.isDigit(store[0]))
            System.out.println("\nAnswer= "+(new EvPost()).evaluate(res));
    }
}
