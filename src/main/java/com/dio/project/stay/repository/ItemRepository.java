package com.dio.project.stay.repository;

import com.dio.project.stay.domain.Item;
import com.dio.project.stay.domain.QItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long>,
        QuerydslPredicateExecutor<Item>, QuerydslBinderCustomizer<QItem> {

    List<Item> findByUserAccount_Id(Long userAccountId);

    @Override
    default void customize(QuerydslBindings bindings, QItem root){
        bindings.excludeUnlistedProperties(true);
    }

    Page<Item> findByItemAddrContaining(String search_keyword, Pageable pageable);
}