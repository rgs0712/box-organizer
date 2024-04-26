package br.com.rgs.boxorganizer.repositories;

import br.com.rgs.boxorganizer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
