package com.example.crm.service;

import com.example.crm.dao.InteractionsRepository;
import com.example.crm.entities.Interactions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InteractionsServiceTest {

    @Mock
    private InteractionsRepository interactionsRepository;

    @InjectMocks
    private InteractionsService interactionsService;

    private Interactions interaction1, interaction2, interaction3;

    @BeforeAll
    static void setupAll() {
        System.out.println("Before all InteractionsService tests...");
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.out.println("Before each test...");

        interaction1 = new Interactions();
        interaction1.setId(1L);
        interaction1.setType("Call");
        interaction1.setNotes("Follow-up call with Ramesh Kumar about renewal.");
        interaction1.setDate(LocalDate.of(2024, 6, 15));

        interaction2 = new Interactions();
        interaction2.setId(2L);
        interaction2.setType("Email");
        interaction2.setNotes("Sent proposal to Shraddha Patil for premium plan.");
        interaction2.setDate(LocalDate.of(2024, 7, 10));

        interaction3 = new Interactions();
        interaction3.setId(3L);
        interaction3.setType("Meeting");
        interaction3.setNotes("In-person meeting with Parneet Singh to discuss upgrade.");
        interaction3.setDate(LocalDate.of(2024, 8, 5));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all InteractionsService tests...");
    }

    @Test
    void testAddInteraction() {
        when(interactionsRepository.save(interaction1)).thenReturn(interaction1);

        Interactions saved = interactionsService.addInteraction(interaction1);

        assertNotNull(saved);
        assertEquals("Call", saved.getType());
        assertEquals("Follow-up call with Ramesh Kumar about renewal.", saved.getNotes());
    }

    @Test
    void testGetAllInteractions() {
        when(interactionsRepository.findAll()).thenReturn(Arrays.asList(interaction1, interaction2, interaction3));

        List<Interactions> interactions = interactionsService.getAllInteractions();

        assertNotNull(interactions);
        assertEquals(3, interactions.size());
        assertTrue(interactions.contains(interaction2));
    }

    @Test
    void testGetInteractionById_Found() {
        when(interactionsRepository.findById(2L)).thenReturn(Optional.of(interaction2));

        Interactions found = interactionsService.getInteractionById(2L);

        assertNotNull(found);
        assertEquals("Email", found.getType());
        assertTrue(found.getNotes().contains("Shraddha Patil"));
    }

    @Test
    void testGetInteractionById_NotFound() {
        when(interactionsRepository.findById(9L)).thenReturn(Optional.empty());

        Interactions notFound = interactionsService.getInteractionById(9L);

        assertNull(notFound);
    }

    @Test
    void testUpdateInteraction_Found() {
        when(interactionsRepository.findById(1L)).thenReturn(Optional.of(interaction1));
        when(interactionsRepository.save(any(Interactions.class))).thenReturn(interaction2);

        Interactions updated = interactionsService.updateInteraction(1L, interaction2);

        assertNotNull(updated);
        assertEquals("Email", updated.getType());
        assertTrue(updated.getNotes().contains("Shraddha Patil"));
    }

    @Test
    void testUpdateInteraction_NotFound() {
        when(interactionsRepository.findById(9L)).thenReturn(Optional.empty());

        Interactions result = interactionsService.updateInteraction(9L, interaction3);

        assertNull(result);
    }

    @Test
    void testDeleteInteraction() {
        interactionsService.deleteInteraction(1L);
        verify(interactionsRepository, times(1)).deleteById(1L);
    }
}
