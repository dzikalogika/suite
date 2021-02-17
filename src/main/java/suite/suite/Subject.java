package suite.suite;

import suite.suite.util.Sequence;
import suite.suite.util.Series;
import suite.suite.util.Glass;
import suite.suite.util.Browser;

import java.util.function.Supplier;

@SuppressWarnings("UnusedReturnValue")
public abstract class Subject implements Sub {

    protected final int origin;

    public Subject(int origin) {
        this.origin = origin;
    }

    public Subject() {
        this.origin = hashCode();
    }

    protected abstract Subject materialize();
    protected abstract Subject materialize(Object element);
    protected abstract Subject jump();
    protected abstract Subject jump(Object element);
    protected abstract boolean real(Object element);

    public abstract Subject first();
    public abstract Subject last();
    public abstract Subject get(Object element);
    public Subject get(Object... elements) {
        return getAll(Sequence.of(elements)).set();
    }
    public abstract Object direct();
    public abstract <B> B asExpected();
    public abstract <B> B as(Class<B> requestedType);
    public abstract <B> B as(Glass<? super B, B> requestedType);
    public abstract <B> B as(Class<B> requestedType, B reserve);
    public abstract <B> B as(Glass<? super B, B> requestedType, B reserve);
    public abstract <B> B orGiven(B reserve);
    public abstract <B> B orDo(Supplier<B> supplier);
    public abstract boolean is(Class<?> type);
    public abstract boolean present();
    public abstract boolean present(Object element);
    public abstract boolean absent();
    public abstract boolean absent(Object element);
    public abstract int size();
    public abstract Browser iterator(boolean reverse);
    public Browser iterator() {
        return iterator(false);
    }
    public Series front() {
        throw new UnsupportedOperationException("Solid method");
    }
    public Series reverse() {
        throw new UnsupportedOperationException("Solid method");
    }

    public abstract Subject set(Object element);
    public abstract Subject exactSet(Object aim, Object element);
    public Subject set(Object key, Object value, Object ... rest) {
        return inset(key, Suite.set(value, rest));
    }
    public Subject exactSet(Object aim, Object key, Object value, Object... rest) {
        return exactInset(aim, key, Suite.set(value, rest));
    }
    public abstract Subject inset(Object element, Subject $set);
    public abstract Subject exactInset(Object aim, Object element, Subject $set);
    public Subject put(Object element) {
        return set(new Suite.Auto(), element);
    }
    public Subject exactPut(Object aim, Object element) {
        return exactSet(aim, new Suite.Auto(), element);
    }
    public Subject put(Object value, Object ... rest) {
        return inset(new Suite.Auto(), Suite.set(value, rest));
    }
    public Subject exactPut(Object aim, Object value, Object... rest) {
        return exactInset(aim, new Suite.Auto(), Suite.set(value, rest));
    }
    public Subject input(Subject $set) {
        return inset(new Suite.Auto(), $set);
    }
    public Subject exactInput(Object target, Subject $set) {
        return exactInset(target, new Suite.Auto(), $set);
    }
    public abstract Subject shift(Object out, Object in);
    public abstract Subject unset();
    public abstract Subject unset(Object element);
    public Subject sate(Object element) {
        throw new UnsupportedOperationException("Solid method");
    }
    public Subject sate(Object element, Subject $set) {
        throw new UnsupportedOperationException("Solid method");
    }
    public Subject take(Object element) {
        throw new UnsupportedOperationException("Solid method");
    }
    public Subject take(Object... elements) {
        return takeAll(Sequence.of(elements)).set();
    }
    public Subject alter(Iterable<? extends Subject> iterable) {
        throw new UnsupportedOperationException("Solid method");
    }
    public Subject exactAlter(Object sequent, Iterable<? extends Subject> iterable) {
        throw new UnsupportedOperationException("Solid method");
    }

    public Subject merge(Subject $tree) {
        for(var $ : $tree) {
            var $at = $.at();
            if($at.present()) {
                in($.direct()).merge($at);
            } else {
                sate($.direct());
            }
        }
        return this;
    }

    public Series getAll(Iterable<?> iterable) {
        throw new UnsupportedOperationException("Solid method");
    }
    public Subject setAll(Iterable<?> iterable) {
        for(Object it : iterable) {
            set(it);
        }
        return this;
    }
    public Subject putAll(Iterable<?> iterable) {
        for(Object it : iterable) {
            put(it);
        }
        return this;
    }
    public Subject unsetAll(Iterable<?> iterable) {
        for(Object it : iterable) {
            unset(it);
        }
        return this;
    }
    public Series takeAll(Iterable<?> iterable) {
        throw new UnsupportedOperationException("Solid method");
    }
    @Override
    public Subject set() {
        return this;
    }
    @Override
    public Subject get() {
        return this;
    }

    abstract Subject separate();
    public Subject print() {
        System.out.println(Suite.describe(this));
        return this;
    }

    @Override
    public String toString() {
        return "$" + Integer.toHexString(hashCode());
    }

    public int asInt() {
        return as(Number.class).intValue();
    }

    public byte asByte() {
        return as(Number.class).byteValue();
    }

    public long asLong() {
        return as(Number.class).longValue();
    }

    public long asShort() {
        return as(Number.class).shortValue();
    }

    public float asFloat() {
        return as(Number.class).floatValue();
    }

    public double asDouble() {
        return as(Number.class).doubleValue();
    }

    public char asChar() {
        return as(Character.class);
    }

    public boolean asBoolean() {
        return as(Boolean.class);
    }

    public String asString() {
        return as(String.class);
    }

    public int asInt(int reserve) {
        return as(Number.class, reserve).intValue();
    }

    public byte asByte(byte reserve) {
        return as(Number.class, reserve).byteValue();
    }

    public long asLong(long reserve) {
        return as(Number.class, reserve).longValue();
    }

    public long asShort(short reserve) {
        return as(Number.class, reserve).shortValue();
    }

    public float asFloat(float reserve) {
        return as(Number.class, reserve).floatValue();
    }

    public double asDouble(double reserve) {
        return as(Number.class, reserve).doubleValue();
    }

    public char asChar(char reserve) {
        return as(Character.class, reserve);
    }

    public boolean asBoolean(boolean reserve) {
        return as(Boolean.class, reserve);
    }

    public String asString(String reserve) {
        return as(String.class, reserve);
    }
}
