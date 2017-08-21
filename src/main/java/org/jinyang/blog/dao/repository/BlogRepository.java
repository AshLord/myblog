package org.jinyang.blog.dao.repository;

import org.jinyang.blog.dao.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yang.jin on 21/08/2017.
 */
public interface BlogRepository extends JpaSpecificationExecutor<BlogEntity>,CrudRepository<BlogEntity,Long> {

}
