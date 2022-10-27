package com.dio.project.stay.repository;

import com.dio.project.stay.domain.QUserAccount;
import com.dio.project.stay.domain.UserAccount;
import com.dio.project.stay.dto.UserAccountDto;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.swing.text.html.Option;
import java.util.Optional;

@RepositoryRestResource
public interface UserAccountRepository extends JpaRepository<UserAccount, String>,
        QuerydslPredicateExecutor<UserAccount>, QuerydslBinderCustomizer<QUserAccount> {

    @Override
    default void customize(QuerydslBindings bindings, QUserAccount root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.userId,root.userPwd,root.email,root.nickname,root.phone);
        bindings.bind(root.userId).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.userPwd).first(StringExpression::contains);
        bindings.bind(root.email).first(StringExpression::contains);
        bindings.bind(root.nickname).first(StringExpression::contains);
        bindings.bind(root.phone).first(StringExpression::contains);
    }

    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByUserId(String userId);
    void deleteByUserId(String userId);

}