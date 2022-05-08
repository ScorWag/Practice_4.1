import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    public void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateFortRegisteredAndMinAmountWithBonus() {
        BonusService service = new BonusService();

        long amount = 33_34;
        boolean registered = true;
        long expected = 1;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateFortRegisteredAndMinAmountNotBonus() {
        BonusService service = new BonusService();

        long amount = 33_33;
        boolean registered = true;
        long expected = 0;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateFortNotRegisteredAndMinAmountWithBonus() {
        BonusService service = new BonusService();

        long amount = 100_00;
        boolean registered = false;
        long expected = 1;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateFortNotRegisteredAndMinAmountNotBonus() {
        BonusService service = new BonusService();

        long amount = 99_99;
        boolean registered = false;
        long expected = 0;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


}