package com.hitruong.profile.repository;

import com.hitruong.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM Profile p " +
            "WHERE p.email = :#{#email} AND p.isDeleted = false")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT p FROM Profile p WHERE p.email = :email AND p.id = :id AND p.isDeleted = false")
    Optional<Profile> findByEmailAndId(@Param("email") String email, @Param("id") Long id);
}
