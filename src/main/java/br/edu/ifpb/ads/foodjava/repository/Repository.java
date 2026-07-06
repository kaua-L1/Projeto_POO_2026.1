package br.edu.ifpb.ads.foodjava.repository;
import java.util.List;

public interface Repository<T> {
    
	void salvar(T obj);
    
	T buscar(int id);
    
	List<T> listar();
    
	void remover(int id);
}
