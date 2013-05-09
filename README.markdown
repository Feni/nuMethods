# nuMethods #
**nuMethods** is a Java package of Numerical Methods to find roots, aproximate derivatives and integrals and solve initial value problems. 

---------------------------------------


##Equation Solvers ##
Finds roots for single variable equations.

- Bisection
- Fixed point iteration
- Newton's Method


## Function Approximation ##
Given a table of observed points for a function, interpolate the value of the function at some new point. 

- Nevills Method


## Derivative Methods ##
Given a "function" object or table of regularly spaced points approximating f, calculate it's derivative f' at a given point. 

-  forward/backward Difference
-  3 Point end point formula
-  3 Point mid point formula

## Integration Methods ##
Calculates the area under a function's curve. 

- Trapezoidal Rule
- Simpsons Rule
- Composite Simpsons Rule
- Romberg


## Initial Value Problem solver ##
Give y' = f(t, y) with t ranging from a to b and y(a) = alpha, approximate the function y. 
  
- Eulers Method

---------------------------------------

The code can be invoked by running the appropriate JUnit test (TestAprox, TestDiff, TestIVP, TestIntegration or TestRoot) or making a new main method with your own code. 

All code is based off of pseudo-code algorithms proposed in the book _"Numerical Analysis"_, 9th Edition by Richard L. Burden and J. Douglas Faires.
 
Feel free to use, modify and redistribute the code in any way. 
