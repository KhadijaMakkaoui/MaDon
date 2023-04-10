package com.madon.demo;

import com.madon.demo.entity.Dons;
import com.madon.demo.repository.DonsRepo;
import com.madon.demo.service.DonsService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DonsServiceTest {
    @Autowired
    private DonsRepo donsRepo;

    @Autowired
    private DonsService donsService;

    @Test
    public void testCreateDonsWithValidMontant() {
        // Create a new Dons object with a montant greater than 0
        Dons dons = new Dons();

        // Call the createDons method and get the result
        Dons result = donsService.createDons(dons);

        // Check that the result is not null
        assertNotNull(result);


        // Check that the Dons object was saved to the database
        assertTrue(donsRepo.findById(result.getId()).isPresent(), "Dons object was not saved to the database");
    }
    @Test
    public void testCreateDonsWithInvalidMontant() {
        // Create a new Dons object with a montant of 0
        Dons dons = new Dons();
        dons.setMontant(0.0);

        // Call the createDons method and get the result
        Dons result = donsService.createDons(dons);

        // Check that the result is null
        assertNull(result);

        // Check that the Dons object was not saved to the database

        assertFalse(donsRepo.findById(result.getId()).isPresent());

    }
}
