package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nguyennd on 7/21/2014.
 */
public interface CommandRepository extends JpaRepository<Command, Long>{
}
