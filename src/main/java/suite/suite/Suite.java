package suite.suite;

import java.util.Iterator;
import java.util.Objects;

public final class Suite {

    public static class AutoKey {
        @Override
        public String toString() {
            return "#";
        }
    }

    public static final Object OK = new Object();

    public static Subject set() {
        return new SolidSubject();
    }
    public static Subject set(Object element) {
        return new SolidSubject(new BubbleSubject(element));
    }
    public static Subject set(Object key, Object value) {
        return new SolidSubject(new CoupleSubject(key, value));
    }
    public static Subject add(Object element) {
        return new SolidSubject(new ArraySubject().add(element));
    }
    public static Subject insetAll(Iterable<Subject> source) {
        return new SolidSubject(ZeroSubject.getInstance().insetAll(source));
    }
    public static Subject setAll(Iterable<Object> source) {
        return new SolidSubject(ZeroSubject.getInstance().setAll(source));
    }
    public static Subject addAll(Iterable<Object> source) {
        return new SolidSubject(ZeroSubject.getInstance().addAll(source));
    }

    public static Subject ok() {
        return new SolidSubject(new BubbleSubject(OK));
    }

    public static boolean isOk(Subject subject) {
        return subject.get(OK).settled();
    }

    public static Subject error(Object cause) {
        return new SolidSubject(new CoupleSubject("error", cause));
    }

    public static Subject fuse(Subject subject) {
        if(subject == null) {
            return Suite.set();
        } else if(subject.fused()) {
            return subject;
        } else {
            return new SolidSubject(new FuseSubject(subject));
        }
    }

    public static Subject thready() {
        return new ThreadySubject();
    }

    public static Query from(Subject sub) {
        return new Query(sub);
    }

    public static Subject zip(Iterable<Object> keys, Iterable<Object> values) {
        Iterator<Object> keyIt = keys.iterator();
        Iterator<Object> valIt = values.iterator();
        Subject subject = Suite.set();
        while (keyIt.hasNext() && valIt.hasNext()) {
            subject.set(keyIt.next(), valIt.next());
        }
        return subject;
    }

}
