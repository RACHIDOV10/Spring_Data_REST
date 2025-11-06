package com.example.DataREST.repositories;

import com.example.DataREST.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "clients",collectionResourceRel = "clients",itemResourceRel ="client")
public interface ClientRepository extends JpaRepository<Client,Long> {
}
