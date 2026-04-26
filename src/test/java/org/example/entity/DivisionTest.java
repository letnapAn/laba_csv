package org.example.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Division Tests")
class DivisionTest {

    @Test
    @DisplayName("Should generate unique IDs sequentially")
    void shouldGenerateUniqueIds() {
        Division div1 = new Division("IT");
        Division div2 = new Division("HR");

        assertNotEquals(div1.getId(), div2.getId());
        assertTrue(div2.getId() > div1.getId());
    }

    @Test
    @DisplayName("Should equal by ID")
    void shouldEqualById() {
        Division div1 = new Division("IT");
        Division div2 = new Division("IT");

        assertNotEquals(div1, div2); // разные ID
        assertEquals(div1, div1);    // тот же объект
    }
}