package com.Incentro.MicroservicesUsers.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Incentro.MicroservicesUsers.Model.User;


public interface UserRepository extends JpaRepository<User, String>{

}
