# Nested Classes

What are nested classes, and why and when would you use them?

# Local Class

A local class is a class defined inside a method and it is scoped to that 
method. You cannot use it outside the method. For an example, see NestedClassExperiment. 
 You might use such a class if you _only_ need the class inside the method.
 
# Anonymous Class

Anonymous classes were often used in the past as a way to pass a function as an 
argument into another method because Java did not have lambda expressions until Java 8.
Thus they had things like the Runnable interface. A method can accept an instance of Runnable
as an argument, and thus you can pass a method by defining a Runnable anonymously in place, 
as in NestedClassExperiment.

# Inner Class

An instance of an inner class is associated with an instance of its enclosing class. It has 
direct access to the outer class instance's members, and you should use an inner class
instead of a static nested class specifically if you _need_ access to the outer class instance
variables.



# Static Nested Classes

An instance of a static nested class interacts with an instance of the outer class just like any 
top level class. 