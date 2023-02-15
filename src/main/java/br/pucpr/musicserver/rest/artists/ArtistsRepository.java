package br.pucpr.musicserver.rest.artists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByGenre(String genre);
}
