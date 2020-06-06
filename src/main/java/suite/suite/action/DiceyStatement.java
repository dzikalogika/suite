package suite.suite.action;

import suite.suite.Subject;
import suite.suite.Suite;

@FunctionalInterface
public interface DiceyStatement extends Action {

    void strive() throws Exception;

    default Subject play() {
        try {
            strive();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Suite.set();
    }

    default Subject play(Subject in) {
        try {
            strive();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Suite.set();
    }

    default Subject gamble() throws Exception {
        strive();
        return Suite.set();
    }

    default Subject gamble(Subject in) throws Exception {
        strive();
        return Suite.set();
    }
}
