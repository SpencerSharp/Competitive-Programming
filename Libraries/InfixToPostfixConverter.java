import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

/*
    This is a simple Infix to postfix converter program.

    The Expression class manages the expressions and is really the heart of
    the program, everything else is just for the string manipulation and
    creation of expression objects.

    The various "out.println" statements throughout the method just make it easier
    to understand how the program works, I initially used them for debugging purposes.

    One thing to note about this program is that two operations cannot be on the same
    level the way the program currently works. It is, however, rather trivial to change
    this if you want to by editing the "isFirstOperationHigherPrecedenceThanSecondOperation"
    method, and the comments for that method have given an example of how to do that.

    Another important note to make is that this program is designed to use variables as
    single characters. A great way to ensure that you truly understand how this
    works is to go through the code and make it work with String variables instead
    of simply char variables.
*/
public class InfixToPostfixConverter
{
    
    /*
    The Expression class
    
    An expression object can be in two states. It either contains two expressions,
    or is simply a basal variable.
    
    If it is two expressions:
        Initial, operation, and second should be set to something
        isSimplyACharacter will be false
        simplyChar should be null
    
    If it is a variable:
        Initial, operation and second should be null
        isSimplyACharacter will be true
        simplyChar should be set to something
    */
    static class Expression
    {
        Expression initial;
        char operation;
        Expression second;
        
        char simplyChar;
        boolean isSimplyACharacter;
        
        public Expression()
        {
            isSimplyACharacter = false;
        }
        
        public Expression(char c)
        {
            setChar(c);
        }
        
        void setInitial(Expression e)
        {
            initial = e;
        }
        
        void setOperation(char o)
        {
            operation = o;
        }
        
        void setSecond(Expression e)
        {
            second = e;
        }
        
        void setChar(char c)
        {
            isSimplyACharacter = true;
            simplyChar = c;
        }
        
        /*
        Changing this to having the operation before the initial or second will
        make the entire program work as a Infix to prefix converter instead.
        
        For example:
        
        return operation + "" + initial + second;
        
        instead of "return initial + "" + second + operation;"
        */
        public String toString()
        {
            if(isSimplyACharacter)
                return ""+simplyChar;
            return initial + "" + second + ""+operation;
        }
    }
    
    
    
    /*
    This is the list of the operations from lowest precedence to highest precedence.
    
    If you want to, you can just change this array and the entire rest of the program
    will compensate to the new order of precedence and list of operations you've chosen.
    */
    static char[] operations = {'+','-','/','*','^'};
    
    public static void main(String[] args) throws IOException
    {
        String output = ""; //Write all output to this string

        //Code here
        
        //Simple testing
        
        String input = "((a+t)*((b+(a+c))^(c+d)))";
        output = ""+makeExpressionOfString(input);
        out.println(output);
        
        
        //Reading from a file for numerous expressions
        /*
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        int numExpressions = Integer.parseInt(f.readLine());
        for(int i = 0; i < numExpressions; i++)
        {
            String input = f.readLine();
            output = ""+makeExpressionOfString(input);
            out.println(output);
        }
        */
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    /*
    This method takes in a string and returns an Expression.
    
    Pretty self explanatory.
    */
    public static Expression makeExpressionOfString(String s)
    {
        //out.println(s);
        
        Expression ret = new Expression();
        
        /*
        This loop just sees if we've recursed all the way down to there being
        a single variable as all of the string
        */
        if(!doesContainOperation(s)) 
        {
            //This code is just here cuz there's extra "("s and ")"s that screw stuff up otherwise
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if(c >= 'a' && c <= 'z')
                    ret.setChar(c);
            }
            return ret;
        }
        /*
        This block of code just splits the String based on the highest order
        of precedence operator, and calls THIS METHOD WE'RE IN on both of those
        split up strings.
        */
        int indexOfHighestPrecedenceOperationInString = getIndexOfHighestPrecedenceOperationInString(s);
        String initExpressionString = s.substring(0,indexOfHighestPrecedenceOperationInString);
        String secondExpressionString = s.substring(indexOfHighestPrecedenceOperationInString+1);
        Expression initExpression = makeExpressionOfString(initExpressionString);
        Expression secondExpression = makeExpressionOfString(secondExpressionString);
        char operation = s.charAt(indexOfHighestPrecedenceOperationInString);
        
        
        /*
        Puts the stuff we just found into ret.
        */
        ret.setInitial(initExpression);
        ret.setSecond(secondExpression);
        //out.println(operation);
        ret.setOperation(operation);
        
        //out.println("RET"+ret);
        
        return ret;
    }
    
    /*
    Checks if a string has an operation character within it
    */
    public static boolean doesContainOperation(String s)
    {
        for(int i = 0; i < s.length(); i++)
            if(isOperation(s.charAt(i)))
                return true;
        return false;
    }
    
    /*
    This method determines what the highest precedence operator in a string is.
    It does this by counting the "depth" an operation is at (levels of parenthesis undergone),
    and taking the one that has the shallowest "depth" that is the highest precedence.
    
    A little hard to explain, but the code is pretty self explanatory.
    */
    public static int getIndexOfHighestPrecedenceOperationInString(String s)
    {
        int curLevel = 0;
        int index = 0;
        char resultOp = 'd';
        int resultLevel = 500;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                curLevel++;
            }
            else if(c==')')
            {
                curLevel--;
            }
            else if(isOperation(c))
            {
                if(curLevel < resultLevel)
                {
                    resultLevel = curLevel;
                    resultOp = c;
                    index = i;
                }
                else if(curLevel==resultLevel)
                {
                    if(isFirstOperationHigherPrecedenceThanSecondOperation(c,resultOp))
                    {
                        resultLevel = curLevel;
                        resultOp = c;
                        index = i;
                    }
                }
            }
        }
        return index;
    }
    
    /*
    This is the method that is used to determine the precedence of different
    operations. It is built thinking that ^ > / > * > + > -.
    
    It would be pretty easy to change that logic by using switch statements
    and setting the "ind1" and "ind2" values that way, you could put + and -
    to the same result of ind.
    */
    public static boolean isFirstOperationHigherPrecedenceThanSecondOperation(char op1, char op2)
    {
        int ind1 = -1;
        int ind2 = -1;
        int index = 0;
        for(char op : operations)
        {
            if(op1==op)
                ind1 = index;
            index++;
        }
        index = 0;
        for(char op : operations)
        {
            if(op2==op)
                ind2 = index;
            index++;
        }
        return ind1 > ind2;
    }
    
    /*
    Checks if a character is in the operations array
    */
    public static boolean isOperation(char c)
    {
        for(char op : operations)
            if(c==op)
                return true;
        return false;
    }
}