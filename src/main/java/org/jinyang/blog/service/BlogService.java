package org.jinyang.blog.service;

import org.jinyang.blog.common.objects.JPage;
import org.jinyang.blog.common.objects.PageParams;
import org.jinyang.blog.dao.entity.BlogEntity;
import org.jinyang.blog.dao.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yang.jin on 21/08/2017.
 */
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<BlogEntity> queryByLabel(String label){
        return blogRepository.queryByLabel(label);
    }
    public JPage<BlogEntity> queryAll(PageParams pageParams) {
        Specification<BlogEntity> specification = where(pageParams);
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(pageParams.getOffset() / 10, pageParams.getiDisplayLength(), sort);
        Page<BlogEntity> page = blogRepository.findAll(specification, pageable);
        List<BlogEntity> listTotal = blogRepository.findAll(specification);
        List<BlogEntity> list = page.getContent();

        return new JPage<BlogEntity>(listTotal.size(), list);
    }

    public void insert(BlogEntity entity) {
        blogRepository.save(entity);
    }

    public BlogEntity queryOne(long id) {
        return blogRepository.findOne(id);
    }

    public void update(BlogEntity entity) {
        entity.setUpdateTime(new Date());
        blogRepository.save(entity);
    }

    @Transactional
    public void delete(long id) {
        blogRepository.delete(id);
    }

    /**
     * 动态生成where语句
     *
     * @param pageParams
     * @return
     */
    private Specification<BlogEntity> where(final PageParams pageParams) {
        return new Specification<BlogEntity>() {
            @Autowired
            public Predicate toPredicate(Root<BlogEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();
                String version = pageParams.getParams().get("version").toString();
                if (version != null && !"".equals(version)) {
                    // predicates.add(cb.equal(root.get("version"), version));
                    predicates.add(cb.like(root.<String> get("version"), "%" + version + "%"));
                }
                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };

    }
}
