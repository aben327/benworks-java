package benworks.java.util._volatile;

// public class BackgroundFloobleLoader {
// public volatile Flooble theFlooble;
//
// public void initInBackground() {
// // do lots of stuff
// theFlooble = new Flooble(); // this is the only write to theFlooble
// }
// }
//
// public class SomeOtherClass {
// public void doWork() {
// while (true) {
// // do some stuff...
// // use the Flooble, but only if it is ready
// if (floobleLoader.theFlooble != null)
// doSomething(floobleLoader.theFlooble);
// }
// }
// }