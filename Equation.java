package equation_handling;
/*
 Brendan Aucoin
 2018/04/01
 this is a utility class that calculates the x value by subbing in values for a given x value and returns the corrisponding
 y value.
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Equation {
	public static int amount = 10;
	public static Number calculate(String equation,double x) throws ScriptException {
		/*for numbers that are right next to x*/
		for(int i=0; i < 100; i++) {
			equation = equation.replace(i+"x", i + "*x");
			equation = equation.replace(i + "sin",i + "*sin");
			equation = equation.replace(i + "pi",i + "*pi");
			equation = equation.replace(i + "cos",i + "*cos");
			equation = equation.replace(i + "tan",i + "*tan");
			equation = equation.replace(i + "sec",i + "*sec");
			equation = equation.replace(i + "csc",i + "*csc");
			equation = equation.replace(i + "cot",i + "*cot");
			equation = equation.replace(i + "sqrt",i + "*sqrt");
			equation = equation.replace(i + "abs",i + "*abs");
			equation = equation.replace(i + "ln",i + "*log");
			equation = equation.replace(i + "random",i + "*random");
		}
		/*for power functions*/
		for(int i=0; i < 100; i++) {
			String str = String.valueOf(i);
			equation = equation.replace("x^" + str, "Math.pow(x," + str + ")");
		}
		
		
		/*for everything else*/
		if(!equation.contains("sqrt") || !equation.contains("ln")) {
			for(int i=0; i > -100; i--) {
				equation = equation.replace("x^" + i, "Math.pow(x," + i + ")");
				equation = equation.replace(i + "sin",i + "*sin");
				equation = equation.replace(i + "pi",i + "*pi");
				equation = equation.replace(i + "cos",i + "*cos");
				equation = equation.replace(i + "tan",i + "*tan");
				equation = equation.replace(i + "sec",i + "*sec");
				equation = equation.replace(i + "csc",i + "*csc");
				equation = equation.replace(i + "cot",i + "*cot");
				equation = equation.replace(i + "sqrt",i + "*sqrt");
				equation = equation.replace(i + "abs",i + "*abs");
				equation = equation.replace(i + "ln",i + "*log");
				equation = equation.replace(i + "random",i + "*random");
			}
		}
		/*basic math*/
		equation = equation.replace("-","-1*");
		equation = equation.replace("pix", "pi*x");
		equation = equation.replace("pi",String.valueOf(Math.PI));
		
		equation = equation.replace("sin", "Math.sin");
		equation = equation.replace("cos", "Math.cos");
		equation = equation.replace("tan", "Math.tan");
		equation = equation.replace("csc", "1/Math.sin");
		equation = equation.replace("sec", "1/Math.cos");
		equation = equation.replace("cot", "1/Math.tan");
		equation = equation.replace("ln", "Math.log");
		equation = equation.replace("sqrt", "Math.sqrt");
		equation = equation.replace("abs", "Math.abs");
		equation = equation.replace("random", "Math.random");
		equation = equation.replace("y", "");
		equation = equation.replace("=", "");
		equation =equation.replace("x",String.valueOf(x));
		
	    /*check if you use powers like quadratic*/
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine js = mgr.getEngineByName("JavaScript");
	    Number y =null;
	    y = (Number)(js.eval(equation));
	    if(y == null){return 0;}
	    else{return y;}
	  }
}
