package DAL;

import BL.Recipe;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RecipeRepository extends EntMngClass implements RecipeInterface {

    @Override
    public void create(Recipe u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Recipe u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Recipe u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Recipe> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("Recipe.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Recipe findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM Recipe p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (Recipe) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
