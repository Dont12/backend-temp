package com.fastcampus.reserve.infrestructure.user;

import com.fastcampus.reserve.domain.user.Cart;
import com.fastcampus.reserve.domain.user.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Page<Cart> findByUser(User user, Pageable pageable);
}
