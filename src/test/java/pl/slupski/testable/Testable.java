package pl.slupski.testable;

import org.springframework.stereotype.Service;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */

public abstract class Testable<T> {

    public abstract T randomize(boolean save);
}
