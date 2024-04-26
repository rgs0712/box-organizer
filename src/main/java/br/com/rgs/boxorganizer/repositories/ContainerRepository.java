package br.com.rgs.boxorganizer.repositories;

import br.com.rgs.boxorganizer.entities.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
}
