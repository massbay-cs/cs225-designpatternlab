Part 3
======

I've been playing around with the observer design pattern recently.  I'm a big fan of
event-driven concurrency, and the observer design pattern fits nicely with that model.
A change to one property can trigger a change of events that in turn update other
related properties.  JavaFX is particularly good with this, which is what makes it such
a powerful GUI framework.

Looking back at previous projects, many GUIs had windows that were a fixed size.  More
recently I discovered that JavaFX has intrinsic support for observable properties; that
makes it much easier to develop responsive, resizable interface.  One property can be
defined in relation to several other properties, resulting in a dependency tree,
optionally mixed with operations, conditionals, and transformations that act upon the
observables.  I didn't really begin to experiment with observable JavaFX properties until
Project 3.
