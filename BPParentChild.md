# Parent Child Inheritance Note

The classes badprogramming.Child and badprogramming.Parent illustrate 
a tricky point that comes up on interviews. In this example the Child
class extends the Parent class. Parent has a member method called `speak()`
and Child also overrides that method.

When executing the program, we create an instance of Child and call
a Parent method on it, `doSomething()`. The `doSomething()` method declares
a Parent-type variable and assigns it to the Child instance. Then, it
calls `speak()` on this variable. Thus, `speak()` is called on the Child
instance from inside the Parent class. The question is then, which `speak()` 
method is executed?

Executing the Child class's `main` method illustrates that this operation
executes the Child object's `speak` method. This is an example of polymorphism's 
dynamic method lookup. Despite the variable being declared as a Parent, 
upon calling `speak()`, Java dynamically looks up the `speak` method of the 
actual object.

I call this bad programming because it seems to be written specifically to 
obfuscate and confuse the reader.

