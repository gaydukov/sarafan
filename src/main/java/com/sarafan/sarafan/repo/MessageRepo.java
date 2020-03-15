package com.sarafan.sarafan.repo;

import com.sarafan.sarafan.domian.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
