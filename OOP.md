# Object Oriented Programming

The four principles of object oriented programming are inheritance, 
abstraction, polymorphism, and encapsulation.

## Encapsulation

Encapsulation means that an object should maintain its own data 
privately in its internal state. Outside objects should only be 
able to alter the internal state of the object via its exposed
public API. In this way the object enforces rules about how its
state may be changed.

## Inheritance

Inheritance refers to objects being able to inherit and expand 
upon the data and methods of parent objects. Typically a child
object inherits from a parent object if the parent is logically 
a more general object. For example, a child object square could
inherit from a parent object rectangle because a square is a 
rectangle, and every property a rectangle has, so has a square.
But the square expands upon the rectangle and has more restrictions 
on its data: namely that its two side lengths are the same.

## Polymorphism

The polymorphism of Java depends on what's called _dynamic method
lookup_. A variable might be declared with an interface type like 
MyInterface myObject. In this case, myObject could refer to any
object that implements MyInterface. 

The compiler will only let us
call methods on myObject that are declared in the interface. 
However, different objects might implement the declared method
in different ways. The actual method called will be the method
on myObject that implements the method declared in the MyInterface
interface.

In this way we can write powerfully dynamic code by using 
interfaces

## Abstraction

Abstraction is the goal of making the implementation details of
an object invisible to the user. Instead, the object provides a 
simple public interface, and the details behind the interface can
change without having to change the interface.