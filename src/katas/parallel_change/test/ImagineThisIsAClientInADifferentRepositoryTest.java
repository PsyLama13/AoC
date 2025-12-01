package katas.parallel_change.test;

import katas.parallel_change.main.field.ImagineThisIsAClientInADifferentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImagineThisIsAClientInADifferentRepositoryTest {

    @Test
    public void singleItem_numberOfProductsInTheCart() {
        ImagineThisIsAClientInADifferentRepository client = new ImagineThisIsAClientInADifferentRepository();
        Assertions.assertEquals("Total price is 50 euro", client.formattedTotalPrice(50));
    }

}