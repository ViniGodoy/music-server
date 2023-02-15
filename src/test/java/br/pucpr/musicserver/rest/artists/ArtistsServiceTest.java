package br.pucpr.musicserver.rest.artists;

import br.pucpr.musicserver.lib.exception.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static br.pucpr.musicserver.rest.artists.ArtistStub.artistStub;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArtistsServiceTest {
    private ArtistsRepository repository;
    private ArtistsService service;

    @BeforeEach
    public void setup() {
        repository = mock(ArtistsRepository.class);
        service = new ArtistsService(repository);
    }

    @Test
    public void addShouldCallSaveIfHasAnArtist() {
        var artist = artistStub(null);

        var savedArtist = new Artist();
        savedArtist.setId(1L);
        savedArtist.setName("artists");
        savedArtist.setGenres(Set.of("Blues"));

        when(repository.save(any())).thenReturn(savedArtist);

        var ret = service.add(artist);
        assertNotNull(ret.getId());
        assertEquals(savedArtist, ret);
    }

    @Test
    public void addShouldThrowBadRequestWhenNull() {
        assertThrows(BadRequestException.class, () -> {
            service.add(null);
        });
    }

    @Test
    public void addShouldThrowBadRequestWhenIdNotNull() {
        var artist = artistStub(1L);

        assertThrows(BadRequestException.class, () -> {
            service.add(artist);
        });
    }
}
