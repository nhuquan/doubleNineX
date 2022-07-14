package com.example.doubleNineX.domain.calc;

import com.example.doubleNineX.domain.model.ProductImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PriceEngineTest {

    private static final ProductImpl PENGUIN = new ProductImpl("Penguin-ears", 20, 175.0);
    private static final double EXPECTED_PRICE_ONE_UNIT = (PENGUIN.cartonPrice() / PENGUIN.itemPerCarton()) * 1.3;

    @Test
    void calcPrice_zero_unit() {
        // Prepare
        PriceCalculator pe = new PriceEngine();
        double expectedPrice = 0;

        // Do
        double price = pe.calcPrice(PENGUIN, 0);

        // Check
        assertThat(price).isEqualTo(expectedPrice);
    }

    @Test
    void calcPrice_negative_quantity_should_throw_exception() {
        // Prepare
        PriceCalculator pe = new PriceEngine();

        // Do & check
        assertThatThrownBy(() -> {
            pe.calcPrice(PENGUIN, -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PriceEngine.QUANTITY_SHOULD_BE_POSITIVE_NUMBER);
    }

    @Test
    void calcPrice_1_single_unit() {
        // Prepare
        PriceCalculator pe = new PriceEngine();

        // Do
        double price = pe.calcPrice(PENGUIN, 1);

        // Check
        assertThat(price).isEqualTo(EXPECTED_PRICE_ONE_UNIT);
    }

    @Test
    void calcPrice_1_carton() {
        // Prepare
        PriceCalculator pe = new PriceEngine();
        double expectedPrice = PENGUIN.cartonPrice();

        // Do
        double price = pe.calcPrice(PENGUIN, PENGUIN.itemPerCarton());

        // Check
        assertThat(price).isEqualTo(expectedPrice);
    }

    @Test
    void calcPrice_2_carton_and_3_single_unit() {
        // Prepare
        PriceCalculator pe = new PriceEngine();
        double expectedPrice = PENGUIN.cartonPrice() * 2 + EXPECTED_PRICE_ONE_UNIT * 3;

        // Do
        double price = pe.calcPrice(PENGUIN, 2 * PENGUIN.itemPerCarton() + 3);

        // Check
        assertThat(price).isEqualTo(expectedPrice);
    }

    @Test
    void calcPrice_3_carton_and_1_single_unit() {
        // Prepare
        PriceCalculator pe = new PriceEngine();
        double expectedPrice = PENGUIN.cartonPrice() * PriceEngine.DISCOUNT_RATE * PriceEngine.DISCOUNT_QUANTITY
                + EXPECTED_PRICE_ONE_UNIT * PriceEngine.DISCOUNT_RATE;

        // Do
        double price = pe.calcPrice(PENGUIN, 3 * PENGUIN.itemPerCarton() + 1);

        // Check
        assertThat(price).isEqualTo(expectedPrice);
    }
}