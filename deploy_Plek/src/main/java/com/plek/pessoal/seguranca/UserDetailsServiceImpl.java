package com.plek.pessoal.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plek.pessoal.model.Usuario;
import com.plek.pessoal.repository.usuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private usuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> user = userRepository.findByEmailUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));

		return user.map(UserDetailsImpl::new).get();
	}
}
