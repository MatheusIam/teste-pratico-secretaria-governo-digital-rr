package com.matheusiam.crudspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusiam.crudspring.entities.Usuario;
import com.matheusiam.crudspring.repositorios.Usuarios;

@Service
public class UsuarioService {

	@Autowired
	private Usuarios repositorio;
	
	public List<Usuario> acheTodos(){
		return repositorio.findAll();
	}
	
	public Usuario achePorId(Integer id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario salvar (Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar (Integer id) {
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Integer id, Usuario obj) {
		
		Usuario cobaia = repositorio.getReferenceById(id);
		atualizarDados(cobaia, obj);
		
		return repositorio.save(cobaia);
	}
	
	private void atualizarDados(Usuario novo, Usuario antigo) {
		antigo.setCpf(novo.getCpf());
		antigo.setDataNascimento(novo.getDataNascimento());
		antigo.setNome(novo.getNome());
		antigo.setSexo(novo.getSexo());
	}
}
