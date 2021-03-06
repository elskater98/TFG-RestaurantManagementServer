package com.tfg.server.repository;

import com.tfg.server.domain.Encarrec;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;


@RepositoryRestResource(excerptProjection = Encarrec.class)
public interface EncarrecRepository extends CrudRepository<Encarrec, UUID> {
    Encarrec findByClientAndDateStringAndHour(String client,String date,String hour);
    //Encarrec findByClientUUID(String uuid);
    List<Encarrec> findByDateString(String id);
}
