# Nested Classes


We will talk about four kinds of nested class here: local classes, anonymous classes,
inner classes, and static nested classes.

One of the main reasons to use any nested class instead of declaring a public class
in its own file is encapsulation, which is one of the pillars of Object Oriented
Programming. The idea here is to scope the nested class to the scope where it is
needed and not expose it outside a given scope if it is not needed outside that scope.

## Local Class

A local class is a class defined inside a method and it is scoped to that 
method. You cannot use it outside the method. For an example, see NestedClassExperiment. 
 You might use such a class if you _only_ need the class inside the method.
 Such a local class could be useful if you need a class that helps with some kind
 of intermediary work being performed by a method.

 
## Anonymous Class

An anonymous class is a class not given a name and both 
declared and instantiated in a single statement.


Anonymous classes were often used in the past as a way to pass a function as an 
argument into another method because Java did not have lambda expressions until Java 8.
Thus they had things like the Runnable interface. A method can accept an instance of 
Runnable
as an argument, and thus you can pass a method by defining the method inside 
a Runnable, declared and defined anonymously in place, as in NestedClassExperiment.

## Inner Class

An inner class is a non-static class defined at the member level of another class, 
called the outer class. Unlike top-level classes, an inner class can be declared
private. 

An instance of an inner class is associated with an instance of its enclosing class. It has 
direct access to the outer class instance's members, and you should use an inner class
instead of a static nested class specifically if you _need_ access to the outer class instance
variables.

Because an inner class requires an association with an instance of the outer class, 
it cannot be created statically. That is, it has to be created from an instance of 
the outer class. The syntax for this is 

```nestedClassExperiment.new MyInnerClass()```.



## Static Nested Classes

A static nested class is a class defined at the member level of
the outer class and declared static. Such a class does not have 
access to the non-static member variables of the outer class. It _does_ have
access to static members of the outer class, even if they are declared
private. 

An example of using a static nested class is the builder pattern. A builder
for the outer class can be defined as a static member of the outer class. In
this case the builder can access a private constructor of the outer class. 
See MyImmutableObject for an example.
