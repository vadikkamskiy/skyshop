package org.skypro.skyshop.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SearchServiceTest {

    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testSearch_WhenNoData_ReturnsEmptyList() {
        
        when(storageService.getSearchables()).thenReturn(List.of());

        List<SearchResult> result = searchService.search("wine");

        assertTrue(result.isEmpty());
    }

    @Test
    void testSearch_WhenNotFound_ReturnTrue(){
        Searchable prod1 = mock(Searchable.class);
        when(prod1.getSearchTerm()).thenReturn("beer");

        Searchable prod2 = mock(Searchable.class);
        when(prod2.getSearchTerm()).thenReturn("wine");

        Searchable prod3 = mock(Searchable.class);
        when(prod3.getSearchTerm()).thenReturn("whiskey");

        when(storageService.getSearchables()).thenReturn(List.of(prod1,prod2,prod3));

        List<SearchResult>  result = searchService.search("moonshine");
        assertTrue(result.isEmpty(),"List is totally empty");
    }

    @Test
    void testSearch_WhenFound_ReturnTrue(){
        Searchable prod1 = createSearchableMock("Cold Beer", "Drink", "beer");
        Searchable prod2 = createSearchableMock( "Red Wine", "Alcohol", "wine");
        Searchable prod3 = createSearchableMock( "Whiskey", "Spirit", "whiskey");

        when(storageService.getSearchables()).thenReturn(List.of(prod1, prod2, prod3));

        List<SearchResult> result = searchService.search("beer");
        assertTrue(!result.isEmpty(),"found it");
    }

    private Searchable createSearchableMock(String name, String type, String searchTerm) {
        Searchable mock = mock(Searchable.class);
        when(mock.getId()).thenReturn(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));
        when(mock.getName()).thenReturn(name);
        when(mock.getType()).thenReturn(type);
        when(mock.getSearchTerm()).thenReturn(searchTerm);
        return mock;
    }
}
