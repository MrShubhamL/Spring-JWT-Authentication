package com.security.services;

import com.security.dtos.SignupRequest;
import com.security.entities.Customer;
import com.security.enums.UserRole;
import com.security.respositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createCustomer(SignupRequest signupRequest) {
        // Checking user is existed or not
        if(customerRepository.existsByEmail(signupRequest.getEmail())){
            return false;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(signupRequest, customer);
        // Hash the password
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        customer.setRole(UserRole.CUSTOMER);
        customerRepository.save(customer);
        return true;
    }
}
