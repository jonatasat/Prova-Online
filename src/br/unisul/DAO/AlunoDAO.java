package br.unisul.DAO;
import java.util.List;
import br.unisul.javabean.*;
import br.unisul.util.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class AlunoDAO {
	private static EntityManagerFactory emf = (EntityManagerFactory) PersistenceManager.getInstance().getEntityManagerFactory();


	public static void salvar(Aluno aluno){
		EntityManager em = emf.createEntityManager(); 
		try { 
			EntityTransaction t = em.getTransaction(); 
			try { 
				t.begin();
				em.persist(aluno);
				t.commit(); 
			} finally { 
				if (t.isActive()) t.rollback(); 
			} 
		}finally { 
			em.close(); 
		}
	}

	public static List<Aluno> listar(){
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("from Aluno", Aluno.class).getResultList();
		}finally {
			em.close();
		}
	}

	public static Aluno consultarMatricula(Long matricula){
		EntityManager em = emf.createEntityManager();
		Aluno aluno = null;
		try {
			aluno = em.find(Aluno.class, matricula);
		} finally {
			em.close();
		}
		return aluno;
	}


	public static void deletar(Aluno aluno){
		EntityManager em = emf.createEntityManager(); 
		try { 
			EntityTransaction t = em.getTransaction(); 
			try {
				t.begin();
				Object o = em.merge(aluno);
				em.remove(o);
				t.commit(); 
			} finally { 
				if (t.isActive()) t.rollback(); 
			} 
		}finally { 
			em.close(); 
		}
	}
	
	public static List<Aluno> consultarNome(String nome){
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Aluno> query = em.createQuery("from Aluno where NOME = :name", Aluno.class);
			return query.setParameter("name", nome).getResultList();
		}finally {
			em.close();
		}
	}
	
	public static void alterar(Aluno aluno){
		EntityManager em = emf.createEntityManager(); 
		try { 
			EntityTransaction t = em.getTransaction(); 
			try { 
				t.begin();
				em.merge(aluno);
				t.commit(); 
			} finally { 
				if (t.isActive()) t.rollback(); 
			} 
		}finally { 
			em.close(); 
		}
	}
	
	public static boolean consultaLogin(String login, String senha){
		EntityManager em = emf.createEntityManager();
		boolean encontrou=false;
		try {
			TypedQuery<Aluno> query = em.createQuery("from Aluno where LOGIN = :login and SENHA = :senha", Aluno.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			if(query.getSingleResult()==null){
				encontrou=false;
				return encontrou;
			}else{
				encontrou=true;
				return encontrou;
			}
		}finally {
			em.close();
		}
	}
	
}
