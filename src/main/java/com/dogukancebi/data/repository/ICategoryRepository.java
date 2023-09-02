package com.dogukancebi.data.repository;

import com.dogukancebi.data.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoRepository extends JpaRepository<ToDoEntity, Long> {
    // İhtiyaca göre özel sorgular veya işlemler ekleyebilirsiniz.
}
