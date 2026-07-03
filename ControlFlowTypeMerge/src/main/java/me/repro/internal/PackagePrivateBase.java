// PackagePrivateBase.java  (must NOT be public)
package me.repro.internal;

abstract class PackagePrivateBase implements me.repro.Widget {
    // deliberately does not override doThing() —
    // both concrete subclasses inherit it from here
    public void doThing() {
        System.out.println("done");
    }
}