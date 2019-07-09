package com.bookstore.service;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.bookstore.domain.security.User;
import com.bookstore.repository.UserRespository;

@Service("UserSecurityService")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserSecurityService implements UserDetailsService{

	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);
	
	@Autowired
	private UserRespository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(null == user) {
			LOG.warn("user not found exception ....");
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
}
