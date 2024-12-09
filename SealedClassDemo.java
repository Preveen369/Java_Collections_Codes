// Sealed classes/interfaces: These classes/interfaces limit which classes or interfaces can inherit from them, 
// ensuring only specified classes/interfaces can extend or implement them.
// Non-sealed classes/interfaces: These classes/interfaces remove restrictions for further inheritance, making them 
// flexible within a controlled hierarchy.
// Final classes: These classes prevent any further inheritance, closing off that branch in the hierarchy.

// A sealed class must contain 'sealed' keyword and the 'permits' clause
// 'permits' clause must be the last, after 'extends' & 'implements' clause 

// SEALED CLASSES:

sealed class A extends Thread implements Cloneable permits B, C {
    // A could be directly inherited only B and C classes
    // while other classes not able to inherit A class
}

// sub-class extending a sealed class can have either:
// 'sealed'/'non-sealed'/'final' keyword
// sub-interface extending a sealed interface can have either only:
// 'sealed'/'non-sealed' keyword

non-sealed class B extends A {
    // B and C classes only could extend A class
    // B class can be accessed by any other classes
}

final class C extends A {
    // B and C classes could only extend A class
}

class D extends B {
    // D (any) class can access B class
}

// SEALED INTERFACES:

sealed interface X permits Y {
    // X could be directly inherited only Y interface
    // while other interfaces/classes not able to inherit/implement X
}

non-sealed interface Y extends X {
    // Y could be directly inherited/implemented by any interfaces/classes
    // Y interface only could extend X interface
}

class W implements Y {
    // W (any) class could implement Y interface
}

interface Z extends Y {
    // Z (any) interface could extend Y interface
}

public class SealedClassDemo {
    public static void main(String[] args) {

    }
}
