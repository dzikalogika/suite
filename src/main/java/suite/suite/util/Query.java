package suite.suite.util;

import suite.suite.Subject;
import suite.suite.Suite;
import suite.suite.Vendor;
import suite.suite.action.Action;

import java.util.function.Function;
import java.util.function.Supplier;

public class Query {

    private final Vendor $source;
    private Vendor $result;

    public Query(Subject $source) {
        this.$source = $source;
        this.$result = Suite.set();
    }

    public Query get(Object key) {
        $result = $source.get(key);
        return this;
    }

    public Query get(Object key, Subject $map) {
        $result = $map.get(key);
        return this;
    }

    public Query get(Object key, Action action) {
        $result = action.play($source.get(key));
        return this;
    }

    public<T> Query get(Object key, Class<T> type) {
        var $s = $source.get(key);
        if($s.instanceOf(type)) {
            $result = $s;
        }
        return this;
    }

    public<T> Query get(Object key, Class<T> type, Function<T, Object> function) {
        var $s = $source.get(key);
        if($s.instanceOf(type)) {
            $result = Suite.set(function.apply($s.asExpected()));
        }
        return this;
    }

    public Query or(Object key) {
        return $result.isEmpty() ? get(key) : this;
    }

    public Query or(Object key, Subject $map) {
        return $result.isEmpty() ? get(key, $map) : this;
    }

    public Query or(Object key, Action action) {
        return $result.isEmpty() ? get(key, action) : this;
    }

    public<T> Query or(Object key, Class<T> type) {
        return $result.isEmpty() ? get(key, type) : this;
    }

    public<T> Query or(Object key, Class<T> type, Function<T, Object> function) {
        return $result.isEmpty() ? get(key, type, function) : this;
    }

    public<B> B orGiven(B substitute) {
        return $result.orGiven(substitute);
    }

    public<B> B orDo(Supplier<B> supplier) {
        return $result.orDo(supplier);
    }

    public<B> B orDo(Function<Vendor, B> function) {
        return $result.isEmpty() ? function.apply($source) : $result.asExpected();
    }

    public<B> B asExpected() {
        return $result.asExpected();
    }

    public Object direct() {
        return $result.direct();
    }

    public Query map(Subject $map) {
        $result = $result.convert($ -> $map.at($.direct())).set();
        return this;
    }

    public Query map(Action action) {
        $result = $result.convert(action).set();
        return this;
    }

    public<T> Query map(Class<T> mappedType, Function<T, Object> function) {
        $result = $result.convert($ -> $.instanceOf(mappedType) ?
                Suite.set($.direct(), Suite.set(function.apply($.get().asExpected()))) : $).set();
        return this;
    }
}
