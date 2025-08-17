package com.example.crm.controller;

import com.example.crm.entities.Interactions;
import com.example.crm.service.InteractionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InteractionsControllerTest {

    @Mock
    private InteractionsService interactionService;

    @InjectMocks
    private InteractionsController interactionsController;

    private Interactions interaction1;
    private Interactions interaction2;
    private Interactions interaction3;

    @BeforeEach
    void setUp() {
        interaction1 = new Interactions();
        interaction1.setId(1L);
        interaction1.setType("Call");
        interaction1.setNotes("Discussed requirements with Shraddha Prabhu");
        interaction1.setDate(LocalDate.of(2024, 6, 10));

        interaction2 = new Interactions();
        interaction2.setId(2L);
        interaction2.setType("Email");
        interaction2.setNotes("Sent proposal to Sharika KR");
        interaction2.setDate(LocalDate.of(2024, 7, 5));

        interaction3 = new Interactions();
        interaction3.setId(3L);
        interaction3.setType("Meeting");
        interaction3.setNotes("Project kickoff with Swizal Janice");
        interaction3.setDate(LocalDate.of(2024, 8, 1));
    }

    @Test
    void testAddInteraction() {
        when(interactionService.addInteraction(interaction1)).thenReturn(interaction1);

        Interactions result = interactionsController.addInteraction(interaction1);

        assertNotNull(result);
        assertEquals("Call", result.getType());
        assertTrue(result.getNotes().contains("Shraddha Prabhu"));
    }

    @Test
    void testGetAllInteractions() {
        List<Interactions> interactions = Arrays.asList(interaction1, interaction2, interaction3);
        when(interactionService.getAllInteractions()).thenReturn(interactions);

        List<Interactions> result = interactionsController.getAllInteractions();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Meeting", result.get(2).getType());
        assertTrue(result.get(1).getNotes().contains("Sharika KR"));
    }

    @Test
    void testGetInteractionById() {
        when(interactionService.getInteractionById(3L)).thenReturn(interaction3);

        Interactions result = interactionsController.getInteractionById(3L);

        assertNotNull(result);
        assertEquals("Meeting", result.getType());
        assertTrue(result.getNotes().contains("Swizal Janice"));
    }

    @Test
    void testUpdateInteraction() {
        when(interactionService.updateInteraction(2L, interaction2)).thenReturn(interaction2);

        Interactions result = interactionsController.updateInteraction(2L, interaction2);

        assertNotNull(result);
        assertEquals("Email", result.getType());
        assertTrue(result.getNotes().contains("Sharika KR"));
    }

    @Test
    void testDeleteInteraction() {
        interactionsController.deleteInteraction(1L);
        verify(interactionService, times(1)).deleteInteraction(1L);
    }
}
