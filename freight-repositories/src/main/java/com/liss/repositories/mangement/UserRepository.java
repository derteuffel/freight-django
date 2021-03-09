package com.liss.repositories.mangement;

import com.liss.entities.management.RoleEntity;
import com.liss.entities.management.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT user FROM User as user INNER JOIN  user.role WHERE user.login = :username")
    UserEntity findByUsername(@Param("username") String username);

    /*** les user pour une compagnie **/
    @Query("SELECT user FROM User user WHERE user.company.id = :companyID AND TRIM(UPPER(user.name)) LIKE TRIM(UPPER(CONCAT('%',:name,'%')))")
    Page<UserEntity> getUsers(@Param("companyID")String companyID, @Param("name")String name, Pageable pageableRequest);

    @Query("from Role r where r.code =:code ")
    RoleEntity findByCode(@Param("code")String code);

    @Query("from User user where user.login=:login")
    UserEntity getUserByLogin(@Param("login")String login);
}
