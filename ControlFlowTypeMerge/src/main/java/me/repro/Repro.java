package me.repro;

import me.repro.internal.WidgetA;
import me.repro.internal.WidgetB;

public class Repro {
    static Widget pick(boolean flag) {
        Widget w = flag ? new WidgetA() : new WidgetB();
        // ^ ternary forces a StackMapTable merge point between
        //   WidgetA and WidgetB — common supertype is PackagePrivateBase
        w.doThing();
        return w;
    }

    static void main(String[] args) {
        pick(true).doThing();
    }
}